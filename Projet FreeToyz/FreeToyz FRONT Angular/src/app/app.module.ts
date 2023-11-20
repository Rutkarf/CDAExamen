// app.module.ts //

import { Component } from '@angular/core';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // N'oublie pas d'importer FormsModule si tu utilises [(ngModel)]
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { ToysComponent } from './toys/toys.component';
import { ToyListComponent } from './toy-list/toy-list.component';
import { ToyDetailComponent } from './toy-detail/toy-detail.component';
import { UserProfileComponent } from './user-profil/user-profile.component';
import { ToyFormComponent } from './toy-form/toy-form.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchComponent } from './search/search.component';
import { NavbarSearchToyComponent } from './navbar-search-toy/navbar-search-toy.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CoverAccueilComponent } from './cover-accueil/cover-accueil.component';
import { CarouselAccueilComponent } from './carousel-accueil/carousel-accueil.component';
import { HowItWorkComponent } from './how-it-work/how-it-work.component';
import { UserProfilEditComponent } from './user-profil-edit/user-profil-edit.component';

import { SocketService } from 'src/services/socket.service';
import { ChatComponent } from './chat/chat.component';



@NgModule({
  declarations: [
    ChatComponent,
    AppComponent,
    FooterComponent,
    HomeComponent,
    ToyListComponent,
    ToyDetailComponent,
    UserProfileComponent,
    ToyFormComponent,
    LoginComponent,
    RegistrationComponent,
    SearchComponent,
    ToysComponent,
    NavbarSearchToyComponent,
    NavbarComponent,
    CoverAccueilComponent,
    CarouselAccueilComponent,
    HowItWorkComponent,
    UserProfilEditComponent,
    NavbarSearchToyComponent,
    CarouselAccueilComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'toys', component: ToysComponent },
      { path: 'profile', component: UserProfileComponent },
      // ... ajoutez d'autres routes selon vos besoins
    ]),
    
  ],


  providers:[SocketService],

  bootstrap: [AppComponent]
})
export class AppModule { }
