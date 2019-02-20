import { MovieService } from './../../pages/movie/movie.service';
import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { UserAccount } from 'src/app/common/model/user-account';
import { AuthorizationService } from '../authorization.service';
import { Router } from '@angular/router';
import { StoreService } from '../../common/store.service';
import { MatSnackBar } from '@angular/material';
import { store } from '@angular/core/src/render3/instructions';
import { UserDetail } from '../../common/model/user-detail';
import { Subscription } from 'rxjs';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  movieId: number;
  user: UserAccount;
  userName = new UserDetail();
  loginForm: FormGroup;
  errorMessages: String = '';
  tmp: any;
  movieSub: Subscription;


  constructor(public authService: AuthorizationService,
              private router: Router,
              private store: StoreService,
              private formBuilder: FormBuilder,
              public snackBar: MatSnackBar,
              public movieService: MovieService,
              private routerNavigate: Router,
              ) {
  }

//   openSnackBar(action:string,message: string) {
//     if(this.authService.isUserLoggedIn){
//     action="Zalogowano jako "
//     message=this.user.login;
//     this.snackBar.open(action, message, {
//       duration: 2000,
//     });
//   }

//  }



  ngOnInit() {
    this.movieService.getMovieId().subscribe( res => {
  this.tmp = res;
    });
    console.warn('init');
    this.userName = this.store.currentAccount;
    this.user = new UserAccount();
    this.loginForm = this.formBuilder.group({
      login: new FormControl('', [
        Validators.minLength(5),
        Validators.required
      ]),
      password: new FormControl('', [
        Validators.minLength(5),
        Validators.required
      ]),
    });
    if (this.authService.isUserLoggedIn) {
      this.router.navigate(['/movies']);
    }
    this.movieSub = this.movieService.getMovieId().subscribe(result => {
      this.movieId = result;
      console.log('Odebrane id: ' + this.movieId);

      // this.router.navigate(['/login']);

    });
  }
  // ngOnDestroy() {
  //   console.log('destroy');
  //   this.movieSub.unsubscribe();
  // }


  openSnackBar(message: string, action: string) {
    if (this.store.currentAccount) {
    this.snackBar.open(message = 'Zalogowano jako ', action, {
      duration: 2000,
    });
  }
  }
  onSubmit(): void {
    this.errorMessages = '';
    this.authService.login(this.user).subscribe(result => {

        this.store.currentAccount = result;
        console.log(this.store.currentAccount);
        this.openSnackBar('aasdsad', this.userName.name);
        if (this.tmp != null) {
        this.router.navigate(['/movies/' + this.movieId]); }
        if (this.tmp === null) {   this.router.navigate(['/movies/']); }
      },
      error => {
        this.errorMessages += error.error;
      }
    );

  }


}
