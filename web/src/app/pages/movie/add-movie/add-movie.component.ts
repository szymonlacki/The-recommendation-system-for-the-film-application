import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Movie } from '../../../common/model/movie';
import { MovieService } from '../movie.service';
import { ActorService } from '../../actor/actor.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  myControl = new FormControl();
  genreRes: any[];
  actorRes: any[];
  movie = new Movie();
  model = {
    movieDTO: new Movie(),
    genreList: [],
    actors: [],
  }
  errorMessages: string = '';


  constructor(private movieService: MovieService, private actorService: ActorService, private router: Router, 
    private toastr: ToastrService) { }

  ngOnInit() {
    this.movieService.getGenres().subscribe(val => this.genreRes = val);
    this.actorService.getActors().subscribe(val => this.actorRes = val);
  }


  
   
  

  addMovie() {
    
    this.movieService.addMovie(this.model).subscribe(() => {
      this.router.navigateByUrl('/SampleComponent', { skipLocationChange: true }).then(() =>
        this.router.navigate(["movies"]));
        this.toastr.success('Dodano pomyślnie', 'Sukces');
    }, error => {
      // console.log(error);
      this.toastr.error('Coś poszło nie tak', 'Błąd');
      this.errorMessages = '';
      this.errorMessages += error.error;
      
    });
    // console.log(this.model)
  
  }


 

  readImage(event: any) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();

      reader.onload = (event: any) => {
        this.model.movieDTO.image = event.target.result;
      };

      reader.readAsDataURL(event.target.files[0]);
    }
  }
}
