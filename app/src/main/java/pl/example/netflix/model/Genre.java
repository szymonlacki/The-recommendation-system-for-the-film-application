package pl.example.netflix.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "GENRES")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GENRE_ID")
    private Long genreId;

    @Column(name = "GENRE_TITLE")
    private String genreTitle;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REMOVE
            },
            mappedBy = "genres")
    private Set<Movie> movies;

    public Genre(String  genreTitle) {
        this.genreTitle = genreTitle;
    }

    public Genre() {

    }


    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreTitle='" + genreTitle + '\'' +
                ", movies=" + movies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(genreId, genre.genreId) &&
                Objects.equals(genreTitle, genre.genreTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(genreId, genreTitle);
    }
}
