import { Component, OnInit } from '@angular/core';
import { StoreService } from '../../common/store.service';
import { UserDetail } from '../../common/model/user-detail';
import { MovieService } from '../../pages/movie/movie.service';
import { FavoriteList } from '../../common/model/favoriteList';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {
  user: UserDetail;

  color = 'primary';
  mode = 'determinate';
  value = 50;
  showText='60';
  diameter = '50';
  favoriteListId: number;
  favoriteList:FavoriteList;
  moviesOfFavoriteLists:any;
  deletedMovieToFavorite: any;

  constructor(private store: StoreService, private movieService: MovieService,private toastr: ToastrService,
    private routerNavigate:Router) { }

  ngOnInit() {
    this.user = this.store.currentAccount;
    this.movieService.getFavoriteListIdByAccountID(this.user.account.accountId).subscribe(favoriteListId => {
      this.favoriteListId = favoriteListId;
      this.movieService.getMoviesListsByFavoriteListID(this.favoriteListId).subscribe(moviesOfFavoriteLists => {
        this.moviesOfFavoriteLists = moviesOfFavoriteLists;
      });
    });
  
  }
  deleteMovieFromFavoriteList(movieId:number){
    this.movieService.deleteMovieFromFavoriteList(this.favoriteListId,movieId).subscribe(res => {
      this.deletedMovieToFavorite = res;
      this.toastr.success('Usunięto pomyślnie ', 'Sukces');
      this.routerNavigate.navigateByUrl('/SampleComponent', { skipLocationChange: true }).then(() =>
      this.routerNavigate.navigate(["favorite"]));
    }, error => {
      console.log(error);
      this.toastr.error('Coś poszło nie tak', 'Błąd');
    });
  }
  
}

