package pl.example.netflix.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.example.netflix.model.Account;
import pl.example.netflix.model.FavoriteList;
import pl.example.netflix.model.Movie;
import pl.example.netflix.springapp.dao.AccountDao;
import pl.example.netflix.springapp.dao.FavoriteListDao;
import pl.example.netflix.springapp.dao.MovieDao;
import pl.example.netflix.springapp.dto.FavoriteListDTO;
import pl.example.netflix.springapp.mapper.FavoriteListMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FavoriteListService {

    private final FavoriteListDao favoriteListDao;
    private final AccountDao accountDao;
    private final UserService userService;
    private final MovieService movieService;

    @Autowired
    private MovieDao movieDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public FavoriteListService(MovieService movieService,FavoriteListDao favoriteListDao, AccountDao accountDao, UserService userService) {
        this.favoriteListDao = favoriteListDao;
        this.accountDao = accountDao;
        this.userService = userService;
        this.movieService = movieService;
    }


    @javax.transaction.Transactional

    //Niepotrzebne, liste tworzę przy rejestracji.
    public void insertFavoriteList(FavoriteListDTO favoriteListDTO, Long movieId) throws Exception {

        FavoriteList favoriteList = FavoriteListMapper.toFavoriteList(favoriteListDTO);
        Account account = userService.findAccountById(favoriteListDTO.getAccountId());
        favoriteList.setAccount(account);
        Movie movie = movieDao.findById(movieId).get();
        favoriteList.setMovies(Collections.singletonList(movie));
        this.favoriteListDao.save(favoriteList);
    }

    public double getSizeOfFavoriteList(Long accountId) throws Exception {

        Account account = accountDao.findById(accountId).get();
        List<FavoriteList> favoriteLists = account.getFavoriteLists();
        return favoriteLists.size();
    }

    public void addToCurrentFavoriteList(Long favoriteListId, Long movieId) {
        FavoriteList favoriteList = favoriteListDao.findById(favoriteListId).get();
        Movie movie = movieDao.findById(movieId).get();
        favoriteList.getMovies().add(movie);
        this.favoriteListDao.save(favoriteList);
    }

    public Long getFavoriteListIdByAccountID(Long accountId) {
        Account account = accountDao.findById(accountId).get();
        return account.getFavoriteLists().listIterator().next().getFavoriteListId();
    }

    public ArrayList getMoviesListsByFavoriteListID(Long favoriteListId) {
        FavoriteList favoriteList = favoriteListDao.findById(favoriteListId).get();
        return new ArrayList<>(favoriteList.getMovies());
    }

    public ArrayList getFavoriteListsByAccountId(Long accountId) {
        Account account = accountDao.findById(accountId).get();
        return new ArrayList<>(account.getFavoriteLists());
    }

    public void deleteMovieFromFavoriteList(Long favoriteListId, Long movieId) {
        FavoriteList favoriteList = favoriteListDao.findById(favoriteListId).get();
        Movie movie = movieDao.findById(movieId).get();
        favoriteList.getMovies().remove(movie);
        this.favoriteListDao.save(favoriteList);

    }

    public List<FavoriteListDTO> getFavoritedMovieByAccountId(Long accountId, Long movieId) {

        Account account = accountDao.findById(accountId).get();
        Iterable<FavoriteList> favoriteIterable = new ArrayList<>(account.getFavoriteLists());
        List<FavoriteListDTO> ratingDTOList = new ArrayList<>();
        Movie movie = movieDao.findById(movieId).get();
        Iterable<FavoriteList> favoriteListsIterable = new ArrayList<>(movie.getFavoriteLists());
        for (FavoriteList tmpFavoriteLists : favoriteIterable) {
            Iterable<Movie> movieIterable = new ArrayList<>(tmpFavoriteLists.getMovies());
            for (Movie moviesIterable : movieIterable) {
                if (moviesIterable.getMovieId() == movieId) {
                    ratingDTOList.add(FavoriteListMapper.toFavoriteListDTO(tmpFavoriteLists));
                }
            }
        }
        return ratingDTOList;
    }
}
