package pl.example.netflix.springapp.dao;

import org.springframework.data.repository.CrudRepository;
import pl.example.netflix.model.Rating;

public interface RatingDao extends CrudRepository<Rating, Long> {
}
