import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../movie/movie.service';

@Component({
  selector: 'app-movies-by-genre',
  templateUrl: './movies-by-genre.component.html',
  styleUrls: ['./movies-by-genre.component.css']
})
export class MoviesByGenreComponent implements OnInit {


  genreMovie:any;
  genre: any;
  constructor( private router: ActivatedRoute,
    private movieService: MovieService) { }

  ngOnInit() {

    this.router.params.subscribe((params) => {
      const id = params['id'];
      this.movieService.getGenre(id).subscribe(genre => {
        this.genre = genre;
        console.log(genre)
      });
      this.movieService.getMoviesByGenreID(id).subscribe(genreMovie => {
        this.genreMovie = genreMovie;
      });
    })
  }

}
