package pl.example.netflix.springapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.example.netflix.model.Genre;

import java.util.Optional;

@Repository
public interface GenreDao extends CrudRepository<Genre, Long> {

    @Query("SELECT g FROM Genre g WHERE g.genreTitle like ?1")
    Optional<Genre> findAccountByLogin(@Param("login") String login);

}
