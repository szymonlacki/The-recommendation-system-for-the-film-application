package pl.example.netflix.springapp.service;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.example.netflix.common.ImageUtils;
import pl.example.netflix.model.Actor;
import pl.example.netflix.model.Genre;
import pl.example.netflix.model.Movie;
import pl.example.netflix.springapp.dao.ActorDao;
import pl.example.netflix.springapp.dao.MovieDao;
import pl.example.netflix.springapp.dto.ActorDTO;
import pl.example.netflix.springapp.dto.GenreDTO;
import pl.example.netflix.springapp.mapper.ActorMapper;
import pl.example.netflix.springapp.mapper.GenreMapper;
import java.util.Set;
import java.util.*;

@Service
public class ActorService {

    private final ActorDao actorDao;
    private final MovieDao movieDao;

    @Autowired
    public ActorService(ActorDao actorDao, MovieDao movieDao) {
        this.actorDao = actorDao;
        this.movieDao = movieDao;
    }

    public Set<ActorDTO> getActors() throws Exception {
        Iterable<Actor> actorIterable = this.actorDao.findAll();
        List<ActorDTO> actorDTOList = new ArrayList<>();

        for(Actor tmpActor : actorIterable){
            actorDTOList.add(ActorMapper.toActorDTO(tmpActor));
        }

        return Sets.newHashSet(actorDTOList);
    }

    @Transactional
    public void insertActor(ActorDTO actorDTO) throws Exception {

        validateAddActor(actorDTO);
        Actor actor = ActorMapper.toActor(actorDTO);
//        Account account = userService.findAccountById(placeDTO.getAccountId());
        actor.setImageName(ImageUtils.createImage(actorDTO.getImage(), actorDTO.getActorName()));
//        place.setAccount(account);
//        place.setCategory(this.categoryService.getCategory(placeDTO.getCategory().getCategoryId()));
        System.out.println(actor.toString());
        this.actorDao.save(actor);
        
    }

    public void deleteActor(Long actorId) throws Exception {
        ActorDTO actor = getActor(actorId);
        this.actorDao.deleteById(actorId);
    }

    public ActorDTO getActor(Long actorId) throws Exception {
        return ActorMapper.toActorDTO(this.actorDao.findById(actorId).get());
    }

    //Funkcja służąca do wyświetlania obsady danego filmu
    public List<Actor> getActorsByMovieId(Long movieID) {
        Movie movie = movieDao.findById(movieID).get();
        return new ArrayList<>(movie.getActors());
    }


    private Optional<Actor> findActorByName(ActorDTO actorDTO) throws Exception {
        return actorDao.findActorByName(actorDTO.getActorName());
    }

    private void validateAddActor(ActorDTO actorDTO) throws Exception {
        if (findActorByName(actorDTO).isPresent()) {
            throw new Exception("Istnieje już aktor o podanej nazwie.");
        }

    }
}
