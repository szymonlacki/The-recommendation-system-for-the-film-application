package pl.example.netflix.springapp.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.netflix.model.Actor;
import pl.example.netflix.springapp.dto.ActorDTO;
import pl.example.netflix.springapp.service.ActorService;
import java.util.Set;
import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/netflix/rest/actors")
public class ActorRestController {
    private final ActorService actorService;

    @Autowired
    public ActorRestController(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity getActors(){
        try {
            Set<ActorDTO> actorDTOList = this.actorService.getActors();
            return new ResponseEntity(actorDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertActor(@RequestBody ActorDTO actorDTO){
        try {

            this.actorService.insertActor(actorDTO);

            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{actorId}", method = RequestMethod.GET)
    private ResponseEntity getActor(@PathVariable("actorId") Long actorId){
        try {
            ActorDTO actorDTO = this.actorService.getActor(actorId);
            return new ResponseEntity(actorDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{actorId}", method = RequestMethod.DELETE)
    private ResponseEntity deleteActor(@PathVariable("actorId") Long actorId){
        try {
            this.actorService.deleteActor(actorId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "movie/{movieId}", method = RequestMethod.GET)
    private ResponseEntity geActorByMovieId(@PathVariable("movieId") Long movieID){
        try {
            List<Actor> actorDto = this.actorService.getActorsByMovieId(movieID);

            return new ResponseEntity(actorDto, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
