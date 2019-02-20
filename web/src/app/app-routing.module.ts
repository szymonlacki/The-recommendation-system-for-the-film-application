import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes }  from '@angular/router';


import { PageNotFoundComponent } from "./page-not-found/page-not-found.component";

import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './authorization/login/login.component';
import { RegistrationComponent } from './authorization/registration/registration.component';
import { MoviesComponent } from './pages/movie/movies/movies.component';
import { MovieDetailsComponent } from './pages/movie/movie-details/movie-details.component';
import { AddMovieComponent } from './pages/movie/add-movie/add-movie.component';
import { EditMovieComponent } from './pages/movie/edit-movie/edit-movie.component';
import { SettingsComponent } from './settings/settings.component';
import { AdminComponent } from './admin/admin.component';
import { ListsComponent } from './user/lists/lists.component';
import { ViewProfileComponent } from './user/view-profile/view-profile.component';
import { FavoriteComponent } from './user/favorite/favorite.component';
import { AddActorComponent } from './pages/actor/add-actor/add-actor.component';
import { EditActorComponent } from './pages/actor/edit-actor/edit-actor.component';
import { ActorsComponent } from './pages/actor/actors/actors.component';
import { ActorDetailsComponent } from './pages/actor/actor-details/actor-details.component';
import { UsersComponent } from './user/users/users.component';
import { EditProfileComponent } from './user/edit-profile/edit-profile.component';
import { MoviesByGenreComponent } from './pages/movies-by-genre/movies-by-genre.component';
import { ReviewsComponent } from './user/reviews/reviews.component';


const appRoutes: Routes = [

  { path: 'homepage', component: HomePageComponent },
  { path: '', redirectTo: '/homepage', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'movies', component: MoviesComponent },
  { path: 'movies/:id', component: MovieDetailsComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'movie/add', component: AddMovieComponent },
  { path: 'movie/edit', component: EditMovieComponent },
  { path: 'users', component: UsersComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'profile/edit', component: EditProfileComponent },
  { path: 'lists', component: ListsComponent },
  { path: 'favorite', component: FavoriteComponent },
  { path: 'settings', component: SettingsComponent },
  { path: 'reviews', component: ReviewsComponent },
  { path: '', component: ViewProfileComponent },
  { path: 'actor/add', component: AddActorComponent },
  { path: 'actor/edit', component: EditActorComponent },
  { path: 'profile/view', component: ViewProfileComponent},
  { path: 'actors', component: ActorsComponent },
  { path: 'actors/:id', component: ActorDetailsComponent},
  { path: 'movies/genre/:id', component: MoviesByGenreComponent},
  { path: '**', component: PageNotFoundComponent },


];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false, useHash: false },
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
