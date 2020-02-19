import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HomeComponent } from './home/home.component';
import { AddComponent } from './add/add.component';
import { RouterModule, Event, NavigationStart, NavigationEnd } from '@angular/router'
import { EditComponent } from './edit/edit.component';
import { routeArray } from './RouteConfig';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddComponent,
    EditComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routeArray),
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
