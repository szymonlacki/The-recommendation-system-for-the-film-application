package pl.example.netflix.springapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.example.netflix.model.FavoriteList;
import pl.example.netflix.model.MovieList;

import java.util.Optional;


public interface FavoriteListDao extends CrudRepository<FavoriteList, Long> {


}
