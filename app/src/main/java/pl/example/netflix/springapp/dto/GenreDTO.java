package pl.example.netflix.springapp.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class GenreDTO implements Serializable {

    private Long genreId;
    private String genreTitle;

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
}
