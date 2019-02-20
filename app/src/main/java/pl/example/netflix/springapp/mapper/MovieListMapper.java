package pl.example.netflix.springapp.mapper;

import pl.example.netflix.model.Movie;
import pl.example.netflix.model.MovieList;
import pl.example.netflix.springapp.dto.MovieDTO;
import pl.example.netflix.springapp.dto.MovieListDTO;

import java.util.HashSet;
import java.util.Queue;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieListMapper {

    public static List<MovieList> toMovieList(Queue<MovieListDTO> movieDTOQueue){
        return movieDTOQueue.stream()
                .map(tmpMovie -> toMovieList(tmpMovie))
                .collect(Collectors.toList());
    }



    public static MovieList toMovieList(MovieListDTO movieListDTO) {
        MovieList movieList= new MovieList();
        movieList.setMovie_List_Id(movieListDTO.getMovieListId());
        movieList.setDescription(movieListDTO.getDescription());
//  movieList.setMovies(MovieMapper.toMovie(movieListDTO.getMovies()));
        movieList.setName(movieListDTO.getName());
        movieList.setMovies(new HashSet<>(movieListDTO.getMovies()));
        return movieList;
    }


    public static MovieListDTO toMovieListDTO(MovieList movieList) {
        MovieListDTO movieListDTO= new MovieListDTO();
        movieListDTO.setMovieListId(movieList.getMovie_List_Id());
        movieListDTO.setDescription(movieList.getDescription());
//    movieListDTO.setMovies(MovieMapper.toMovieDTO(movieList.getMovies()));
        movieListDTO.setName(movieList.getName());

        return movieListDTO;
    }
}
