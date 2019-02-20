package pl.example.netflix.model;

import pl.example.netflix.springapp.dto.MovieDTO;

import java.util.List;

public class MovieHelper {

    private MovieDTO movieDTO;
    private List<Genre> genreList;
    private List<String> actors;

    public MovieDTO getMovieDTO() {
        return movieDTO;
    }

    public void setMovieDTO(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "MovieHelper{" +
                "movieDTO=" + movieDTO +
                ", genreList=" + genreList +
                ", actors=" + actors +
                '}';
    }
}

