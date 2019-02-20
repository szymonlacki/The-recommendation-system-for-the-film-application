package pl.example.netflix.springapp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.example.netflix.logic.RecommendationAlgorithm;
import pl.example.netflix.model.Account;
import pl.example.netflix.model.Movie;
import pl.example.netflix.springapp.dao.AccountDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/recommendation")
public class RecommendationAlgorithmRestController {

    @Autowired
    private RecommendationAlgorithm recommendationAlgorithm;

    @Autowired
    private AccountDao accountDao;

    @RequestMapping(value = "/getMovies", method = RequestMethod.GET)
    public ResponseEntity getMovies(@RequestParam("login") String login) {
        Account account = accountDao.findAccountByLogin(login).get();
        recommendationAlgorithm.setAccount(account);
        recommendationAlgorithm.prepareMovies();
        recommendationAlgorithm.collectUserMovies();
        recommendationAlgorithm.calculateRecommended();
        Set<Movie> movies = new HashSet<>(recommendationAlgorithm.getRecommendedMovies());
        //System.out.println(movies);
        recommendationAlgorithm.clearList();
        return new ResponseEntity(movies, HttpStatus.OK);
    }

}
