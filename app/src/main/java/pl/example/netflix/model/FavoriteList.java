package pl.example.netflix.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="FAVORITE_LIST")
public class FavoriteList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FAVORITE_LIST_ID")
    private Long favoriteListId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    @JsonIgnore
    private Account account;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REMOVE
            })
    @JoinTable(
            name = "Movie_Favorite_List",
            joinColumns = {@JoinColumn(name = "FAVORITE_LIST_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MOVIE_ID")}
    )
    @JsonIgnore
    private List<Movie> movies;


    public Long getFavoriteListId() {
        return favoriteListId;
    }

    public void setFavoriteListId(Long favoriteListId) {
        this.favoriteListId = favoriteListId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "FavoriteList{" +
                "favoriteListId=" + favoriteListId +
                ", account=" + account +
                ", movies=" + movies +
                '}';
    }

    //    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
