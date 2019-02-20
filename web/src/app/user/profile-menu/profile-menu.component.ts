import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../authorization/authorization.service';
import { StoreService } from '../../common/store.service';
import { UserDetail } from '../../common/model/user-detail';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profile-menu',
  templateUrl: './profile-menu.component.html',
  styleUrls: ['./profile-menu.component.css']
})
export class ProfileMenuComponent implements OnInit {
  user = new UserDetail();

 
  hide = true;
  userAverage:number;
  color = 'primary';
  mode = 'determinate';
  value = 50;
  showText='60';
  diameter = '50';
  quantityOfRating: number;


  constructor(private store: StoreService,
              private authService: AuthorizationService,
              private userService: UserService
             ) { }

  
  ngOnInit() {

    this.user = this.store.currentAccount;
    this.userService.getAverageOfUserRating(this.user.account.accountId).subscribe(res => {
      this.userAverage = res;
    });
    this.userService.getNumberOfUserRatings(this.user.account.accountId).subscribe(res => {
      this.quantityOfRating = res;
    });
  
  }
  }


