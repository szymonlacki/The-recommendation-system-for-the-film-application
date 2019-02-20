package pl.example.netflix.springapp.dto;

import java.io.Serializable;

public class ActorDTO implements Serializable {

    private Long actorId;
    private String actorName;
    private String actorBirthday;
    private String actorPlaceOfBirth;
    private String actorGender;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String actor_biography;

    public Long getActorId() {
        return actorId;
    }

    public String getActor_biography() {
        return actor_biography;
    }

    public void setActor_biography(String actor_biography) {
        this.actor_biography = actor_biography;
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

    public String getActorBirthday() {
        return actorBirthday;
    }

    public void setActorBirthday(String actorBirthday) {
        this.actorBirthday = actorBirthday;
    }

    public String getActorPlaceOfBirth() {
        return actorPlaceOfBirth;
    }

    public void setActorPlaceOfBirth(String actorPlaceOfBirth) { this.actorPlaceOfBirth = actorPlaceOfBirth; }

    public String getActorGender() {
        return actorGender;
    }

    public void setActorGender(String actorGender) {
        this.actorGender = actorGender;
    }

    @Override
    public String toString() {
        return "ActorDTO{" +
                "actorId=" + actorId +
                ", actorName='" + actorName + '\'' +
                ", actorBirthday='" + actorBirthday + '\'' +
                ", actorPlaceOfBirth='" + actorPlaceOfBirth + '\'' +
                ", actorGender='" + actorGender + '\'' +
                ", image='" + image + '\'' +
                ", actor_biography='" + actor_biography + '\'' +
                '}';
    }
}
