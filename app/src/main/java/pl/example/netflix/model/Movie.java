package pl.example.netflix.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "MOVIE")
public class Movie {
    public Movie(String movieTitle, String movieReleaseDate, String movieYear, String movieDuration, String movieLang, String imageName, String movieReleaseCountry, String movieDescription) {
        this.movieTitle = movieTitle;
        this.movieReleaseDate = movieReleaseDate;
        this.movieYear = movieYear;
        this.movieDuration = movieDuration;
        this.movieLang = movieLang;
        this.imageName = imageName;
        this.movieReleaseCountry = movieReleaseCountry;
        this.movieDescription = movieDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOVIE_ID", nullable = true)
    private Long movieId;

    @Column(name = "MOVIE_TITLE", nullable = true)
    private String movieTitle;

    @Column(name = "MOVIE_RELEASE_DATE", nullable = true)
    private String movieReleaseDate;

    @Column(name = "MOVIE_YEAR", nullable = true)
    private String movieYear;

    @Column(name = "MOVIE_DURATION", nullable = true)
    private String movieDuration;

    @Column(name = "MOVIE_LANG", nullable = true)
    private String movieLang;

    @Column(name = "IMAGE", nullable = true)
    private String imageName;

    @Column(name = "MOVIE_RELEASE_COUNTRY", nullable = true)
    private String movieReleaseCountry;

    @Column(name = "MOVIE_DESCRIPTION", nullable = true, length = 3000)
    private String movieDescription;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rating> ratings;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;



    public Movie() {

    }

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "movies")
    private List<MovieList> movieLists;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REMOVE
            },
            mappedBy = "movies")
    private List<FavoriteList> favoriteLists;

    //    @ManyToMany(cascade = {CascadeType.ALL})
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Movie_Genres",
            joinColumns = {@JoinColumn(name = "MOVIE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "GENRE_ID")}
    )
    @JsonIgnore
    private Set<Genre> genres;



    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Movie_Cast",
            joinColumns = {@JoinColumn(name = "MOVIE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ACTOR_ID")}
    )
    @JsonIgnore
    private Set<Actor> actors;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Movie_Director",
            joinColumns = {@JoinColumn(name = "MOVIE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "DIRECTOR_ID")}
    )
    @JsonIgnore
    private List<Director> directors;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Rating",
            joinColumns = {@JoinColumn(name = "MOVIE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "REVIEW_ID")}
    )


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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getMovieReleaseCountry() {
        return movieReleaseCountry;
    }

    public void setMovieReleaseCountry(String movieReleaseCountry) {
        this.movieReleaseCountry = movieReleaseCountry;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<MovieList> getMovieLists() {
        return movieLists;
    }

    public void setMovieLists(List<MovieList> movieLists) {
        this.movieLists = movieLists;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }



    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<FavoriteList> getFavoriteLists() {
        return favoriteLists;
    }

    public void setFavoriteLists(List<FavoriteList> favoriteLists) {
        this.favoriteLists = favoriteLists;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieReleaseDate='" + movieReleaseDate + '\'' +
                ", movieYear='" + movieYear + '\'' +
                ", movieDuration='" + movieDuration + '\'' +
                ", movieLang='" + movieLang + '\'' +
                ", imageName='" + imageName + '\'' +
                ", movieReleaseCountry='" + movieReleaseCountry + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", genres: " + genres +
                '}';
    }
}
