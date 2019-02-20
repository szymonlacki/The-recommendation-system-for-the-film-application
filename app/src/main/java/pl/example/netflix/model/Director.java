package pl.example.netflix.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "DIRECTOR")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DIRECTOR_ID")
    private Long directorId;

    @Column(name = "DIRECTOR_NAME", nullable = false)
    private String directorName;

    @Column(name = "DIRECTOR_BIRTHDAY", nullable = false)
    private Number directorBirthday;

    @Column(name = "DIRECTOR_PLACE_OF_BIRTH", nullable = false)
    private String directorPlaceOfBirth;

    @Column(name = "DIRECTOR_GENDER", nullable = false)
    private String directorGender;

    @ManyToMany(mappedBy = "directors")
    private List<Movie> movies;

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Number getDirectorBirthday() {
        return directorBirthday;
    }

    public void setDirectorBirthday(Number directorBirthday) {
        this.directorBirthday = directorBirthday;
    }

    public String getDirectorPlaceOfBirth() {
        return directorPlaceOfBirth;
    }

    public void setDirectorPlaceOfBirth(String directorPlaceOfBirth) {
        this.directorPlaceOfBirth = directorPlaceOfBirth;
    }

    public String getDirectorGender() {
        return directorGender;
    }

    public void setDirectorGender(String directorGender) {
        this.directorGender = directorGender;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
