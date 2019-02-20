package pl.example.netflix.springapp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.example.netflix.model.Genre;
import pl.example.netflix.springapp.dto.GenreDTO;
import pl.example.netflix.springapp.mapper.GenreMapper;
import pl.example.netflix.springapp.service.GenreService;

import java.util.List;
import java.util.Set;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/netflix/rest/genres")
public class GenreRestController {

    private final GenreService genreService;

    @Autowired
    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity getGenres(){
        try {
            Set<GenreDTO> genreDTOList = this.genreService.getGenres();
            return new ResponseEntity(genreDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertGenre(@RequestBody GenreDTO genreDTO){
        try {
            this.genreService.insertGenre(genreDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{genreId}", method = RequestMethod.GET)
    private ResponseEntity getGenre(@PathVariable("genreId") Long genreId){
        try {
            Genre genreDTO = this.genreService.getGenre(genreId);
            return new ResponseEntity(genreDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
