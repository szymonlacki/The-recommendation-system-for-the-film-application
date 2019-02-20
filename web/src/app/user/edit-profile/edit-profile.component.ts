/*import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
*/

import { Component, OnInit } from '@angular/core';
import { UserDetail } from '../../common/model/user-detail';
import { StoreService } from '../../common/store.service';
import { AuthorizationService } from '../../authorization/authorization.service';
import { FormBuilder, FormControl, Validators, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  user = new UserDetail();

  editUserForm: FormGroup;
  repeatPassword: string;
  errorMessages: string = '';
  hide = true;


  color = 'primary';
  mode = 'determinate';
  value = 50;
  showText='60';
  diameter = '50';
  constructor(private store: StoreService,
              private authService: AuthorizationService,
              private formBuilder: FormBuilder,
              private toastr: ToastrService,) { }

              nameControl = new FormControl('', [Validators.required]);
  emailControl = new FormControl('', [Validators.required, Validators.email]);
  loginControl = new FormControl('', [Validators.required, Validators.minLength(5),]);
  passwordControl = new FormControl('', [Validators.required, Validators.minLength(5),]);
  repeatpasswordControl = new FormControl('', [Validators.required, Validators.minLength(5),]);
  ageControl = new FormControl('', [Validators.required, Validators.pattern("-?[0-9]+(\.[0-9][0-9]?)?"),Validators.min(1)]);
  
  ngOnInit() {
    this.user = this.store.currentAccount;
    
  }

  editUserAccount() {
    this.errorMessages = '';

    if(this.user.account.password !== this.repeatPassword) {
      this.errorMessages += 'Wpisane hasła nie są takie same.\n';
    }

    if(this.errorMessages.length === 0) {
      this.authService.updateAccount(this.user).subscribe(result => {
          this.store.currentAccount = result;
          this.toastr.success('Edycja przebiegła pomyślnie', 'Sukces');
        },
        error => {
          this.errorMessages += error.error + '\n';
            this.toastr.error('Coś poszło nie tak', 'Błąd');
        }
      );
    }
  }

  deleteAccount() {
    this.authService.deleteUser(this.user.userDetailId).subscribe(() => {});
  }

}

