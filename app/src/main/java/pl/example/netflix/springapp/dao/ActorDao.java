package pl.example.netflix.springapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.example.netflix.model.Actor;
import pl.example.netflix.model.Movie;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActorDao extends CrudRepository<Actor, Long> {

    @Query("SELECT u FROM Actor u WHERE u.actorName like ?1")
    Optional<Actor> findActorByName(@Param("actorName") String actorName);

}
