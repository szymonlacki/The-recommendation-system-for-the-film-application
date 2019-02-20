import { Component, OnInit } from '@angular/core';
import { ActorService } from '../actor.service';

@Component({
  selector: 'app-actors',
  templateUrl: './actors.component.html',
  styleUrls: ['./actors.component.css']
})
export class ActorsComponent implements OnInit {

  actors: any[];
  page: number;
  start:number = 0;
  end:number =12;
  constructor(private actorService: ActorService) { this.page = 1; }

  ngOnInit() {
    this.actorService.getActors().subscribe(val => this.actors = val.slice(this.start,this.end));

  }

  getByPage(pageArg: number) {
    // this.start = this.start+this.end;
    this.end = 2* this.end;
    this.actorService.getActors().subscribe(val => this.actors = val.slice(this.start,this.end));
  }

  goPage(go: number) {
    let newPage = this.page + go;
    this.page = newPage;
    this.getByPage(newPage);
    console.log("STRONA "+ this.page);


  }
}
