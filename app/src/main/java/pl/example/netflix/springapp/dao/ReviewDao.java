package pl.example.netflix.springapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.example.netflix.model.Review;

@Repository
public interface ReviewDao extends CrudRepository<Review, Long> {
}
