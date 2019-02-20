import { Component, OnInit } from '@angular/core';
import { ActorService } from '../actor.service';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../../movie/movie.service';

@Component({
  selector: 'app-actor-details',
  templateUrl: './actor-details.component.html',
  styleUrls: ['./actor-details.component.css']
})
export class ActorDetailsComponent implements OnInit {

  actor: any;
  actorMovie: Object;

  movies: any;
  constructor(
    private router: ActivatedRoute, private actorService: ActorService, private movieService: MovieService) {}

  ngOnInit() {
    this.router.params.subscribe((params) => {
      const id = params['id'];
      this.actorService.getActor(id).subscribe(actor => {
        this.actor = actor;
      });
      this.actorService.getMoviesByActorID(id).subscribe(actorMovie => {
        this.actorMovie = actorMovie;
      });
    })
    this.movieService.getMovies().subscribe(val => this.movies = val);
  }
}
