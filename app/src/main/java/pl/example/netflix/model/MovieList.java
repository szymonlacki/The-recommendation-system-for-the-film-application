package pl.example.netflix.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.example.netflix.springapp.dto.MovieDTO;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static org.springframework.data.util.CastUtils.cast;

@Entity
@Table(name ="MOVIE_LIST")

public class MovieList  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOVIE_LIST_ID", nullable = true)
    private Long movie_List_Id;

    private String description, name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    @JsonIgnore
    private Account account;




//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "MOVIE_ID", referencedColumnName="MOVIE_ID",  nullable=true)
//    @JsonIgnore
//    private Movie movie;
//@OneToMany(mappedBy = "movieList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//@JsonIgnore
//private List<Movie> movies;


//    public Movie getMovie() {
//        return movie;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }




    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REMOVE
            })
    @JoinTable(
            name = "Movie_Movie_List",
            joinColumns = {@JoinColumn(name = "MOVIE_LIST_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MOVIE_ID")}
    )
    @JsonIgnore
    private Set<Movie> movies;


    public MovieList() {
    }

    public Long getMovie_List_Id() {
        return movie_List_Id;
    }

    public void setMovie_List_Id(Long movie_List_Id) {
        this.movie_List_Id = movie_List_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "movie_List_Id=" + movie_List_Id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", movies=" + movies +
                '}';
    }
}
