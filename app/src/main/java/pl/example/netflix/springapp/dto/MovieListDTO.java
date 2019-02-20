package pl.example.netflix.springapp.dto;

import pl.example.netflix.model.Movie;
import pl.example.netflix.model.MovieList;

import java.util.List;

public class MovieListDTO {

    private long movieListId;
    private String name;
    private String description;
    private Long accountId;
    private List<Movie> movies;

    public long getMovieListId() {
        return movieListId;
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie>movies) {
        this.movies = movies;
    }

    public void setMovieListId(long movieListId) {
        this.movieListId = movieListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "MovieListDTO{" +
                "movieListId=" + movieListId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", accountId=" + accountId +
                ", movies=" + movies +
                '}';
    }
}
