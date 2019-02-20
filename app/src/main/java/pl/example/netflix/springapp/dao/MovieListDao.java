package pl.example.netflix.springapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.example.netflix.model.Movie;
import pl.example.netflix.model.MovieList;

import java.util.Optional;

public interface MovieListDao extends CrudRepository<MovieList, Long> {

    @Query("SELECT u FROM MovieList u WHERE u.name like ?1")
    Optional<MovieList> findMovieListByName(@Param("name") String name);

    Optional<MovieList> findByAccountLoginAndName(@Param("login") String login, @Param("name") String name);

}
