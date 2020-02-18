import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { CareerComponent } from './career/career.component';
import { DeptComponent } from './dept/dept.component';
import { RouterModule } from '@angular/router';
import { routeArray } from './RouteConfig';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    NotFoundComponent,
    CareerComponent,
    DeptComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routeArray)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
