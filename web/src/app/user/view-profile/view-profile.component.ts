import { Component, OnInit } from '@angular/core';
import { UserDetail } from '../../common/model/user-detail';
import { StoreService } from '../../common/store.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent implements OnInit {
  color = 'primary';
  mode = 'determinate';
  value = 50;
  showText='60';
  diameter = '50';
  user: UserDetail;
  userAverage: number;
  quantityOfRating: number;
  quantityOfMoviesList: number;
;
  
  constructor(private store: StoreService, private userService:UserService) { }

  ngOnInit() {
    this.user = this.store.currentAccount;
    this.userService.getAverageOfUserRating(this.user.account.accountId).subscribe(res => {
      this.userAverage = res;
    });
    this.userService.getNumberOfUserRatings(this.user.account.accountId).subscribe(res => {
      this.quantityOfRating = res;
    });
    this.userService.getNumberOfUserMoviesList(this.user.account.accountId).subscribe(res => {
      this.quantityOfMoviesList = res;
    });
  }

}
