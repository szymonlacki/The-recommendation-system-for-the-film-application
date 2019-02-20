package pl.example.netflix.springapp.service;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.example.netflix.model.*;
import pl.example.netflix.springapp.dao.AccountDao;
import pl.example.netflix.springapp.dao.MovieDao;
import pl.example.netflix.springapp.dao.MovieListDao;
import pl.example.netflix.springapp.dto.MovieDTO;
import pl.example.netflix.springapp.dto.MovieListDTO;
import pl.example.netflix.springapp.mapper.MovieListMapper;
import pl.example.netflix.springapp.mapper.MovieMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Service
public class MovieListService {

    private final MovieListDao movieListDao;
    private final AccountDao accountDao;
    private final UserService userService;
    private final MovieService movieService;

    @Autowired
    private MovieDao movieDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public MovieListService(MovieService movieService, MovieListDao movieListDao, AccountDao accountDao, UserService userService) {
        this.movieListDao = movieListDao;
        this.accountDao = accountDao;
        this.userService = userService;
        this.movieService = movieService;
    }

    public List<MovieList> getMovieListsByAccountID(Long accountId) {
        Account account = accountDao.findById(accountId).get();
        return new ArrayList<>(account.getMoviesList());
    }


    @javax.transaction.Transactional
    public void insertMovieList(MovieListDTO movieListDTO) throws Exception {
        List<Movie> movies = movieListDTO.getMovies();

        for (Movie movie: movies) {
            Set<Genre> genres = new HashSet<>();
            Movie tmpMovie = movieDao.findMovieByTitle(movie.getMovieTitle()).get();
            genres = tmpMovie.getGenres();
            movie.setGenres(genres);

        }

        for (Movie movie: movies) {
            Set<Actor> actors = new HashSet<>();
            Movie tmpMovie = movieDao.findMovieByTitle(movie.getMovieTitle()).get();
            actors = tmpMovie.getActors();
            movie.setActors(actors);

        }

        movieListDTO.setMovies(movies);
        validateAddMovieList(movieListDTO);
        MovieList movieList = MovieListMapper.toMovieList(movieListDTO);
        Account account = userService.findAccountById(movieListDTO.getAccountId());
        movieList.setAccount(account);

        this.movieListDao.save(movieList);


    }

    public double getNumberOfUserMovieLists(Long accountId) throws Exception {

        Account account = accountDao.findById(accountId).get();
        List<MovieList> movieLists = account.getMoviesList();
        return movieLists.size();
    }


    //Pobieranie filmów dla danej listy filmów
    public List<Movie> getMoviesByMovieListID(Long movie_List_Id) {
        MovieList movieList = movieListDao.findById(movie_List_Id).get();
        return new ArrayList<>(movieList.getMovies());
    }

    public void addToCurrentList(Long movie_List_Id, Long movieId) throws Exception {
        MovieList movieList = movieListDao.findById(movie_List_Id).get();
        Movie movie = movieDao.findById(movieId).get();

        if (movieList.getMovies().contains(movie))
            throw new Exception("Film już istnieje w tej liście");
//        }
        movieList.getMovies().add(movie);
        this.movieListDao.save(movieList);
//        entityManager.merge(movieList);
    }

    private Optional<MovieList> findMovieListByName(MovieListDTO movieListDTO) throws Exception {
        return movieListDao.findMovieListByName(movieListDTO.getName());
    }

    private void validateAddMovieList(MovieListDTO movieListDTO) throws Exception {
        if (findMovieListByName(movieListDTO).isPresent()) {
            throw new Exception("Istnieje już lista o podanej nazwie.");
        }

    }

    public void deleteMovieFromMovieList(Long favoriteListId, Long movieId) {
        MovieList movieList = movieListDao.findById(favoriteListId).get();
        Movie movie = movieDao.findById(movieId).get();
        movieList.getMovies().remove(movie);
        this.movieListDao.save(movieList);

    }

    @Transactional
    public void addToLongViewedList(Long movieId, String accountLogin) {
        Movie movie = null;
        try {
            movie = movieDao.findById(movieId).get();
            MovieList movieList = movieListDao.findMovieListByName("LongViewed").get();


            addLongViewedMovie(movie, movieList);
        } catch(NoSuchElementException e) {
            Account account = accountDao.findAccountByLogin(accountLogin).get();

            MovieList newMovieList = new MovieList();
            newMovieList.setDescription("Długo oglądane");
            newMovieList.setName("LongViewed");
            newMovieList.setAccount(account);

            entityManager.merge(newMovieList);
            //movieListDao.save(newMovieList);

            addLongViewedMovie(movie, newMovieList);
        }
    }

    @Transactional
    public void addLongViewedMovie(Movie movie, MovieList movieList) {
        movieList.getMovies().add(movie);
        entityManager.merge(movieList);
    }

}
