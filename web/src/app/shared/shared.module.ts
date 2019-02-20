import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from "@angular/forms";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

import { MatButtonModule, MatListModule, MatIconModule, MatCardModule, MatMenuModule, MatInputModule, MatButtonToggleModule,
  MatProgressSpinnerModule, MatSelectModule, MatSlideToggleModule, MatDialogModule, MatSnackBarModule, MatToolbarModule,
  MatTabsModule, MatSidenavModule, MatTooltipModule, MatRippleModule, MatRadioModule, MatGridListModule,
  MatDatepickerModule, MatNativeDateModule, MatSliderModule, MatAutocompleteModule, MatExpansionModule, MatBottomSheetModule, MatTableModule } from '@angular/material';

// import { CovalentCommonModule, CovalentLayoutModule, CovalentMediaModule, CovalentExpansionPanelModule,
//   CovalentStepsModule, CovalentLoadingModule, CovalentDialogsModule, CovalentSearchModule, CovalentPagingModule,
//   CovalentNotificationsModule, CovalentMenuModule, CovalentDataTableModule, CovalentMessageModule } from '@covalent/core';

import { FlexLayoutModule } from "@angular/flex-layout";
import { CovalentDialogsModule } from '@covalent/core/dialogs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { CdkTableModule } from '@angular/cdk/table';
import { CdkTreeModule } from '@angular/cdk/tree';
import { MovieService } from "../pages/movie/movie.service";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    CdkTableModule,
    BrowserAnimationsModule,
    CdkTreeModule,
    BrowserModule

  ],

  exports: [
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatDatepickerModule,
    MatListModule,
    MatIconModule,
    MatBottomSheetModule,
    MatMenuModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatDialogModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatTabsModule,
    MatSidenavModule,
    MatTooltipModule,
    MatRippleModule,
    MatRadioModule,
    MatGridListModule,
    MatNativeDateModule,
    MatSliderModule,
    MatExpansionModule,
    // CovalentCommonModule,
    // CovalentDataTableModule,
    // CovalentDialogsModule,
    // CovalentExpansionPanelModule,
    // CovalentLayoutModule,
    // CovalentLoadingModule,
    // CovalentMediaModule,
    // CovalentMenuModule,
    // CovalentMessageModule,
    // CovalentNotificationsModule,
    // CovalentPagingModule,
    // CovalentSearchModule,
    // CovalentStepsModule,
    FormsModule,
    HttpClientModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    CovalentDialogsModule,
    MatTableModule
  ],

})
export class SharedModule { }
