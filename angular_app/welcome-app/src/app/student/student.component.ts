import { Component, OnInit } from '@angular/core';

interface IStudent {
  firstName: string,
  lastName: string,
  cgpa: number,
  profilePicture: string
}

@Component({
  selector: 'swabhav-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})

export class StudentComponent implements OnInit {
  student: IStudent
  maxHeight: number = 100
  maxWidth: number = 100


  constructor() {
    this.student = {
      firstName: "Niranjan",
      lastName: "Shetty",
      cgpa: 7.5,
      profilePicture: "/assets/student.jpeg"
    }
  }

  ngOnInit() {
  }

}
