import { LoginComponent } from './../../../authorization/login/login.component';
import { Component, OnInit, Inject, OnDestroy } from '@angular/core';
import { MovieService } from '../movie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../movies/movie.module';
import { Rate } from '../../../common/model/Rate';
import { StoreService } from '../../../common/store.service';
import 'rxjs/add/operator/switchMap';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { UserDetail } from '../../../common/model/user-detail';
import {
  FormGroup,
  Validators,
  FormBuilder,
  FormControl
} from '@angular/forms';
import { MovieList } from '../../../common/model/movieList';
import { AuthorizationService } from '../../../authorization/authorization.service';
import { ToastrService } from 'ngx-toastr';
import { Review } from '../../../common/model/review';
import { Icu } from '@angular/compiler/src/i18n/i18n_ast';
import { Genre } from '../../../common/model/genre';
import { FavoriteList } from '../../../common/model/favoriteList';

@Component({
  selector: 'app-movie',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit, OnDestroy {

  movie: any;
  rate = new Rate();
  average: any;
  user = new UserDetail();
  ratedMovies: any;
  movieActor: Object;
  movieGenre: Object;
  id: number;
  genreMovie: Object;
  movieReview: Review;
  movieLists: any;
  movieList = new MovieList();
  addedMovie: any;
  favoriteList = new FavoriteList();
  sizeOfFavorite: number;
  addedMovieToFavorite: any;
  favoriteLists = new FavoriteList();
  clicked = false;
  addedToFavoriteMovies: Movie;
  errorMessages = '';
  interval: any;
  reviewId: number;
  accountReview: any;
  i = 0;

  constructor(
    private router: ActivatedRoute,
    private movieService: MovieService,
    private store: StoreService,
    public dialog: MatDialog,
    public authService: AuthorizationService,
    private toastr: ToastrService,
    private routerNavigate: Router,

  ) {}

  // sendMovieId() {
  //   this.movieService.sendMovieId(this.id);
  // }

  // Pobieram sekundy
  time() {
    this.i++;
    if (this.i === 30 && this.authService.isUserLoggedIn) {
      console.log(this.id);
      this.movieService
        .addLongViewedMovie(this.id, this.user.account.login)
        .subscribe(
          res => {
          },
          error => {
            console.log(error);
            this.toastr.error('Coś poszło nie tak', 'Błąd');
          }
        );
    }
    console.log(this.i);
  }

  ngOnInit() {
    // Wywołanie time()
    this.interval = setInterval(() => {
      this.time();
    }, 1000);

    this.user = this.store.currentAccount;
    this.movieList.accountId = this.store.currentAccount.account.accountId;
    this.movie = new Movie();
    this.router.params.subscribe(params => {
      this.id = params['id'];
      this.movieService.getMovie(this.id).subscribe(movie => {
        this.movie = movie;
        this.rate.movie = movie;
        // this.favoriteList.movies  = movie;
        console.log(this.movie);
      });
      this.movieService.getActorsByMovieID(this.id).subscribe(movieActor => {
        this.movieActor = movieActor;
        console.log(movieActor);
      });
      this.movieService.getGenresByMovieID(this.id).subscribe(movieGenre => {
        this.movieGenre = movieGenre;
        console.log(movieGenre);
      });
      this.movieService.getReviewsByMovieID(this.id).subscribe(movieReview => {
        this.movieReview = movieReview;
        console.log(movieReview);
      });
      this.movieService.getAverageOfMovie(this.id).subscribe(movie => {
        this.average = movie;
        console.log('średnia to', this.average);
      });
      this.movieService
        .getRatedMovieByAccountId(this.user.account.accountId, this.id)
        .subscribe(movie => {
          this.ratedMovies = movie;
          console.log('Filmy to: ', this.ratedMovies);
        });
      this.movieService
        .getFavoritedMovieByAccountId(this.user.account.accountId, this.id)
        .subscribe(movie => {
          this.addedToFavoriteMovies = movie;
          console.log('Filmy to: ', this.ratedMovies);
        });
      this.movieService
        .getSizeOfFavoriteList(this.user.account.accountId)
        .subscribe(movie => {
          this.sizeOfFavorite = movie;
          console.log('Filmy to: ', this.ratedMovies);
        });
      this.movieService
        .getMovieListsByAccountID(this.movieList.accountId)
        .subscribe(movieLists => {
          this.movieLists = movieLists;
          console.log('listy', this.movieLists);
        });
      this.movieService
        .getFavoriteListsByAccountID(this.movieList.accountId)
        .subscribe(favoriteLists => {
          this.favoriteLists = favoriteLists;
          console.log('listyUlubionych', this.favoriteLists);
        });
      this.movieService.getReviewsIdByMovieID(this.id).subscribe(reviewId => {
        this.reviewId = reviewId;
      });
    });
    this.movieService.setNull();

  }

  ngOnDestroy(): void {
    window.clearInterval(this.interval);
  }

  insertFavoriteList() {
    this.favoriteList.accountId = this.store.currentAccount.account.accountId;
    console.log(this.favoriteList);
    this.movieService.insertFavoriteList(this.favoriteList, this.id).subscribe(
      val => {
        this.routerNavigate
          .navigateByUrl('/SampleComponent', { skipLocationChange: true })
          .then(() => this.routerNavigate.navigate(['movies' + '/' + this.id]));
        this.toastr.success('Dodano do ulubionych', 'Sukces');
        // console.log("Obiekt bicz:" + this.favoriteList)
      },
      error => {
        this.toastr.error('Coś poszło nie tak', 'Błąd');
        console.log(error);
      }
    );
  }

  getAccountByReviewID(reviewId: number) {
    this.movieService
      .getAccountByReviewID(reviewId)
      .subscribe(accountReview => {
        this.accountReview = accountReview;
        console.log('Userzy' + this.accountReview);
      });
  }
  addRate() {
    this.rate.accountId = this.store.currentAccount.account.accountId;
    this.movieService.addRate(this.rate).subscribe(
      () => {
        this.toastr.success('Twoja ocena została zapisana', 'Sukces');
        console.log(this.rate);
        this.routerNavigate
          .navigateByUrl('/SampleComponent', { skipLocationChange: true })
          .then(() => this.routerNavigate.navigate(['movies' + '/' + this.id]));
      },
      error => {
        console.log(error);
        this.toastr.error('Coś poszło nie tak', 'Błąd');
      }
    );
  }

  addMovieToCurrentList(movie_List_Id: number, movieId: number) {
    this.movieService.addMovieToCurrentList(movie_List_Id, movieId).subscribe(
      res => {
        this.addedMovie = res;
        this.toastr.success('Dodano pomyślnie ', 'Sukces');
      },
      error => {
        console.log(error);
        this.toastr.error('Coś poszło nie tak', 'Błąd');
        this.errorMessages += error.error;
      }
    );
  }

  addToCurrentFavoriteList(favoriteListId: number, movieId: number) {
    this.movieService
      .addToCurrentFavoriteList(favoriteListId, movieId)
      .subscribe(
        res => {
          this.addedMovieToFavorite = res;
          this.routerNavigate
            .navigateByUrl('/SampleComponent', { skipLocationChange: true })
            .then(() =>
              this.routerNavigate.navigate(['movies' + '/' + movieId])
            );
          this.toastr.success('Dodano pomyślnie ', 'Sukces');
        },
        error => {
          console.log(error);
          this.toastr.error('Coś poszło nie tak', 'Błąd');
        }
      );
  }

  // test(testlogin:String){
  //   this.movieService.test(testlogin).subscribe(res => {

  //   }, error => {
  //     console.log(error);
  //     this.toastr.error('Coś poszło nie tak', 'Błąd');

  //   });
  // }

  openDialogList() {
    const dialogRef = this.dialog.open(MovieDetailsDialogListComponent, {
      data: this.id
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }

  openDialogReview() {
    const dialogRef = this.dialog.open(MovieDetailsDialogReviewComponent, {
      data: this.id
    });

    dialogRef.afterClosed().subscribe(result => {
      this.router.params.subscribe(params => {
        this.id = params['id'];
        this.movieService.getMovie(this.id).subscribe(movie => {
          this.movie = movie;
          this.rate.movie = movie;
          console.log(this.movie);
        });
      });

      console.log(this.id);
    });
  }
}

@Component({
  selector: 'movie-details-dialog-list.component',
  templateUrl: 'movie-details-dialog-list.component.html'
})
export class MovieDetailsDialogListComponent implements OnInit {
  movies: any;
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  movieList = new MovieList();
  myControl = new FormControl();
  movie: Movie;
  listMovies: Movie;
  errorMessages = '';
  user = new UserDetail();

  constructor(
    private _formBuilder: FormBuilder,
    private movieService: MovieService,
    private store: StoreService,
    public authService: AuthorizationService,
    private toastr: ToastrService,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private routerNavigate: Router
  ) {}

  ngOnInit() {
    this.movieList.accountId = this.store.currentAccount.account.accountId;
    console.log('Wstrzyknięte id filmu: ', this.data);
    this.movieService.getMovie(this.data).subscribe(movie => {
      this.movie = movie;
      // this.movieList.movie = movie;
    });
    this.movieService.getMovies().subscribe(val => (this.listMovies = val));
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
  }

  addMovieList() {
    this.movieList.accountId = this.store.currentAccount.account.accountId;
    console.log(this.movieList);

    this.movieService.addMovieList(this.movieList).subscribe(
      val => {
        this.routerNavigate
          .navigateByUrl('/SampleComponent', { skipLocationChange: true })
          .then(() =>
            this.routerNavigate.navigate(['movies' + '/' + this.data])
          );
        this.toastr.success('Utworzono nową listę', 'Sukces');
        console.log('Obiekt bicz:' + this.movieList);
      },
      error => {
        this.toastr.error('Coś poszło nie tak', 'Błąd');
        this.errorMessages = '';
        this.errorMessages += error.error;
        console.log(error);
      }
    );
  }
}

@Component({
  selector: 'movie-details-dialog-review.component',
  templateUrl: 'movie-details-dialog-review.component.html'
})
export class MovieDetailsDialogReviewComponent implements OnInit {
  review = new Review();
  movies: any;
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  movieList = new MovieList();
  myControl = new FormControl();

  movieIdFromInject: any;
  movie = new Movie();
  constructor(
    private _formBuilder: FormBuilder,
    private movieService: MovieService,
    private store: StoreService,
    public authService: AuthorizationService,
    private toastr: ToastrService,
    private router: ActivatedRoute,
    private tmp: MovieDetailsComponent,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private routerNavigate: Router
  ) {}

  ngOnInit() {
    console.log('Wstrzyknięte id filmu: ', this.data);
    this.movieService.getMovie(this.data).subscribe(movie => {
      this.movie = movie;
      this.review.movie = movie;
    });
  }

  addReview() {
    this.review.accountId = this.store.currentAccount.account.accountId;
    this.movieService.addReview(this.review).subscribe(
      () => {
        this.routerNavigate
          .navigateByUrl('/SampleComponent', { skipLocationChange: true })
          .then(() =>
            this.routerNavigate.navigate(['movies' + '/' + this.data])
          );
        this.toastr.success('Twoja recenzja została przesłana', 'Sukces');
        console.log(this.review);
      },
      error => {
        console.log(error);
        this.toastr.error('Coś poszło nie tak', 'Błąd');
      }
    );
  }
}
