import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { WelcomeComponent } from '../app/welcome/welcome.component';
import { StudentComponent, ClassifyCgpa } from './student/student.component';
import { TwowayComponent } from './twoway/twoway.component';
import { BlueballComponent } from './blueball/blueball.component';
import { QuestionBankComponent } from './question-bank/question-bank.component';
import { MasterComponent } from './master/master.component';
import { ToggleComponent } from './toggle/toggle.component';

@NgModule({
  declarations: [
    WelcomeComponent,
    StudentComponent,
    ClassifyCgpa,
    TwowayComponent,
    BlueballComponent,
    QuestionBankComponent,
    MasterComponent,
    ToggleComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [MasterComponent]
})
export class AppModule { }
