package pl.example.netflix.springapp.mapper;

import pl.example.netflix.model.Movie;
import pl.example.netflix.model.Rating;
import pl.example.netflix.springapp.dto.RatingDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class RatingMapper {

//    public static List<Rating> toRatingList(Queue<RatingDTO> ratingDTOQueue){
//        return ratingDTOQueue.stream()
//                .map(tmpRating -> toRating(tmpRating))
//                .collect(Collectors.toList());
//    }


    public static Rating toRating(RatingDTO ratingDTO) {
        Rating rating = new Rating();
        rating.setRateId(ratingDTO.getRateId());
        rating.setRateValue(ratingDTO.getRateValue());
        rating.setMovie((Movie) MovieMapper.toMovie(ratingDTO.getMovie()));
        return rating;
    }

//    public static Queue<RatingDTO> ratingDTOQueue(List<Rating> ratings) {
//        Queue<RatingDTO> ratingDTOS= new LinkedList<>();
//        for(Rating tmpRating : ratings)
//            ratingDTOS.offer(toRatingDTO(tmpRating));
//        return ratingDTOS;
//    }


    public static RatingDTO toRatingDTO(Rating rating) {
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setRateId(rating.getRateId());
        ratingDTO.setRateValue(rating.getRateValue());


        ratingDTO.setMovie(MovieMapper.toMovieDTO(rating.getMovie()));
        return ratingDTO;
    }
}
