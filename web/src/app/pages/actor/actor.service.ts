import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Actor } from '../../common/model/actor';
import { Rate } from '../../common/model/Rate';


@Injectable({
  providedIn: 'root'
})
export class ActorService {

  private _url = 'http://localhost:9090/netflix/rest/';

  constructor(private http: HttpClient) { }

  getGenres(): Observable<any> {
    return this.http.get<any[]>(this._url + 'actors');
  }

  //Dodanie aktora
  addActor(actor: Actor): Observable<any> {
    return this.http.post<any>(this._url + 'actors', actor);
  }

  //Pobranie aktorów
  getActors(): Observable<any> {
    return this.http.get<any[]>(this._url + 'actors')
  }

  //Pobranie konkretnego aktora
  getActor(actorId: number): Observable<Actor> {
    return this.http.get<any>(this._url + 'actors/' + actorId);
  }

  //Usuwanie aktora
  deleteActor(actorId: number): Observable<Actor> {
    return this.http.delete<any>(this._url + 'actors/' + actorId);
  }

  //Pobranie filmów, w których gra dany aktor
  getMoviesByActorID(actorId: number) {
    return this.http.get<any>(this._url + 'movies/actor/' + actorId);
  }

}
