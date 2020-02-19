import { Component, OnInit } from '@angular/core';
import { IStudent, StudentService } from '../StudentService';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  rollNo: number
  name: string
  email: string
  date: string
  age: number
  loading: boolean
  isMale: boolean
  student: IStudent
  successMessage: string
  errorMessage: string
  operationDone: boolean = false
  operationFailed: boolean = false
  constructor(private _service: StudentService) { }

  addStudent() {
    this.loading = true
    this.student = {
      name: this.name, age: this.age, email: this.email, date: this.date,
      rollNo: this.rollNo, isMale: this.isMale
    }
    this._service.addStudent(this.student).subscribe((data: any) => {
      this.operationDone = true
      this.successMessage = "Student added with ID: " + data
      this.loading = false

    }, (err) => {
      this.operationFailed = true;
      this.errorMessage = "Something went wrong!! Please check connectivity & try again."
      this.loading = false
    })
  }

  ngOnInit() {
    this.loading = false;
    console.log(this.rollNo)
    // this.student = {
    //   rollNo: this.student.rollNo, name: this.student.name, date: this.student.date, age: this.student.age,
    //   email: this.student.email, isMale: this.student.isMale
    // }

  }

}
