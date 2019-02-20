package pl.example.netflix.springapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.example.netflix.model.Director;

@Repository
public interface DirectorDao extends CrudRepository<Director, Long> {
}

