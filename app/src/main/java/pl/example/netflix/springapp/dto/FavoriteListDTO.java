package pl.example.netflix.springapp.dto;

import pl.example.netflix.model.Movie;

import java.util.List;

public class FavoriteListDTO {

    private long favoriteListId;
    private String name;
    private Long accountId;
    private List<Movie> movies;

    public long getFavoriteListId() {
        return favoriteListId;
    }

    public void setFavoriteListId(long favoriteListId) {
        this.favoriteListId = favoriteListId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FavoriteListDTO{" +
                "favoriteListId=" + favoriteListId +
                ", name='" + name + '\'' +
                ", accountId=" + accountId +
                ", movies=" + movies +
                '}';
    }
}
