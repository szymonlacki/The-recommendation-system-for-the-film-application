import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { UserDetail } from '../common/model/user-detail';
@Injectable({
  providedIn: 'root'
})
export class UserService {


  private _userUrl = 'http://localhost:9090/netflix/rest/user/users';
  private _accesRightsUrl = 'http://localhost:9090/netflix/rest/enums';
  private _url = 'http://localhost:9090/netflix/rest/user/accessRights/';
  private _urlAverage = 'http://localhost:9090/netflix/rest/';
  userData: any = {};
  user = new UserDetail();
  
  constructor(private http: HttpClient) { }

   getUsers(): Observable<any> {
    return this.http.get<any[]>(this._userUrl);
  }

  getAccessRights(): Observable<any> {
    return this.http.get<any[]>(this._accesRightsUrl);
  }

  changeAccessRights(user: UserDetail): Observable<any> {
    return this.http.patch(this._url  + user.userDetailId, user).map(
      result => {
        this.userData = result;
        return result;
      }
    );
  }

   //Pobieranie średniej danego filmu na podstawie usera
   getAverageOfUserRating(accountId: number): Observable<any> {
    return this.http.get<any>(this._urlAverage + 'rating/average/' + accountId);
  }

  //Pobieranie liczby ocen usera
  getNumberOfUserRatings(accountId: number): Observable<any> {
    return this.http.get<any>(this._urlAverage + 'rating/quantity/' + accountId);
  }

   //Pobieranie liczby list filmów usera
   getNumberOfUserMoviesList(accountId: number): Observable<any> {
    return this.http.get<any>(this._urlAverage + 'moviesList/quantity/' + accountId);
  }
}
