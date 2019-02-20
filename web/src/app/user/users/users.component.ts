import { Component, OnInit } from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import { UserService } from '../user.service';
import { UserAccount } from '../../common/model/user-account';
import { UserDetail } from '../../common/model/user-detail';
import { ToastrService } from 'ngx-toastr';




/**
 * @title Basic use of `<table mat-table>`
 */



@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0', display: 'none'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class UsersComponent implements OnInit {
  users: any;
  checked: boolean = false;

  panelOpenState = false;
  accessRights: any;
  constructor(private userService: UserService, private toastr: ToastrService) { }

  ngOnInit() {
    this.userService.getUsers().subscribe(val=> this.users = val);
    this.userService.getAccessRights().subscribe(val=> this.accessRights = val);
  }

  columnsToDisplay = ['email'];



  changeAccessRights(user:UserDetail) {





      this.userService.changeAccessRights(user).subscribe(result => {
        this.toastr.success('Zmiana przebiegła pomyślnie', 'Sukces');
        // location.reload();
        }, error => {
          // console.log(error);
          this.toastr.error('Coś poszło nie tak', 'Błąd');
        });

  }
}
