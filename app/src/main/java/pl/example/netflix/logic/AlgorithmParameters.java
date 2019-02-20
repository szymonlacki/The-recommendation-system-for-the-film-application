package pl.example.netflix.logic;

import pl.example.netflix.logic.enums.MovieDuration;
import pl.example.netflix.logic.enums.MovieReleaseYear;

public class AlgorithmParameters {
    private MovieReleaseYear movieReleaseYear;
    private MovieDuration movieDuration;
    private String lang, releaseCountry, actors, genres;

    public AlgorithmParameters(MovieReleaseYear movieReleaseYear, MovieDuration movieDuration, String lang, String releaseCountry, String actors, String genres) {
        this.movieReleaseYear = movieReleaseYear;
        this.movieDuration = movieDuration;
        this.lang = lang;
        this.releaseCountry = releaseCountry;
        this.actors = actors;
        this.genres = genres;
    }

    public MovieReleaseYear getMovieReleaseYear() {
        return movieReleaseYear;
    }

    public void setMovieReleaseYear(MovieReleaseYear movieReleaseYear) {
        this.movieReleaseYear = movieReleaseYear;
    }

    public MovieDuration getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(MovieDuration movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getReleaseCountry() {
        return releaseCountry;
    }

    public void setReleaseCountry(String releaseCountry) {
        this.releaseCountry = releaseCountry;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "AlgorithmParameters{" +
                "movieReleaseYear=" + movieReleaseYear +
                ", movieDuration=" + movieDuration +
                ", lang='" + lang + '\'' +
                ", releaseCountry='" + releaseCountry + '\'' +
                ", actors='" + actors + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
