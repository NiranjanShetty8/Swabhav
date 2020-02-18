import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StudentService } from './service/StudentService';
import { IStudent } from './service/IStudent';


@Component({
  selector: 'sw-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {

  allStudents: IStudent[]
  constructor(private _service: StudentService) {


  }

  // apiLink = 'http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students';

  // showStudent() {
  //   console.log(this.apiLink);
  //   this._http.get(this.apiLink)
  //     .subscribe((data: any) => {
  //       console.log(data)
  //       let filterData = data.filter((student) => {
  //         console.log(student.rollNo)
  //         if (student.rollNo < 20)
  //           return student;
  //       })
  //       console.log(filterData)
  //     }, (error) => {
  //       this.error = "Error Occurred" + error
  //       console.log(error)
  //     })
  // }


  ngOnInit() {
    // this.showStudent()
    this._service.getAllStudents().subscribe((data: any) => {
      this.allStudents = data;
    }, (err) => {
      console.log('Error:', err);
    })
    // this._service.addStudent()

  }

}
