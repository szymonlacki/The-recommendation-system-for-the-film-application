package pl.example.netflix.springapp.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.netflix.model.FavoriteList;
import pl.example.netflix.springapp.dto.FavoriteListDTO;
import pl.example.netflix.springapp.dto.MovieListDTO;
import pl.example.netflix.springapp.service.FavoriteListService;
import pl.example.netflix.springapp.service.MovieListService;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/netflix/rest/favoriteList")
public class FavoriteListRestController {

    private final FavoriteListService favoriteListService;
    @Autowired
    public FavoriteListRestController(FavoriteListService favoriteListService) {
        this.favoriteListService= favoriteListService;
    }

    //Niepotrzebne, liste tworzę przy rejestracji.
    @RequestMapping(value = "/{movieId}", method = RequestMethod.POST)
    private ResponseEntity insertFavoriteList(@RequestBody FavoriteListDTO favoriteListDTO, @PathVariable("movieId") Long movieId){

        try {
            this.favoriteListService.insertFavoriteList(favoriteListDTO,movieId);

            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/size/{accountId}", method = RequestMethod.GET)
    private ResponseEntity getSizeOfFavoriteList(@PathVariable("accountId") Long accountId){

        try {
            int size = (int) this.favoriteListService.getSizeOfFavoriteList(accountId);

            return new ResponseEntity(size,HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{favoriteListId}/movie/add", method = RequestMethod.GET)
    private ResponseEntity  addToCurrentFavoriteList(@PathVariable("favoriteListId") Long favoriteListId,
                                                  @RequestParam(value = "id") Long movieId){
        try {
            favoriteListService.addToCurrentFavoriteList(favoriteListId, movieId);
            return new ResponseEntity( HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{favoriteListId}/movie/delete", method = RequestMethod.GET)
    private ResponseEntity  deleteMovieFromFavoriteList(@PathVariable("favoriteListId") Long favoriteListId,
                                                     @RequestParam(value = "id") Long movieId){
        try {
            favoriteListService.deleteMovieFromFavoriteList(favoriteListId, movieId);
            return new ResponseEntity( HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "favoriteListId/{accountId}", method = RequestMethod.GET)
    private ResponseEntity  getFavoriteListIdByAccountID(@PathVariable("accountId") Long accountId){
        try {
            Long favoriteListListDTO = this.favoriteListService.getFavoriteListIdByAccountID(accountId);


            return new ResponseEntity(favoriteListListDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "movies/{favoriteListId}", method = RequestMethod.GET)
    private ResponseEntity  getMoviesListsByFavoriteListID(@PathVariable("favoriteListId") Long favoriteListId){
        try {
            List<FavoriteList> favoriteListListDTO = this.favoriteListService.getMoviesListsByFavoriteListID(favoriteListId);


            return new ResponseEntity(favoriteListListDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "favoriteLists/{favoriteListId}", method = RequestMethod.GET)
    private ResponseEntity  getFavoriteListsByAccountId(@PathVariable("favoriteListId") Long favoriteListId){
        try {
            List<FavoriteList> favoriteListListDTO = this.favoriteListService.getFavoriteListsByAccountId(favoriteListId);


            return new ResponseEntity(favoriteListListDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Funkcja służąca sprawdzeniu, czy dany użytkownik dodał do ulubionych dany film
    // (Ten sam uzytkownik moze ocenić dany film tylko raz)
    @RequestMapping(value = "movie/{accountId}/{movieId}", method = RequestMethod.GET)
    private ResponseEntity getFavoritedMovieByAccountId(@PathVariable("accountId") Long accountId, @PathVariable("movieId") Long movieId){
        try {
            List<FavoriteListDTO> favoriteListDTOS = this.favoriteListService.getFavoritedMovieByAccountId(accountId,movieId);
            return new ResponseEntity(favoriteListDTOS, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


