package pl.example.netflix.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID",nullable = true)
    private Long accountId;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_DETAIL_ID")
    private UserDetail userDetail;

    @OneToMany(mappedBy = "account" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovieList> moviesList;

    @OneToMany(mappedBy = "account" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FavoriteList> favoriteLists;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public List<FavoriteList> getFavoriteLists() {
        return favoriteLists;
    }

    public void setFavoriteLists(List<FavoriteList> favoriteLists) {
        this.favoriteLists = favoriteLists;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<MovieList> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<MovieList> moviesList) {
        this.moviesList = moviesList;
    }

    @Column(name = "ACCESS_RIGHT", nullable = false)
    private String accessRight;

    public Account(String login, String password, UserDetail userDetail, String accessRight) {
        this.login = login;
        this.password = password;
        this.userDetail = userDetail;
        this.accessRight = accessRight;
    }

    public Account() {

    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getAccessRight() { return accessRight; }

    public void setAccessRight(String accessRight) { this.accessRight = accessRight; }


}
