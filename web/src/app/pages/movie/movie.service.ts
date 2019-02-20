import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

import { Rate } from '../../common/model/Rate';
import { Review } from '../../common/model/review';
import { UserAccount } from '../../common/model/user-account';
import { Movie } from './movies/movie.module';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  rated = new UserAccount();
  private _url = 'http://localhost:9090/netflix/rest/';
  movieIdNavigate: BehaviorSubject<number> = new BehaviorSubject<any>(null);
  constructor(private http: HttpClient) { }

  // Pobieranie wszystkich filmów
  getMovies(): Observable<any> {
    return this.http.get<any[]>(this._url + 'movies');
  }

   // Pobieranie najlepiej ocenianych filmów
   getTopRatedMovies(): Observable<any> {
    return this.http.get<any[]>(this._url + 'movies/topRated');
  }
  // Pobieranie filmu po id
  getMovie(movieId: number): Observable<Movie> {
    return this.http.get<any>(this._url + 'movies/' + movieId);
  }

  // Dodawanie filmu
  addMovie(movie: Movie): Observable<any> {
    return this.http.post<any>(this._url + 'movies', movie);
  }

  // Usuwanie filmu
  deleteMovie(movieId: number): Observable<Movie> {
    return this.http.delete<any>(this._url + 'movies/' + movieId);
  }

  getGenres(): Observable<any> {
    return this.http.get<any[]>(this._url + 'genres');
  }


  // Dodawanie oceny do filmu
  addRate(rate: Rate): Observable<any> {
    return this.http.post(this._url + 'rating', rate).map(
      result => {
        console.warn('success');
        return result;
      }
    );
  }

  addReview(review: Review): Observable<any> {
    return this.http.post(this._url + 'reviews', review).map(
      result => {
        console.warn('success');
        return result;
      }
    );
  }

  // Pobieranie średniej danego filmu
  getAverageOfMovie(movieId: number): Observable<Movie> {
    return this.http.get<any>(this._url + 'rating/' + movieId);
  }


  // Pobranie danego ocenionego filmu przez danego użytkownika(blokada oceny więcej niż
  //    1 raz tego samego filmu przez jednego uzytkownika)
  getRatedMovieByAccountId(accountId: number, movieId: number): Observable<Movie> {
    return this.http.get<any>(this._url + 'rating/movie/' + accountId + '/' + movieId);
  }

  // Tworzenie listy filmów
  addMovieList(movieList: any): Observable<any> {
    return this.http.post<any>(this._url + 'moviesList', movieList);
  }

  // Tworzenie listy filmów
  insertFavoriteList(favoriteList: any, movieId: number): Observable<any> {
    return this.http.post<any>(this._url + 'favoriteList/' + movieId, favoriteList, );
  }

  getMovieListsByAccountID(accountId: number): Observable<any> {
    return this.http.get<any[]>(this._url + 'moviesList/' + accountId);
  }

  getFavoriteListIdByAccountID(accountId: number): Observable<any> {
    return this.http.get<any[]>(this._url + 'favoriteList/favoriteListId/' + accountId);
  }

  getFavoriteListsByAccountID(accountId: number): Observable<any> {
    return this.http.get<any[]>(this._url + 'favoriteList/favoriteLists/' + accountId);
  }
  // Pobranie obsady danego filmu
  getActorsByMovieID(movieId: number) {
    return this.http.get<any>(this._url + 'actors/movie/' + movieId);
  }

   // Pobranie rozmiaru listy ulubionych
   getSizeOfFavoriteList(accountId: number) {
    return this.http.get<any>(this._url + 'favoriteList/size/' + accountId);
  }

  // Pobieranie gatunków na podstawie danego filmu
  getGenresByMovieID(movieId: number) {
    return this.http.get<any>(this._url + 'movies/genre/' + movieId);
  }

  getMoviesByGenreID(genreId: number) {
    return this.http.get<any>(this._url + 'movies/movie/' + genreId);
  }

  // Pobieranie gatunku po id
  getGenre(genreId: number): Observable<Movie> {
    return this.http.get<any>(this._url + 'genres/' + genreId);
  }

  getReviewsByMovieID(movieId: number) {
    return this.http.get<any>(this._url + 'reviews/movie/' + movieId);
  }

  getAccountByReviewID(reviewId: number) {
    return this.http.get<any>(this._url + 'reviews/review/' + reviewId);
  }

   // Pobranie filmów danej listy
   getMoviesByMovieListID(movie_List_Id: number) {
    return this.http.get<any>(this._url + 'moviesList/movies/' + movie_List_Id);
  }

   // Dodanie do istniejącej listy filmów
   addMovieToCurrentList(movie_List_Id: number, movieId: number) {
    return this.http.get<any>(this._url + 'moviesList/' + movie_List_Id + '/movie?id=' + movieId);
  }

   // Dodanie do istniejącej listy filmów ulubionych
   addToCurrentFavoriteList(favoriteListId: number, movieId: number) {
    return this.http.get<any>(this._url + 'favoriteList/' + favoriteListId + '/movie/add?id=' + movieId);
  }

    // Usuwanie filmu z istniejącej listy filmów ulubionych
    deleteMovieFromFavoriteList(favoriteListId: number, movieId: number) {
      return this.http.get<any>(this._url + 'favoriteList/' + favoriteListId + '/movie/delete?id=' + movieId);
    }

     // Usuwanie filmu z istniejącej listy filmów
     deleteMovieFromMovieList(movieListId: number, movieId: number) {
      return this.http.get<any>(this._url + 'moviesList/' + movieListId + '/movie/delete?id=' + movieId);
    }

 getMoviesListsByFavoriteListID(favoriteListId: number) {
    return this.http.get<any>(this._url + 'favoriteList/movies/' + favoriteListId);
  }

  // Pobranie danego ocenionego filmu przez danego użytkownika(blokada oceny więcej niż
  //    1 raz tego samego filmu przez jednego uzytkownika)
  getFavoritedMovieByAccountId(accountId: number, movieId: number): Observable<Movie> {
    return this.http.get<any>(this._url + 'favoriteList/movie/' + accountId + '/' + movieId);
  }

  getReviewsIdByMovieID(movieId: number): Observable<any> {
    return this.http.get<any[]>(this._url + 'reviews/reviewId/' + movieId);
  }

  // test(login:String): Observable<any> {
  //   return this.http.get<any[]>('recommendation/getMovies?login='+login);
  // }

    // Pobieranie czasu
    addLongViewedMovie(movieId: number, login: string) {
      return this.http.get<any>(this._url + 'moviesList/addLongViewed?movieId=' + movieId + '&login=' + login);
    }

    // Przekierowanie spowrotem do filmu bo zalogowaniu

    sendMovieId(movieId: number) {
      this.movieIdNavigate.next(movieId);
      // console.log('Ustawione Id to ' + movieId);
    }

    getMovieId(): Observable<number> {
      return this.movieIdNavigate.asObservable();
    }

    setNull() {
this.movieIdNavigate.next(null);
    }

     // Pobieranie rekomendowanych filmow
     getRecomendedMovies(login: string) {
      return this.http.get<any>('http://localhost:9090/recommendation/getMovies/?login=' + login);
    }

    // Wyszukiwanie filmow po slowie kluczowym
    findMoviesByKeyWord(keyWord: string) {
      return this.http.get<any>(this._url + 'movies/findMovie/' + keyWord);
    }

}

