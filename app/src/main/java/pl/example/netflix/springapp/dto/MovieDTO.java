package pl.example.netflix.springapp.dto;

import pl.example.netflix.model.MovieList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Queue;

public class MovieDTO implements Serializable {

    private Long movieId;
    private String movieTitle;
    private String movieReleaseDate;
    private String movieYear;
    private String movieDuration;
    private String movieLang;
    private String image;
    private String movieReleaseCountry;
    private String movieDescription;
    private MovieList movieList;

    public MovieList getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieList movieList) {
        this.movieList = movieList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }




    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieLang() {
        return movieLang;
    }

    public void setMovieLang(String movieLang) {
        this.movieLang = movieLang;
    }

    public String getMovieReleaseCountry() {
        return movieReleaseCountry;
    }

    public void setMovieReleaseCountry(String movieReleaseCountry) {
        this.movieReleaseCountry = movieReleaseCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(movieTitle, movieDTO.movieTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(movieTitle);
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieReleaseDate='" + movieReleaseDate + '\'' +
                ", movieYear='" + movieYear + '\'' +
                ", movieDuration='" + movieDuration + '\'' +
                ", movieLang='" + movieLang + '\'' +
                ", image='" + image + '\'' +
                ", movieReleaseCountry='" + movieReleaseCountry + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                '}';
    }

}
