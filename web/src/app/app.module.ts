import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SharedModule } from "./shared/shared.module";

import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AppRoutingModule } from "./app-routing.module";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { PagesComponent } from './pages/pages/pages.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './authorization/login/login.component';
import { AuthorizationService } from './authorization/authorization.service';
import { StoreService } from './common/store.service';
import { RegistrationComponent } from './authorization/registration/registration.component';
import { MoviesComponent } from './pages/movie/movies/movies.component';
import { MovieDetailsComponent, MovieDetailsDialogListComponent,
  MovieDetailsDialogReviewComponent } from './pages/movie/movie-details/movie-details.component';
import { AddMovieComponent } from './pages/movie/add-movie/add-movie.component';
import { EditMovieComponent } from './pages/movie/edit-movie/edit-movie.component';
import { TdDialogService } from '@covalent/core/dialogs';
import { AdminComponent } from './admin/admin.component';

import { SettingsComponent } from './settings/settings.component';

import { ListsComponent } from './user/lists/lists.component';
import { FavoriteComponent } from './user/favorite/favorite.component';
import { ViewProfileComponent } from './user/view-profile/view-profile.component';
import { AddActorComponent } from './pages/actor/add-actor/add-actor.component';
import { EditActorComponent } from './pages/actor/edit-actor/edit-actor.component';
import { ActorsComponent } from './pages/actor/actors/actors.component';
import { ActorDetailsComponent } from './pages/actor/actor-details/actor-details.component';
import { MovieCardComponent } from './pages/movie/movie-card/movie-card.component';
import { ActorCardComponent } from './pages/actor/actor-card/actor-card.component';
import { UsersComponent } from './user/users/users.component';
import { EditProfileComponent } from './user/edit-profile/edit-profile.component';
import { MatStepperModule, MatNativeDateModule, MatStepper } from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { CKEditorModule } from 'ngx-ckeditor';
import { MoviesByGenreComponent } from './pages/movies-by-genre/movies-by-genre.component';
import {RatingModule} from "ngx-rating";
import { ReviewsComponent } from './user/reviews/reviews.component';
import { ProfileMenuComponent } from './user/profile-menu/profile-menu.component';
import { MovieService } from './pages/movie/movie.service';
import { NgMatSearchBarModule } from 'ng-mat-search-bar';
import { MatSearchBarComponent } from 'ng-mat-search-bar/src/app/ng-mat-search-bar/mat-search-bar/mat-search-bar.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PageNotFoundComponent,
    MoviesComponent ,
    MovieDetailsComponent,
    MovieCardComponent,
    PagesComponent,
    HomePageComponent,
    RegistrationComponent,
    AddMovieComponent,
     EditMovieComponent,
     AdminComponent,
    ListsComponent,
    FavoriteComponent,
    SettingsComponent,
    ViewProfileComponent,
    AddActorComponent,
    EditActorComponent,
    ActorsComponent,
    ActorDetailsComponent,
    ActorCardComponent,
    UsersComponent,
    EditProfileComponent,
    MovieDetailsDialogListComponent,
    MovieDetailsDialogReviewComponent,
    MoviesByGenreComponent,
    ReviewsComponent,
    ProfileMenuComponent



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    BrowserAnimationsModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatStepperModule,
    ToastrModule.forRoot(),
    CKEditorModule,
    RatingModule,
    NgMatSearchBarModule

  ],
  providers: [
    AuthorizationService,
    StoreService,
    TdDialogService,
    MoviesComponent,
    MovieDetailsComponent,
    MovieService,



  ],
  entryComponents: [MovieDetailsDialogListComponent, MovieDetailsDialogReviewComponent],

  bootstrap: [AppComponent, MovieDetailsDialogListComponent, MovieDetailsDialogReviewComponent]



})
export class AppModule { }
