package pl.example.netflix.springapp.mapper;

import pl.example.netflix.model.Review;
import pl.example.netflix.springapp.dto.ReviewDTO;

public class ReviewMapper {

    public static Review toReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setReviewId(reviewDTO.getReviewId());
        review.setReviewDescription(reviewDTO.getReviewDescription());
        review.setMovie(review.getMovie());
        return review;
    }

//    public static Queue<RatingDTO> ratingDTOQueue(List<Rating> ratings) {
//        Queue<RatingDTO> ratingDTOS= new LinkedList<>();
//        for(Rating tmpRating : ratings)
//            ratingDTOS.offer(toRatingDTO(tmpRating));
//        return ratingDTOS;
//    }


    public static ReviewDTO toReviewDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewId(review.getReviewId());
        review.setReviewDescription(review.getReviewDescription());


        review.setMovie((review.getMovie()));
        return reviewDTO;
    }




}
