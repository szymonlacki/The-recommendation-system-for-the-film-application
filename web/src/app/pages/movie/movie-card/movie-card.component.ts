import { Component, OnInit, Input } from '@angular/core';
import { MovieService } from '../movie.service';
import { Router } from '@angular/router';
import { StoreService } from '../../../common/store.service';
import { UserDetail } from '../../../common/model/user-detail';
import 'rxjs/add/operator/switchMap';
import { AuthorizationService } from '../../../authorization/authorization.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-movie-card',
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.css']
})
export class MovieCardComponent implements OnInit {

  @Input()
  movie: any;
  movies: any;
  user = new UserDetail();

  constructor(private router: Router,
    private movieService: MovieService,
    private store: StoreService,
    private authService: AuthorizationService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.user = this.store.currentAccount;
  }

  deleteMovie(movieId: number) {
    this.movieService.deleteMovie(movieId).subscribe(() => {
      this.router.navigateByUrl('/SampleComponent', { skipLocationChange: true }).then(() =>
        this.router.navigate(["movies"]));
      this.movies.filter(value => {
        value.movieId !== movieId;
      });
      this.toastr.success('Usunięto pomyślnie', 'Sukces');
    }, error => {
      console.log(error);
      this.toastr.error('Coś poszło nie tak', 'Błąd');
    });



  }

}


