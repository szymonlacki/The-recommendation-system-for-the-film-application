package pl.example.netflix.springapp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.netflix.model.Genre;
import pl.example.netflix.model.Movie;
import pl.example.netflix.model.MovieHelper;
import pl.example.netflix.model.Rating;
import pl.example.netflix.springapp.dto.MovieDTO;
import pl.example.netflix.springapp.dto.RatingDTO;
import pl.example.netflix.springapp.service.GenreService;
import pl.example.netflix.springapp.service.MovieService;

import java.util.List;
import java.util.Set;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/netflix/rest/movies")
public class MovieRestController {
    private final MovieService movieService;
    private final GenreService genreService;

    @Autowired
    public MovieRestController(MovieService movieService, GenreService genreService) {
        this.movieService = movieService;
        this.genreService = genreService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity getMovies(){
        try {
            List<MovieDTO> movieDTOList = this.movieService.getMovies();
            return new ResponseEntity(movieDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertMovie(@RequestBody MovieHelper movieHelper){

        try {
            this.movieService.insertMovie(movieHelper);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    private ResponseEntity getMovie(@PathVariable Long movieId){
        try {
            Movie movieDTO= this.movieService.getMovie(movieId);
            return new ResponseEntity(movieDTO,HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.DELETE)
    private ResponseEntity deleteMovie(@PathVariable Long movieId){
        try {
            this.movieService.deleteMovie(movieId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "actor/{actorId}", method = RequestMethod.GET)
    private ResponseEntity getMovieByActorID(@PathVariable("actorId") Long actorID){
        try {
            List<Movie> movieDTO = this.movieService.getMoviesByActorID(actorID);

            return new ResponseEntity(movieDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "genre/{movieId}", method = RequestMethod.GET)
    private ResponseEntity getGenresByMovieID(@PathVariable("movieId") Long movieId){
        try {
            List<Genre> genreDTO = this.movieService.getGenresByMovieID(movieId);


            return new ResponseEntity(genreDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "movie/{genreId}", method = RequestMethod.GET)
    private ResponseEntity  getMoviesByGenreID(@PathVariable("genreId") Long genreId){
        try {
            List<Movie> movieDTO = this.movieService.getMoviesByGenreID(genreId);

            return new ResponseEntity(movieDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "topRated", method = RequestMethod.GET)
    private ResponseEntity getTopRatedMovies(){
        try {
            Set<MovieDTO> movieDTOList = this.movieService.getTopRatedMovies();
            return new ResponseEntity(movieDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "findMovie/{keyWord}", method = RequestMethod.GET)
    private ResponseEntity  findMoviesByKeyWord(@PathVariable("keyWord") String keyWord){
        try {
            List<MovieDTO> movieDTO = this.movieService.findMoviesByKeyWord(keyWord);
            return new ResponseEntity(movieDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
