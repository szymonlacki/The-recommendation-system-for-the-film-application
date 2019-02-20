package pl.example.netflix.springapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.example.netflix.common.ImageUtils;
import pl.example.netflix.logic.AlgorithmParameters;
import pl.example.netflix.logic.enums.MovieDuration;
import pl.example.netflix.logic.enums.MovieReleaseYear;
import pl.example.netflix.model.*;
import pl.example.netflix.springapp.dao.ActorDao;
import pl.example.netflix.springapp.dao.GenreDao;
import pl.example.netflix.springapp.dao.MovieDao;
import pl.example.netflix.springapp.dao.RatingDao;
import pl.example.netflix.springapp.dto.ActorDTO;
import pl.example.netflix.springapp.dto.GenreDTO;
import pl.example.netflix.springapp.dto.MovieDTO;
import pl.example.netflix.springapp.mapper.ActorMapper;
import pl.example.netflix.springapp.mapper.GenreMapper;
import pl.example.netflix.springapp.mapper.MovieMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    private GenreService genreService;
    @Autowired
    private ActorService actorService;
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private ActorDao actorDao;
    @Autowired
    private GenreDao genreDao;
    @Autowired
    private RatingDao ratingDao;
    List<String> words = new ArrayList<>();
    @PersistenceContext
    private EntityManager entityManager;


    public List<MovieDTO> getMovies() throws Exception {
        Iterable<Movie> movieIterable = this.movieDao.findAll();
        List<MovieDTO> movieDTOList = new ArrayList<>();

        for(Movie tmpMovie : movieIterable){
            movieDTOList.add(MovieMapper.toMovieDTO(tmpMovie));
        }

        return movieDTOList;
    }
    public Movie getMovie(Long movieId) throws Exception {
        return movieDao.findById(movieId).get();
    }

//    public Set<MovieDTO> getTopRatedMovies() throws Exception {
//        Iterable<Rating> ratingIterable = this.ratingDao.findAll();
//        Set<MovieDTO> movieDTOList = new HashSet<>();
//        for (Rating tmpRating : ratingIterable) {
//            if (tmpRating.getRateValue() >= 7) {
//                    movieDTOList.add(MovieMapper.toMovieDTO(tmpRating.getMovie()));
//            }
//        }
//        return movieDTOList;
//    }


    public Set<MovieDTO> getTopRatedMovies() throws Exception {
        Iterable<Rating> ratingIterable = this.ratingDao.findAll();
        Set<MovieDTO> movieDTOList = new HashSet<>();
        double sum =0;
        double average =0;
        String title = "";
        for (Rating tmpRating : ratingIterable) {
            if(!title.equals(tmpRating.getMovie().getMovieTitle())) {
                sum = 0;
                title = tmpRating.getMovie().getMovieTitle();
            }
            sum= sum + tmpRating.getRateValue();
            average = sum/tmpRating.getMovie().getRatings().size();
            if (average >= 7) {
                movieDTOList.add(MovieMapper.toMovieDTO(tmpRating.getMovie()));
            }
            System.out.println("Film: " + tmpRating.getMovie().getMovieTitle() + " avg: " + average);
        }

        return movieDTOList;
    }




    @Transactional
    public void insertMovie(MovieHelper movieHelper) throws Exception {

        MovieDTO movieDTO = movieHelper.getMovieDTO();
        validateAddMovie(movieDTO);
        List<Genre> genreList = movieHelper.getGenreList();
        List<String> actorNameList = movieHelper.getActors();

        Set<GenreDTO> genreListFromDB = genreService.getGenres();
        Set<ActorDTO> actorsFromDB = actorService.getActors();


        Set<Genre> concreteGenres = getConcreteGenres(genreListFromDB, genreList);
        Set<Actor> concreteActors = getConcreteActors(actorsFromDB, actorNameList);

        Movie movie = MovieMapper.toMovie(movieDTO);
         movie.setImageName(ImageUtils.createImage(movieHelper.getMovieDTO().getImage(),movieHelper.getMovieDTO().getMovieTitle()));

        movie.setGenres(concreteGenres);
        movie.setActors(concreteActors);


        entityManager.merge(movie);
        //this.movieDao.save(movie);
        System.out.println(movie.toString());

    }

    public void deleteMovie(Long movieId) throws Exception {
//        MovieDTO movie = getMovie(movieId);
        this.movieDao.deleteById(movieId);
    }


    private Set<Genre> getConcreteGenres(Set<GenreDTO> genreDTOS, List<Genre> genres) {
        Iterator<GenreDTO> iterator = genreDTOS.iterator();
        Iterator<Genre> genreIterator;
        Set<Genre> concreteGenres = new HashSet<>();

        while (iterator.hasNext()) {
            GenreDTO tempGenreDTO = iterator.next();

            genreIterator = genres.iterator();
            while (genreIterator.hasNext()) {
                Genre tmpGenre = genreIterator.next();

                if(tempGenreDTO.getGenreTitle().equalsIgnoreCase(tmpGenre.getGenreTitle())) {
                    concreteGenres.add(GenreMapper.toGenre(tempGenreDTO));

                }
            }
        }

        return concreteGenres;
    }

    private Set<Actor> getConcreteActors(Set<ActorDTO> actorsFromDB, List<String> actorList) {
        Iterator<ActorDTO> iterator = actorsFromDB.iterator();
        Iterator<String> actorsIterator;
        Set<Actor> concreteActors = new HashSet<>();

        while (iterator.hasNext()) {
            ActorDTO tempActorDTO = iterator.next();

            actorsIterator = actorList.iterator();
            while (actorsIterator.hasNext()) {
                String tmpActorName = actorsIterator.next();

                if(tempActorDTO.getActorName().equalsIgnoreCase(tmpActorName)) {
                    concreteActors.add(ActorMapper.toActor(tempActorDTO));

                }
            }
        }

        return concreteActors;
    }

    //Funkcja służąca do wyświetlania filmów, w których gra dany aktor
    public List<Movie> getMoviesByActorID(Long actorID) {
        Actor actor = actorDao.findById(actorID).get();
        //return actorDao.findMovieByActorID(actorID);
        return new ArrayList<>(actor.getMovies());
    }

    //Funkcja służąca do wyświetlania filmów na podstawie ich gatunków
    public List<Movie> getMoviesByGenreID(Long genreId) {
        Genre genre = genreDao.findById(genreId).get();
        return new ArrayList<>(genre.getMovies());
    }

    //Funkcja służąca do pobierania gatunków na podstawie filmów
    public List<Genre> getGenresByMovieID(Long movieId) {
        Movie movie = movieDao.findById(movieId).get();
        return new ArrayList<>(movie.getGenres());
    }


    private Optional<Movie> findMovieByTitle(MovieDTO movieDTO) throws Exception {
        return movieDao.findMovieByTitle(movieDTO.getMovieTitle());
    }

    private void validateAddMovie(MovieDTO movieDTO) throws Exception {
        if (findMovieByTitle(movieDTO).isPresent()) {
            throw new Exception("Istnieje już film o podanym tytule.");
        }

    }


    public List<Movie> getSuitedMovies(AlgorithmParameters algorithmParameters) {
        MovieDuration movieDuration = algorithmParameters.getMovieDuration();
        MovieReleaseYear movieReleaseYear = algorithmParameters.getMovieReleaseYear();
        String actors = algorithmParameters.getActors();
        String lang = algorithmParameters.getLang();
        String genres = algorithmParameters.getGenres();
        String releaseCountry = algorithmParameters.getReleaseCountry();


        if((movieDuration.ordinal() == 0) && (movieReleaseYear.ordinal() == 0))
            return movieDao.findSuitedMovies00(actors, lang, genres, releaseCountry);
        if((movieDuration.ordinal() == 0) && (movieReleaseYear.ordinal() == 1))
            return movieDao.findSuitedMovies01(actors, lang, genres, releaseCountry);
        if((movieDuration.ordinal() == 0) && (movieReleaseYear.ordinal() == 2))
            return movieDao.findSuitedMovies02(actors, lang, genres, releaseCountry);
        if((movieDuration.ordinal() == 1) && (movieReleaseYear.ordinal() == 0))
            return movieDao.findSuitedMovies10(actors, lang, genres, releaseCountry);
        if((movieDuration.ordinal() == 1) && (movieReleaseYear.ordinal() == 1))
            return movieDao.findSuitedMovies11(actors, lang, genres, releaseCountry);
        if((movieDuration.ordinal() == 1) && (movieReleaseYear.ordinal() == 2))
            return movieDao.findSuitedMovies12(actors, lang, genres, releaseCountry);
        if((movieDuration.ordinal() == 2) && (movieReleaseYear.ordinal() == 0))
            return movieDao.findSuitedMovies20(actors, lang, genres, releaseCountry);
        if((movieDuration.ordinal() == 2) && (movieReleaseYear.ordinal() == 1))
            return movieDao.findSuitedMovies21(actors, lang, genres, releaseCountry);
        if((movieDuration.ordinal() == 2) && (movieReleaseYear.ordinal() == 2))
            return movieDao.findSuitedMovies22(actors, lang, genres, releaseCountry);

        return null;
    }

    public List<MovieDTO> findMoviesByKeyWord(String keyWord) throws Exception {
        Iterable<Movie> tmp = movieDao.findAll();
        List<MovieDTO> movieDTOList = new ArrayList<>();
        words.add(keyWord);
        String joined = String.join("", words);
        System.out.println(joined);

        for (Movie tmpMovie : tmp) {
        if (tmpMovie.getMovieTitle().toLowerCase().contains(joined.toLowerCase())) {
            movieDTOList.add(MovieMapper.toMovieDTO(tmpMovie));
        }
            words.clear();
    }
        return movieDTOList;
    }


}
