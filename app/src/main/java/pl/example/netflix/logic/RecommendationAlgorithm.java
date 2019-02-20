package pl.example.netflix.logic;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.example.netflix.logic.enums.MovieDuration;
import pl.example.netflix.logic.enums.MovieReleaseYear;
import pl.example.netflix.model.*;
import pl.example.netflix.springapp.dao.MovieDao;
import pl.example.netflix.springapp.dao.MovieListDao;
import pl.example.netflix.springapp.service.MovieService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RecommendationAlgorithm {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private MovieListDao movieListDao;

    @Autowired
    private MovieService movieService;

    private Account account;
    private Set<Movie> myMovies = new HashSet<>();
    private List<Movie> allMovies;


    private List<String> langList = new LinkedList<>();
    private List<String> releaseCountryList = new LinkedList<>();
    private List<String> actorsList = new LinkedList<>();
    private List<String> genresList = new LinkedList<>();

    private Set<Movie> recommendedMovies = new HashSet<>();


    // TODO zmienić na prywatną jak bedzie algorytm gotowy
    public void prepareMovies() {
        this.allMovies = Lists.newArrayList(movieDao.findAll());
    }

    private List<Movie> getTopRatedMovies() {
        List<Movie> movies = this.allMovies;
        movies = movies.stream().filter(
                movie -> {
                    List<Movie> moviesToReturn = new ArrayList<>();
                    List<Rating> ratings = movie.getRatings().stream().filter(
                            rating -> rating.getAccount().getLogin().equals(this.account.getLogin()) && rating.getRateValue() > 6).collect(Collectors.toList());
                    for (Rating rating : ratings) {
                        if (rating.getMovie().getMovieId() != null)
                            moviesToReturn.add(rating.getMovie());
                    }
                    return moviesToReturn.contains(movie);
                }
        ).collect(Collectors.toList());

        return movies;
    }

    private List<Movie> getFavouriteMovies() {
        List<Movie> movies = this.allMovies;
        movies = movies.stream().filter(
                movie -> {
                    List<Movie> moviesToReturn = new ArrayList<>();
                    List<FavoriteList> favoriteLists = movie.getFavoriteLists().stream().filter(
                            favouriteMovies -> favouriteMovies.getAccount().getLogin().equals(this.account.getLogin())).collect(Collectors.toList());

                    for (FavoriteList favoriteList : favoriteLists) {
                        if (favoriteList.getMovies() != null) {
                            for (Movie movieToAdd : favoriteList.getMovies()) {
                                moviesToReturn.add(movieToAdd);
                            }
                        }
                    }

                    return moviesToReturn.contains(movie);
                }
        ).collect(Collectors.toList());

        return movies;
    }

    private List<Movie> getMoviesFromPlaylists() {
        List<MovieList> movieLists = account.getMoviesList();
        List<Movie> collectMovies = new ArrayList<>();

        for (MovieList movieList : movieLists) {
            collectMovies.addAll(movieList.getMovies());
        }

        return collectMovies;
    }

    private Set<Movie> getLongReadedMovie() {
        Set<Movie> movieList = new HashSet<>();
        try {
            movieList = movieListDao.findByAccountLoginAndName(account.getLogin(), "LongViewed").get().getMovies();
        } catch (NoSuchElementException e) {

        }
        return movieList;
    }

    public void collectUserMovies() {
        this.myMovies.addAll(getTopRatedMovies());
        this.myMovies.addAll(getFavouriteMovies());
        this.myMovies.addAll(getMoviesFromPlaylists());
        this.myMovies.addAll(getLongReadedMovie());
    }

    public void clearList() {
        myMovies.clear();
        langList.clear();
        releaseCountryList.clear();
        actorsList.clear();
        genresList.clear();
    }

    public Set<Movie> getMyMovies() {
        return myMovies;
    }

    private MovieReleaseYear getTopCounterMovieRelease() {
        MovieReleaseCounter movieReleaseCounter = new MovieReleaseCounter();

        for (Movie movie : this.myMovies) {
            if (Integer.valueOf(movie.getMovieYear()) < 1950)
                movieReleaseCounter.increaseLess1950();
            if (Integer.valueOf(movie.getMovieYear()) >= 1950 && Integer.valueOf(movie.getMovieYear()) <= 2000)
                movieReleaseCounter.increase1950To2000();
            if (Integer.valueOf(movie.getMovieYear()) > 2000)
                movieReleaseCounter.increaseMoreThan2000();
        }

        return movieReleaseCounter.getTopCounter();
    }

    private MovieDuration getTopCounterMovieDuration() {
        MovieDurationCounter movieDurationCounter = new MovieDurationCounter();

        for (Movie movie : this.myMovies) {
            if (Integer.valueOf(movie.getMovieDuration()) < 60)
                movieDurationCounter.increaseLess1950();
            if (Integer.valueOf(movie.getMovieDuration()) >= 60 && Integer.valueOf(movie.getMovieDuration()) <= 90)
                movieDurationCounter.increase1950To2000();
            if (Integer.valueOf(movie.getMovieDuration()) > 90)
                movieDurationCounter.increaseMoreThan2000();
        }

        return movieDurationCounter.getTopCounter();
    }

    public String getTopAmountMoviesLang() {
        for (Movie movie : this.myMovies) {
            this.langList.add(movie.getMovieLang());
        }

        Map<String, Long> items = this.langList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return items.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

    }

    public String getTopAmountMoviesReleaseCountry() {
        for (Movie movie : this.myMovies) {
            releaseCountryList.add(movie.getMovieReleaseCountry());
        }

        Map<String, Long> items = this.releaseCountryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return items.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }

    public String getTopAmountMoviesActors() {
        Map<String, Long> items = new HashMap<>();
        try {
            for (Movie movie : this.myMovies) {
                for (Actor actor : movie.getActors()) {
                    actorsList.add(actor.getActorName());
                }
            }

            items = this.actorsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            return items.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        }catch (NoSuchElementException e) {

        }
        return "";
    }


    public String getTopAmountMoviesGenres() {
        Map<String, Long> items = new HashMap<>();
        try {
            for (Movie movie : this.myMovies) {
                for (Genre genre : movie.getGenres()) {
                    genresList.add(genre.getGenreTitle());
                }
            }
            items = this.genresList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            //System.out.println("Lista: \n" + items) ;

            return items.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        } catch (NoSuchElementException e) {

        }
        return "";
    }


    public void calculateRecommended() {
        System.out.println("Movie year: " + getTopCounterMovieRelease());
        System.out.println("Movie duration: " + getTopCounterMovieDuration());
        System.out.println("Movie lang: " + getTopAmountMoviesLang());
        System.out.println("Movie release country: " + getTopAmountMoviesReleaseCountry());
        System.out.println("Movie actors: " + getTopAmountMoviesActors());
        System.out.println("Movie genres: " + getTopAmountMoviesGenres());

        AlgorithmParameters parameters = new AlgorithmParameters(getTopCounterMovieRelease(), getTopCounterMovieDuration(), getTopAmountMoviesLang(), getTopAmountMoviesReleaseCountry(), getTopAmountMoviesActors(), getTopAmountMoviesGenres());

        recommendedMovies = new HashSet<>(movieService.getSuitedMovies(parameters));
    }

    public Set<Movie> getRecommendedMovies() {
        return this.recommendedMovies;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
