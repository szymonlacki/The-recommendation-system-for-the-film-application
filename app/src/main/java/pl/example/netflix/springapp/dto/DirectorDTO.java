package pl.example.netflix.springapp.dto;

import java.io.Serializable;

public class DirectorDTO implements Serializable {

    private Long directorId;
    private String directorName;
    private Number directorBirthday;
    private String directorPlaceOfBirth;
    private String directorGender;

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
}

