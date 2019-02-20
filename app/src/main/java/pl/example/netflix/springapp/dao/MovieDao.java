package pl.example.netflix.springapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.example.netflix.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieDao extends CrudRepository<Movie, Long> {

    @Query("SELECT u FROM Movie u WHERE u.movieTitle like ?1")
    Optional<Movie> findMovieByTitle(@Param("movieTitle") String movieTitle);

    @Query("SELECT m from Movie m, in(m.actors) a, in(m.genres) g where a.actorName in :actor or m.movieLang = :lang and g.genreTitle in :genre or m.movieReleaseCountry = :releaseCountry and m.movieDuration < '60' and m.movieReleaseDate < '1950'")
    List<Movie> findSuitedMovies00(@Param("actor") String actor, @Param("lang") String lang, @Param("genre") String genre, @Param("releaseCountry") String releaseCountry);

    @Query("SELECT m from Movie m, in(m.actors) a, in(m.genres) g where a.actorName in :actor or m.movieLang = :lang and g.genreTitle in :genre or m.movieReleaseCountry = :releaseCountry and m.movieDuration < '60' and m.movieReleaseDate >= '1950' and m.movieReleaseDate < '2000'")
    List<Movie> findSuitedMovies01(@Param("actor") String actor, @Param("lang") String lang, @Param("genre") String genre, @Param("releaseCountry") String releaseCountry);

    @Query("SELECT m from Movie m, in(m.actors) a, in(m.genres) g where a.actorName in :actor or m.movieLang = :lang and g.genreTitle in :genre or m.movieReleaseCountry = :releaseCountry and m.movieDuration < '60' and m.movieReleaseDate >= '2000'")
    List<Movie> findSuitedMovies02(@Param("actor") String actor, @Param("lang") String lang, @Param("genre") String genre, @Param("releaseCountry") String releaseCountry);

    @Query("SELECT m from Movie m, in(m.actors) a, in(m.genres) g where a.actorName in :actor or m.movieLang = :lang and g.genreTitle in :genre or m.movieReleaseCountry = :releaseCountry and m.movieDuration >= '60' and m.movieDuration < '90' and m.movieReleaseDate < '1950'")
    List<Movie> findSuitedMovies10(@Param("actor") String actor, @Param("lang") String lang, @Param("genre") String genre, @Param("releaseCountry") String releaseCountry);

    @Query("SELECT m from Movie m, in(m.actors) a, in(m.genres) g where a.actorName in :actor or m.movieLang = :lang and g.genreTitle in :genre or m.movieReleaseCountry = :releaseCountry and m.movieDuration >= '60' and m.movieDuration < '90' and m.movieReleaseDate >= '1950' and m.movieReleaseDate < '2000'")
    List<Movie> findSuitedMovies11(@Param("actor") String actor, @Param("lang") String lang, @Param("genre") String genre, @Param("releaseCountry") String releaseCountry);

    @Query("SELECT m from Movie m, in(m.actors) a, in(m.genres) g where a.actorName in :actor or m.movieLang = :lang and g.genreTitle in :genre or m.movieReleaseCountry = :releaseCountry and m.movieDuration >= '60' and m.movieDuration < '90' and m.movieReleaseDate >= '2000'")
    List<Movie> findSuitedMovies12(@Param("actor") String actor, @Param("lang") String lang, @Param("genre") String genre, @Param("releaseCountry") String releaseCountry);

    @Query("SELECT m from Movie m, in(m.actors) a, in(m.genres) g where a.actorName in :actor or m.movieLang = :lang and g.genreTitle in :genre or m.movieReleaseCountry = :releaseCountry and m.movieDuration >= '90' and m.movieReleaseDate < '1950'")
    List<Movie> findSuitedMovies20(@Param("actor") String actor, @Param("lang") String lang, @Param("genre") String genre, @Param("releaseCountry") String releaseCountry);

    @Query("SELECT m from Movie m, in(m.actors) a, in(m.genres) g where (a.actorName in :actor or m.movieLang = :lang) and g.genreTitle in :genre or m.movieReleaseCountry = :releaseCountry and (m.movieDuration >= '90' and m.movieReleaseDate >= '1950' and m.movieReleaseDate < '2000')")
    List<Movie> findSuitedMovies21(@Param("actor") String actor, @Param("lang") String lang, @Param("genre") String genre, @Param("releaseCountry") String releaseCountry);

    @Query("SELECT m from Movie m, in(m.actors) a, in(m.genres) g where a.actorName in :actor or m.movieLang = :lang and g.genreTitle in :genre or m.movieReleaseCountry = :releaseCountry and m.movieDuration >= '90' and m.movieReleaseDate >= '2000'")
    List<Movie> findSuitedMovies22(@Param("actor") String actor, @Param("lang") String lang, @Param("genre") String genre, @Param("releaseCountry") String releaseCountry);

//    @Query("select m from MOVIE m\n" +
//            "join MOVIE_CAST mc on m.MOVIE_ID = mc.MOVIE_ID\n" +
//            "join ACTOR a on mc.ACTOR_ID = a.ACTOR_ID\n" +
//            "where a.ACTOR_ID=?1")
//    Optional<Movie> findMovieByActorID(@Param("actorId") Long actorId);


//    select * from MOVIE m
//    join MOVIE_CAST mc on m.MOVIE_ID = mc.MOVIE_ID
//    join ACTOR a on mc.ACTOR_ID = a.ACTOR_ID
//    where a.ACTOR_ID=21
//


//    @Query("SELECT n FROM Movie n, Genre t Movie_Genres x WHERE x.GENRE_ID = t.GENRE_ID AND x.MOVIE_ID = n.MOVIE_ID AND t.GENRE_TITLE IN (\n" +
//            "'Komedia'");
}
