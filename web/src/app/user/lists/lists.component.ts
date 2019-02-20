import { Component, OnInit } from '@angular/core';
import { StoreService } from '../../common/store.service';
import { UserDetail } from '../../common/model/user-detail';
import { MovieList } from '../../common/model/movieList';
import { MovieService } from '../../pages/movie/movie.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lists',
  templateUrl: './lists.component.html',
  styleUrls: ['./lists.component.css']
})
export class ListsComponent implements OnInit {
  user: UserDetail;

  color = 'primary';
  mode = 'determinate';
  value = 50;
  showText='60';
  diameter = '50';
  movieList=new MovieList();
  movieLists: any;
  movies:any;
  deletedMovieFromMovieList: any;

  constructor(private store: StoreService, private movieService:MovieService, private toastr: ToastrService,
    private routerNavigate:Router) { }

  ngOnInit() {
    this.user = this.store.currentAccount;
    this.movieList.accountId = this.store.currentAccount.account.accountId;
    this.movieService.getMovieListsByAccountID(this.movieList.accountId).subscribe(movieLists => {
      this.movieLists = movieLists;
      console.log("listy", this.movieLists);
    });
 
   
  }


  deleteMovieFromMovieList(movieListId:number,movieId:number){
    this.movieService.deleteMovieFromMovieList(movieListId,movieId).subscribe(res => {
      this.deletedMovieFromMovieList = res;
      this.toastr.success('Usunięto pomyślnie ', 'Sukces');
      this.routerNavigate.navigateByUrl('/SampleComponent', { skipLocationChange: true }).then(() =>
      this.routerNavigate.navigate(["lists"]));
    }, error => {
      console.log(error);
      this.toastr.error('Coś poszło nie tak', 'Błąd');
    });
  }

getMoviesByMovieListID(id:number){
  this.movieService.getMoviesByMovieListID(id).subscribe(movies => {
    this.movies = movies;
    console.log("filmy", this.movies);
  });

}
}