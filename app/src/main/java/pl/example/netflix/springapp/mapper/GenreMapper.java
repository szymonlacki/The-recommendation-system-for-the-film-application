package pl.example.netflix.springapp.mapper;

import pl.example.netflix.model.Genre;
import pl.example.netflix.springapp.dto.GenreDTO;

public class GenreMapper {

    public static Genre toGenre(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setGenreId(genreDTO.getGenreId());
        genre.setGenreTitle(genreDTO.getGenreTitle());

        return genre;
    }


    public static GenreDTO toGenreDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setGenreId(genre.getGenreId());
        genreDTO.setGenreTitle(genre.getGenreTitle());

        return genreDTO;
    }
}
