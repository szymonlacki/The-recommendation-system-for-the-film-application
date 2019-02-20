import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http: HttpClient) { }
  private _url = 'http://localhost:9090/netflix/rest/';

    //Pobranie Opini na podstawie idUsera
    getReviewsByAccountID(accountId: number) {
      return this.http.get<any>(this._url + 'reviews/account/' + accountId);
    }

    getMovieByReviewId(reviewId: number) {
      return this.http.get<any>(this._url + 'reviews/review/movie/' + reviewId);
    }

   
}
