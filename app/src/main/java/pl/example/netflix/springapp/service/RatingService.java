package pl.example.netflix.springapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.example.netflix.model.Account;
import pl.example.netflix.model.Movie;
import pl.example.netflix.model.Rating;
import pl.example.netflix.springapp.dao.AccountDao;
import pl.example.netflix.springapp.dao.MovieDao;
import pl.example.netflix.springapp.dao.RatingDao;
import pl.example.netflix.springapp.dto.MovieDTO;
import pl.example.netflix.springapp.dto.RatingDTO;
import pl.example.netflix.springapp.mapper.MovieMapper;
import pl.example.netflix.springapp.mapper.RatingMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    private final RatingDao ratingDao;
    private final MovieDao movieDao;
    private final UserService userService;
    private final MovieService movieService;
    private final AccountDao accountDao;


    @Autowired
    public RatingService(AccountDao accountDao, UserService userService, MovieService movieService, RatingDao ratingDao, MovieDao movieDao) {
        this.userService = userService;
        this.movieService = movieService;
        this.ratingDao = ratingDao;
        this.movieDao = movieDao;
        this.accountDao = accountDao;
    }


    public List<RatingDTO> getRatings() throws Exception {
        Iterable<Rating> ratingIterable = this.ratingDao.findAll();
        List<RatingDTO> ratingDTOList = new ArrayList<>();
        for (Rating tmpRating : ratingIterable) {
            ratingDTOList.add(RatingMapper.toRatingDTO(tmpRating));
        }
        return ratingDTOList;
    }

    @Transactional
    public void insertRate(RatingDTO ratingDTO) throws Exception {
        Rating rating = RatingMapper.toRating(ratingDTO);
        Account account = userService.findAccountById(ratingDTO.getAccountId());
        rating.setAccount(account);
        rating.setMovie(this.movieService.getMovie(ratingDTO.getMovie().getMovieId()));
//        System.out.println(rating.toString());
        this.ratingDao.save(rating);
    }

    public double getAverageOfMovie(Long movieId) {

        Movie movie = movieDao.findById(movieId).get();
        double average = 0;
        Iterable<Rating> ratingIterable = new ArrayList<>(movie.getRatings());
        if(((ArrayList<Rating>) ratingIterable).isEmpty()) {
            return  0;
        }
        else {
            for (Rating tmpRating : ratingIterable) {
                average = average + tmpRating.getRateValue();

            }
        }
        return average / ((ArrayList<Rating>) ratingIterable).size();
    }

    public double getAverageOfUserRating(Long accountId) throws Exception {

        Account account = accountDao.findById(accountId).get();
        List<Rating> ratings = account.getRatings();
        Iterable<Rating> ratingIterable = new ArrayList<>(account.getRatings());
        double sum = 0;
        double averageOfUserRate=0;
        for (Rating tmpRating : ratingIterable) {
            sum = sum + tmpRating.getRateValue();
        }
        if(ratings.isEmpty()){averageOfUserRate=0;}
        else
        averageOfUserRate = sum / ratings.size();

        return averageOfUserRate;
    }

    public double getNumberOfUserRatings(Long accountId) throws Exception {

        Account account = accountDao.findById(accountId).get();
        List<Rating> ratings = account.getRatings();
        return ratings.size();
    }

    public List<RatingDTO> getRatedMovieByAccountId(Long accountId, Long movieId) {

        Account account = accountDao.findById(accountId).get();
        Iterable<Rating> ratingIterable = new ArrayList<>(account.getRatings());
        List<RatingDTO> ratingDTOList = new ArrayList<>();
        Movie movie = movieDao.findById(movieId).get();
        Iterable<Rating> movieIterable = new ArrayList<>(movie.getRatings());
        for (Rating tmpRating : ratingIterable) {

            if (tmpRating.getMovie().getMovieId() == movieId) {
                ratingDTOList.add(RatingMapper.toRatingDTO(tmpRating));
            }

        }
        return ratingDTOList;
    }


}