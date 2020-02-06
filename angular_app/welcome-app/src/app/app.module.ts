import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { WelcomeComponent } from '../app/welcome/welcome.component';
import { StudentComponent } from './student/student.component';

@NgModule({
  declarations: [
    WelcomeComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [StudentComponent]
})
export class AppModule { }
