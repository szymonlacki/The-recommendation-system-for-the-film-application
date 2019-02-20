import { Component, OnInit, Input } from '@angular/core';
import { UserDetail } from '../../../common/model/user-detail';
import { StoreService } from '../../../common/store.service';
import { AuthorizationService } from '../../../authorization/authorization.service';
import { ActorService } from '../actor.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-actor-card',
  templateUrl: './actor-card.component.html',
  styleUrls: ['./actor-card.component.css']
})
export class ActorCardComponent implements OnInit {

  @Input()
  actor: any;

  user = new UserDetail();

  actors: any[];

  constructor(private store: StoreService, private authService: AuthorizationService, 
    private actorService: ActorService, private router: Router, private toastr: ToastrService) { }

  ngOnInit() {
    this.user = this.store.currentAccount;
  }

  deleteActor(actorId: number) {
    this.actorService.deleteActor(actorId).subscribe(() => {
      this.router.navigateByUrl('/SampleComponent', { skipLocationChange: true }).then(() =>
        this.router.navigate(["actors"]));
        this.toastr.success('Usunięto pomyślnie', 'Sukces');
    }, error => {
      console.log(error);
      this.toastr.error('Coś poszło nie tak', 'Błąd');
    });


  }

}
