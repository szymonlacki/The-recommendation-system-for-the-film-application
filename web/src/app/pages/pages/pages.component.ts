import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../authorization/authorization.service';
import { StoreService } from '../../common/store.service';
import { UserDetail } from '../../common/model/user-detail';

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.css']
})
export class PagesComponent implements OnInit {


  user = new UserDetail();
  accessRight: string;

  constructor(public authService: AuthorizationService,
    private store: StoreService) {
}

ngOnInit() {
  this.user = this.store.currentAccount;
  this.authService.user.account.accessRight = this.accessRight;


}

showAccess()
{
  console.log(this.store.currentAccount);

}
logout(): void {

  this.authService.logout();

}



}
