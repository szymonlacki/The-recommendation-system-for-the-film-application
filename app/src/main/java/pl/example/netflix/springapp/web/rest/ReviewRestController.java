package pl.example.netflix.springapp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.netflix.model.Movie;
import pl.example.netflix.model.Review;
import pl.example.netflix.springapp.dto.RatingDTO;
import pl.example.netflix.springapp.dto.ReviewDTO;
import pl.example.netflix.springapp.service.MovieService;
import pl.example.netflix.springapp.service.RatingService;
import pl.example.netflix.springapp.service.ReviewService;

import java.util.ArrayList;
import java.util.List;


@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/netflix/rest/reviews")
public class ReviewRestController {



    private final ReviewService reviewService;
    private final MovieService movieService;


    @Autowired
    public ReviewRestController(ReviewService reviewService, MovieService movieService) {

        this.reviewService= reviewService;
        this.movieService = movieService;
    }



    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity getReviews(){
        try {
            List<ReviewDTO> reviewDTOList = this.reviewService.getReviews();
            return new ResponseEntity(reviewDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity inserReview(@RequestBody ReviewDTO reviewDTO){

        try {

            this.reviewService.insertReview(reviewDTO);

            return new ResponseEntity(HttpStatus.OK);

        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "movie/{movieId}", method = RequestMethod.GET)
    private ResponseEntity  getReviewsByMovieID(@PathVariable("movieId") Long movieId){
        try {
            List<Review> reviewDTO = this.reviewService.getReviewsByMovieID(movieId);

            return new ResponseEntity(reviewDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "account/{accountId}", method = RequestMethod.GET)
    private ResponseEntity  getReviewsByAccountID(@PathVariable("accountId") Long accountId){
        try {
            List<Review> reviewDTO = this.reviewService.getReviewsByAccountID(accountId);

            return new ResponseEntity(reviewDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "review/{reviewId}", method = RequestMethod.GET)
    private ResponseEntity  getAccountByReviewID(@PathVariable("reviewId") Long reviewId){
        try {
            List<String> reviewDTO = this.reviewService.getAccountByReviewID(reviewId);

            return new ResponseEntity(reviewDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "reviewId/{movieId}", method = RequestMethod.GET)
    private ResponseEntity  getReviewsIdByMovieID(@PathVariable("movieId") Long movieId){
        try {
            ArrayList<Long> reviewListListDTO = this.reviewService.getReviewsIdByMovieID(movieId);

            return new ResponseEntity(reviewListListDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "review/movie/{reviewId}", method = RequestMethod.GET)
    private ResponseEntity  getMovieByReviewId(@PathVariable("reviewId") Long reviewId){
        try {
            List<String> reviewDTO = this.reviewService.getMoviesByReviewID(reviewId);

            return new ResponseEntity(reviewDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
