import { Component, OnInit } from '@angular/core';
import { QuestionBankService } from './service/QuestionBankService'
import { IQuestion } from './service/IQuestion'

@Component({
  selector: 'swabhav-question',
  templateUrl: './question-bank.component.html',
  styleUrls: ['./question-bank.component.css']
})
export class QuestionBankComponent implements OnInit {
  questions: IQuestion[]
  constructor(private _service: QuestionBankService) {
    this.questions = this._service.allQuestions
  }

  getCount() {
    console.log(this._service.allQuestions);
  }
  ngOnInit() {
    this.getCount()

  }

}
