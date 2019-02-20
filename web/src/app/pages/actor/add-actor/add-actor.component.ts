import { Component, OnInit } from '@angular/core';
import { ActorService } from '../actor.service';
import { Actor } from '../../../common/model/actor';
import { Router } from '@angular/router';
import { MovieList } from '../../../common/model/movieList';
import { MovieService } from '../../movie/movie.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-actor',
  templateUrl: './add-actor.component.html',
  styleUrls: ['./add-actor.component.css']
})
export class AddActorComponent implements OnInit {

  movieList = new MovieList();
  actor = new Actor();
  movies: any;
  message: String;
  errorMessages: string = '';

  constructor(
    private actorService: ActorService,
    private router: Router,
    private movieService: MovieService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.movieService.getMovies().subscribe(val => this.movies = val);
  }
 
  addActor() {
    this.actorService.addActor(this.actor).subscribe(val => {
      this.router.navigateByUrl('/SampleComponent', { skipLocationChange: true }).then(() =>
        this.router.navigate(["actors"]));
        this.toastr.success('Dodano pomyślnie', 'Sukces');

    }, error => {
      console.log(error);
      this.toastr.error('Coś poszło nie tak', 'Błąd');
      this.errorMessages = '';
      this.errorMessages += error.error;

    });
    console.log(this.actor);
  }

  readImage(event: any) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();

      reader.onload = (event: any) => {
        this.actor.image = event.target.result;
      };

      reader.readAsDataURL(event.target.files[0]);
    }
  }
}
