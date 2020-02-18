import { Component, OnInit } from '@angular/core';
import { IStudent, StudentService } from '../StudentService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  allStudents: IStudent[]

  constructor(private _service: StudentService) { }

  ngOnInit() {
    this._service.getAllStudents().subscribe((data: any) => {
      this.allStudents = data;
    }, (err) => {
      console.log(err);
    })
  }

}
