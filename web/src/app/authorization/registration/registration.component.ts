import { Component, OnInit } from '@angular/core';
import { UserDetail } from '../../common/model/user-detail';
import { FormGroup, FormBuilder, FormControl, Validators, NgForm } from '@angular/forms';
import { AuthorizationService } from '../authorization.service';
import { Router } from '@angular/router';
import { StoreService } from '../../common/store.service';
import { UserAccount } from '../../common/model/user-account';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: UserDetail;
  registrationForm: FormGroup;
  password: string;
  errorMessages: string = '';
  form: any;

  constructor(private authService: AuthorizationService,
    private router: Router,
    private store: StoreService,
    private formBuilder: FormBuilder) {
  }


  nameControl = new FormControl('', [Validators.required]);
  emailControl = new FormControl('', [Validators.required, Validators.email]);
  loginControl = new FormControl('', [Validators.required, Validators.minLength(5),]);
  passwordControl = new FormControl('', [Validators.required, Validators.minLength(5),]);
  repeatpasswordControl = new FormControl('', [Validators.required, Validators.minLength(5),]);
  ageControl = new FormControl('', [Validators.required, Validators.pattern("-?[0-9]+(\.[0-9][0-9]?)?"),Validators.min(1)]);


  // getErrorMessage() {
  //   return this.emailControl.hasError('email') ? 'Nieprawidłowy adres email' :
  //     this.nameControl.hasError('required') ? 'To pole jest wymagane' :
      
       
  //         this.passwordControl.hasError('required') ? 'To pole jest wymagane' :
  //         this.passwordControl.hasError('minlength') ? 'Wymagane 5 znaków' :
  //           '';
  // }
  ngOnInit() {

    this.user = new UserDetail();
    this.user.account = new UserAccount();

    // this.registrationForm = new FormGroup({
    //   name: new FormControl('', [Validators.required,
    //     Validators.minLength(1),] ),
    //   'email': new FormControl(this.user.email, [
    //     Validators.required,
    //     Validators.pattern("[^ @]*@[^ @]*"),
    //     Validators.minLength(1),

    //   ]),
    //   login: new FormControl('', [
    //     Validators.minLength(5),
    //     Validators.required
    //   ]),
    //   password: new FormControl('', [
    //     Validators.minLength(5),
    //     Validators.required
    //   ]),
    //   repeatPassword: new FormControl('', [
    //     Validators.minLength(5),
    //     Validators.required
    //   ]),
    //   age: new FormControl('', [
    //      Validators.pattern("-?[0-9]+(\.[0-9][0-9]?)?"),
    //     Validators.min(1),
    //     Validators.required
    //   ]),
    // });


  }
  get name() { return this.registrationForm.get('name'); }
  onSubmit(): void {
    this.errorMessages = '';
    if (this.user.account.password !== this.password) {
      this.errorMessages += 'Wpisane hasła nie są takie same.';
    }

    if (this.errorMessages.length === 0) {
      this.authService.registration(this.user).subscribe(result => {
        this.store.currentAccount = result;
        this.router.navigate(["movies"]);
      },
        error => {
          this.errorMessages += error.error;
        }
      );
    }
  }
}







