package pl.example.netflix.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ACTOR")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACTOR_ID")
    private Long actorId;

    @Column(name = "ACTOR_NAME")
    private String actorName;

    @Column(name = "ACTOR_BIRTHDAY" )
    private String actorBirthday;

    @Column(name = "ACTOR_PLACE_OF_BIRTH")
    private String actorPlaceOfBirth;

    @Column(name = "IMAGE", nullable = false)
    private String imageName;

    @Column(name = "ACTOR_BIOGRAPHY", nullable = true, length = 3000)
    private String actor_biography;

    @Column(name = "ACTOR_GENDER" )

    private String actorGender;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;

    public Actor(String actorName, String actorBirthday, String actorPlaceOfBirth, String actorGender, String imageName, String actorBiography) {
        this.actorName = actorName;
        this.actorBirthday = actorBirthday;
        this.actorPlaceOfBirth = actorPlaceOfBirth;
        this.actorGender = actorGender;
        this.imageName = imageName;
        this.actor_biography = actorBiography;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Actor() {


    }

    public String getActorBirthday() {
        return actorBirthday;
    }

    public void setActorBirthday(String actorBirthday) {
        this.actorBirthday = actorBirthday;
    }
    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }


    public String getActorPlaceOfBirth() {
        return actorPlaceOfBirth;
    }

    public void setActorPlaceOfBirth(String actorPlaceOfBirth) {
        this.actorPlaceOfBirth = actorPlaceOfBirth;
    }

    public String getActorGender() {
        return actorGender;
    }

    public void setActorGender(String actorGender) {
        this.actorGender = actorGender;
    }
    public String getActor_biography() {
        return actor_biography;
    }

    public void setActor_biography(String actor_biography) {
        this.actor_biography = actor_biography;
    }

}