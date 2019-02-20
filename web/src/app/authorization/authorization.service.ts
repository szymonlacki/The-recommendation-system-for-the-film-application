import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map';
import { UserAccount } from '../common/model/user-account';
import { UserDetail } from '../common/model/user-detail';
import { StoreService } from '../common/store.service';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  private _userUrl = 'http://localhost:9090/netflix/rest/user/';

  isUserLoggedIn = false;
  userData: any = {};
  user = new UserDetail();

  constructor(private http: HttpClient,
              private router: Router, private store: StoreService) {
  }

  login(user: UserAccount): Observable<any> {
    return this.http.post(this._userUrl + 'login', user).map(
      result => {
        this.isUserLoggedIn = true;
        this.userData = result;
        console.warn('success');
        return result;
      }
    );
  }

  registration(user: UserDetail): Observable<any> {
    return this.http.post(this._userUrl + 'registration', user).map(
      result => {
        this.isUserLoggedIn = true;
        this.userData = result;
        console.warn('success');
        return result;
      }
    );
  }

  updateAccount(user: UserDetail): Observable<any> {
    return this.http.patch(this._userUrl + user.userDetailId, user).map(
      result => {
        this.userData = result;
        return result;
      }
    );
  }

  deleteUser(userId: number): Observable<any> {
    return this.http.delete(this._userUrl  + userId);
  }



  logout(): void {


    // window.location.reload();

    this.isUserLoggedIn = false;

    this.router.navigate(['/login']);
    console.log(this.store.currentAccount);


  }
}
