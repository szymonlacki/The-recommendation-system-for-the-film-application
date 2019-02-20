package pl.example.netflix.springapp.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.netflix.model.Rating;
import pl.example.netflix.springapp.dto.MovieDTO;
import pl.example.netflix.springapp.dto.RatingDTO;
import pl.example.netflix.springapp.service.MovieService;
import pl.example.netflix.springapp.service.RatingService;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/netflix/rest/rating")
public class RatingRestController {

    private final RatingService ratingService;
    private final MovieService movieService;


    @Autowired
    public RatingRestController(RatingService ratingService, MovieService movieService) {
        this.ratingService = ratingService;
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity getRatings(){
        try {
            List<RatingDTO> ratingDTOList = this.ratingService.getRatings();
            return new ResponseEntity(ratingDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity inserRate(@RequestBody RatingDTO ratingDTO){
        try {


            this.ratingService.insertRate(ratingDTO);

            return new ResponseEntity(HttpStatus.OK);

        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Funkcja służąca do obliczenia średniej ocen danego filmu
    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    private ResponseEntity getAverageOfMovie(@PathVariable("movieId") Long movieId){
        try {
            double Average = this.ratingService.getAverageOfMovie(movieId);
            return new ResponseEntity(Average, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Funkcja służąca do obliczenia średniej ocen danego użytkownika
    @RequestMapping(value = "/average/{accountId}", method = RequestMethod.GET)
    private ResponseEntity getAverageOfUserRating(@PathVariable("accountId") Long accountId){
        try {
            double Average = this.ratingService.getAverageOfUserRating(accountId);
            return new ResponseEntity(Average, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/quantity/{accountId}", method = RequestMethod.GET)
    private ResponseEntity getNumberOfUserRatings(@PathVariable("accountId") Long accountId){
        try {
            double Quantity = this.ratingService.getNumberOfUserRatings(accountId);
            return new ResponseEntity(Quantity, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Funkcja służąca sprawdzeniu, czy dany użytkownik ocenił dany film
    // (Ten sam uzytkownik moze ocenić dany film tylko raz)
    @RequestMapping(value = "movie/{accountId}/{movieId}", method = RequestMethod.GET)
    private ResponseEntity getRatedMovieByAccountId(@PathVariable("accountId") Long accountId, @PathVariable("movieId") Long movieId){
        try {
            List<RatingDTO> ratingDTOList = this.ratingService.getRatedMovieByAccountId(accountId,movieId);
            return new ResponseEntity(ratingDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
