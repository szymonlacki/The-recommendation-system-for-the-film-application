package pl.example.netflix.springapp.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.example.netflix.model.Movie;
import pl.example.netflix.model.MovieHelper;
import pl.example.netflix.model.MovieList;
import pl.example.netflix.model.MovieListHelper;
import pl.example.netflix.springapp.dto.MovieListDTO;
import pl.example.netflix.springapp.service.MovieListService;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/netflix/rest/moviesList")
public class MovieListRestController {

    private final MovieListService movieListService;
    @Autowired
    public MovieListRestController(MovieListService movieListService) {
        this.movieListService= movieListService;
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertMovieList(@RequestBody MovieListDTO movieListDTO){
        try {
            System.out.println("\n\n\n\n********************\n " + movieListDTO.getMovies());
            this.movieListService.insertMovieList(movieListDTO);


            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @RequestMapping(value = "/{movie_List_Id}/movie", method = RequestMethod.GET)
    private ResponseEntity  addMovieToCurrentList(@PathVariable("movie_List_Id") Long movie_List_Id,
                                                @RequestParam(value = "id") Long movieId){
        try {
            movieListService.addToCurrentList(movie_List_Id, movieId);
            return new ResponseEntity( HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    private ResponseEntity  getMovieListsByAccountID(@PathVariable("accountId") Long accountId){
        try {
            List<MovieList> movieListDTO = this.movieListService.getMovieListsByAccountID(accountId);

            return new ResponseEntity(movieListDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "movies/{movie_List_Id}", method = RequestMethod.GET)
    private ResponseEntity  getMoviesByMovieListID(@PathVariable("movie_List_Id") Long movie_List_Id){
        try {
            List<Movie> movieDTO = this.movieListService.getMoviesByMovieListID(movie_List_Id);

            return new ResponseEntity(movieDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/quantity/{accountId}", method = RequestMethod.GET)
    private ResponseEntity getNumberOfUserMovieLists(@PathVariable("accountId") Long accountId){
        try {
            double Quantity = this.movieListService.getNumberOfUserMovieLists(accountId);
            return new ResponseEntity(Quantity, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{movieListId}/movie/delete", method = RequestMethod.GET)
    private ResponseEntity  deleteMovieFromMovieList(@PathVariable("movieListId") Long movieListId,
                                                        @RequestParam(value = "id") Long movieId){
        try {
            movieListService.deleteMovieFromMovieList(movieListId, movieId);
            return new ResponseEntity( HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/addLongViewed", method = RequestMethod.GET)
    public ResponseEntity addLongViewedMovie(@RequestParam("movieId") Long movieId, @RequestParam("login") String login) {
        movieListService.addToLongViewedList(movieId, login);
        return new ResponseEntity(HttpStatus.OK);
    }
}
