import { Component, OnInit } from '@angular/core';
import { IStudent, StudentService } from '../StudentService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  allStudents: IStudent[]
  errorMessage: string
  deleteMessage: string
  count: number
  loading = true;

  constructor(private _service: StudentService, private _router: Router) {
  }

  deleteStudent(id: any) {
    if (confirm("Are you sure you want to delete?")) {
      this._service.deleteStudent(id)
        .subscribe((data: any) => {
          this.deleteMessage = "Student with id " + id + " has been deleted."
          this.ngOnInit()
        }, (error) => {
          this.errorMessage = "The student does not exist. Please refresh the page."
        })
    }
  }


  ngOnInit() {
    this.loading = true
    this._service.getAllStudents().subscribe((data: any) => {
      this.allStudents = data
      this.count = this.allStudents.length
      this.loading = false
    }, (err) => {
      this.errorMessage = err;
      this.loading = false
    });

  }

}
