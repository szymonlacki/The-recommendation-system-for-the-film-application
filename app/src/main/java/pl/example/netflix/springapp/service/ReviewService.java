package pl.example.netflix.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.example.netflix.model.Account;
import pl.example.netflix.model.Movie;
import pl.example.netflix.model.Review;
import pl.example.netflix.springapp.dao.AccountDao;
import pl.example.netflix.springapp.dao.MovieDao;
import pl.example.netflix.springapp.dao.RatingDao;
import pl.example.netflix.springapp.dao.ReviewDao;
import pl.example.netflix.springapp.dto.ReviewDTO;
import pl.example.netflix.springapp.mapper.ReviewMapper;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReviewService {


    private final ReviewDao reviewDao;
    private  final UserService userService;
    private final MovieService movieService;
    private final AccountDao accountDao;
    private final MovieDao movieDao;



    @Autowired
    public ReviewService(ReviewDao reviewDao,AccountDao accountDao,UserService userService, MovieService movieService, RatingDao ratingDao, MovieDao movieDao) {
        this.userService = userService;
        this.movieService = movieService;
       this.reviewDao = reviewDao;
        this.accountDao = accountDao;
        this.movieDao = movieDao;
    }




    public List<ReviewDTO> getReviews() throws Exception {
        Iterable<Review> reviewIterable = this.reviewDao.findAll();
        List<ReviewDTO> reviewDTOList = new ArrayList<>();
        for(Review tmpReview : reviewIterable){
            reviewDTOList.add(ReviewMapper.toReviewDTO(tmpReview));
        }
        return reviewDTOList;
    }

    @Transactional
    public void insertReview(ReviewDTO reviewDTO) throws Exception {
        Review review = ReviewMapper.toReview(reviewDTO);
        Account account = userService.findAccountById(reviewDTO.getAccountId());
        review.setAccount(account);
        review.setMovie(this.movieService.getMovie(reviewDTO.getMovie().getMovieId()));
//        System.out.println(rating.toString());
        this.reviewDao.save(review);
    }

    //Funkcja służąca do pobierania recenzji dla filmu(wyświetla recenzje w szczegółach filmu)
    public List<Review> getReviewsByMovieID(Long movieId) {
        Movie movie = movieDao.findById(movieId).get();
        return new ArrayList<>(movie.getReviews());
    }

    //Funkcja służąca do pobierania loginu autora danej recenzjis
    public List<String> getAccountByReviewID(Long reviewId) {
        Review review =  reviewDao.findById(reviewId).get();
        List<String> account = new ArrayList<>();
        account.add(review.getAccount().getUserDetail().getName());
        return account;
    }


    //Funkcja służąca do pobierania recenzji dla filmu(wyświetla recenzjie w moim profilu)
    public List<Review> getReviewsByAccountID(Long accountId) {
        Account account= accountDao.findById(accountId).get();
        return new ArrayList<>(account.getReviews());
    }

    public List<String> getMoviesByReviewID(Long reviewId) {
        Review review= reviewDao.findById(reviewId).get();
        List<String> movie = new ArrayList<>();
        movie.add(review.getMovie().getMovieTitle());
        return  movie;
    }


    //Pobieram Idiki wszystkich recenzji danego filmu, żeby potem na froncie dzięki tym Id
    //skorzystać z funkcji getAccountByReviewId w ngForzes
    public ArrayList<Long> getReviewsIdByMovieID(Long movieId) {
        Movie movie = movieDao.findById(movieId).get();
        List<Long> reviews = new ArrayList<>();
        Iterable<Review> reviewIterable = new ArrayList<>(movie.getReviews());
        for (Review tmpFavoriteLists : reviewIterable) {
            reviews.add(tmpFavoriteLists.getReviewId());
        }
            return (ArrayList<Long>) reviews;
    }
}
