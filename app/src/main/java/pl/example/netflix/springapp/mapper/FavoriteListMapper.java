package pl.example.netflix.springapp.mapper;

import pl.example.netflix.model.FavoriteList;
import pl.example.netflix.springapp.dto.FavoriteListDTO;

public class FavoriteListMapper {


    public static FavoriteList toFavoriteList(FavoriteListDTO favoriteListDTO) {
        FavoriteList favoriteList= new FavoriteList();
        favoriteList.setFavoriteListId(favoriteListDTO.getFavoriteListId());
        favoriteList.setMovies(favoriteListDTO.getMovies());
//        favoriteList.setName(favoriteListDTO.getName());
        return favoriteList;
    }


    public static FavoriteListDTO toFavoriteListDTO(FavoriteList favoriteList) {
        FavoriteListDTO favoriteListDTO= new FavoriteListDTO();
        favoriteListDTO.setFavoriteListId(favoriteList.getFavoriteListId());
//        favoriteListDTO.setName(favoriteList.getName());
        return favoriteListDTO;
    }

}
