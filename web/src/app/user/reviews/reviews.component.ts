import { Component, OnInit } from '@angular/core';
import { UserDetail } from '../../common/model/user-detail';
import { StoreService } from '../../common/store.service';
import { ReviewService } from './review.service';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {

  user: UserDetail;
  
  color = 'primary';
  mode = 'determinate';
  value = 50;
  showText='60';
  diameter = '50';
  accountReviews: any;
  movieReview: String;

  constructor(private store: StoreService, private reviewService: ReviewService) { }

  ngOnInit() {
    this.user = this.store.currentAccount;
    this.reviewService.getReviewsByAccountID(this.user.account.accountId).subscribe(accountReviews => {
      this.accountReviews = accountReviews;
    });
  }
  getMovieByReviewId(reviewId:number){
    
    this.reviewService.getMovieByReviewId(reviewId).subscribe(movieReview => {
      this.movieReview = movieReview;
    })

  }
}