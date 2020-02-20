import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService, IStudent } from '../StudentService';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  id: string
  student: IStudent
  rollNo: number
  name: string
  email: string
  date: string
  age: number
  loading: boolean
  isMale: any
  successMessage: string
  errorMessage: string
  operationDone: boolean = false
  operationFailed: boolean = false

  constructor(private _service: StudentService, private _route: ActivatedRoute, private _router: Router) {
    this._route.paramMap
      .subscribe((params) => {
        this.id = params.get('id');
      })
  }

  editStudent() {
    this.loading = true
    this.student = {
      name: this.name, age: this.age, email: this.email, date: this.date,
      rollNo: this.rollNo, isMale: this.isMale
    }
    this._service.editStudent(this.student, this.id)
      .subscribe((data: any) => {
        this.successMessage = "Student has been Edited!"
        setTimeout(() => {
          this._router.navigate([''])
        }, 2000);
      }, (error) => {
        this.errorMessage = "Something went wrong. Check connectivity"
        this.loading = false
      })
  }


  ngOnInit() {
    this.loading = true
    this._service.getStudentById(this.id)
      .subscribe((data: IStudent) => {
        this.rollNo = data.rollNo;
        this.name = data.name;
        this.age = data.age;
        this.date = data.date;
        this.email = data.email;
        this.isMale = data.isMale.toString();
        this.loading = false
      }, (error) => {
        this.errorMessage = "Something went wrong"
        this.loading = false

      });
  }


}
