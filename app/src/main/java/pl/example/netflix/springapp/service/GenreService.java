package pl.example.netflix.springapp.service;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.example.netflix.model.Genre;
import pl.example.netflix.springapp.dao.GenreDao;
import pl.example.netflix.springapp.dto.GenreDTO;
import pl.example.netflix.springapp.mapper.GenreMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GenreService {

    private final GenreDao genreDao;
    @Autowired
    private MovieService movieService;
    @Autowired
    public GenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    public Set<GenreDTO> getGenres() throws Exception {
        Iterable<Genre> genreIterable = this.genreDao.findAll();
        List<GenreDTO> genreDTOList = new ArrayList<>();

        for(Genre tmpGenre : genreIterable){
            genreDTOList.add(GenreMapper.toGenreDTO(tmpGenre));
        }

        return Sets.newHashSet(genreDTOList);
    }

    public void insertGenre(GenreDTO genreDTO) throws Exception {
        this.genreDao.save(GenreMapper.toGenre(genreDTO));
    }

    public Genre getGenre(Long genreId) throws Exception {
        return genreDao.findById(genreId).get();
    }

//    public List<GenreDTO> searchGenresByMovieId(Long movieId) throws Exception {
//        return this.movieService.getMovie(movieId).gr
//                .stream()
//                .map(tmpGenre -> GenreMapper.toGenreDTO(tmpGenre))
//                .collect(Collectors.toList());
//    }
}
