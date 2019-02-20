import { AuthorizationService } from './../../../authorization/authorization.service';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Genre } from 'src/app/common/model/genre';
import { Movie } from '../../../common/model/movie';
import { JSONP_ERR_WRONG_RESPONSE_TYPE } from '@angular/common/http/src/jsonp';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../movie.service';
import { UserDetail } from 'src/app/common/model/user-detail';
import { StoreService } from 'src/app/common/store.service';


@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

  movies: any;
  genre = new Genre();
  genreRes: any[];
  tmp = new Object();
  myControl = new FormControl();
  movie: any;
  topRated: any;
  start:number = 0;
  end:number = 14;
  page: number;
  recommendedMovies: any;
  user = new UserDetail();
  keyWord: any;

  constructor(private movieService: MovieService, private authService: AuthorizationService, private store: StoreService
  ) {this.page = 1; }

  ngOnInit() {
    this.user = this.store.currentAccount;
    this.movieService.getMovies().subscribe(val => this.movies = val); //slice(this.start, this.end))
    this.movieService.getGenres().subscribe(val => this.genreRes = val);
    this.movieService.getTopRatedMovies().subscribe(val => this.topRated = val);
    this.movieService.getRecomendedMovies(this.user.account.login).subscribe(val => this.recommendedMovies = val);
  }

  findMoviesByKeyWord() {
    this.movieService.findMoviesByKeyWord(this.keyWord).subscribe(value => {
      this.movies = value;
      console.log(this.keyWord)
    });
  }
  // reload() {
  //   this.movieService.getMovies().subscribe(val => this.movies = val);
  // }


  getByPage(pageArg: number) {
    // this.start = this.start+this.end;
    this.end = 2* this.end;
    this.movieService.getMovies().subscribe(val => this.movies = val.slice(this.start,this.end));
  }

  goPage(go: number) {
    let newPage = this.page + go;
    this.page = newPage;
    this.getByPage(newPage);
    console.log("STRONA "+ this.page);


  }

  // clear() {
  //   this.genre = null;

  // }

}
