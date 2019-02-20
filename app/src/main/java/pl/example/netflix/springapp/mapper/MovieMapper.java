package pl.example.netflix.springapp.mapper;

import pl.example.netflix.model.Movie;
import pl.example.netflix.model.MovieList;
import pl.example.netflix.springapp.dto.MovieDTO;
import pl.example.netflix.springapp.dto.MovieListDTO;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class MovieMapper {
    public static Movie toMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setMovieId(movieDTO.getMovieId());
        movie.setMovieTitle(movieDTO.getMovieTitle());
        movie.setMovieReleaseDate(movieDTO.getMovieReleaseDate());
        movie.setMovieYear(movieDTO.getMovieYear());
        movie.setMovieDuration(movieDTO.getMovieDuration());
        movie.setMovieLang(movieDTO.getMovieLang());
        movie.setImageName(movieDTO.getImage());
        movie.setMovieReleaseCountry(movieDTO.getMovieReleaseCountry());
        movie.setMovieDescription((movieDTO.getMovieDescription()));
        return movie;
    }
    public static List<Movie> toMovieList(List<MovieDTO> movieListDTOQueue){
        return movieListDTOQueue.stream()
                .map(tmpPlace -> toMovie(tmpPlace))
                .collect(Collectors.toList());
    }

    public static MovieDTO toMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movie.getMovieId());
        movieDTO.setMovieTitle(movie.getMovieTitle());
        movieDTO.setMovieReleaseDate(movie.getMovieReleaseDate());
        movieDTO.setMovieYear(movie.getMovieYear());
        movieDTO.setMovieDuration(movie.getMovieDuration());
        movieDTO.setMovieLang(movie.getMovieLang());
        movieDTO.setImage(movie.getImageName());
        movieDTO.setMovieReleaseCountry(movie.getMovieReleaseCountry());
        movieDTO.setMovieDescription(movie.getMovieDescription());

        return movieDTO;
    }

}
