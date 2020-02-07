import { Component, OnInit } from '@angular/core';
import { Pipe, PipeTransform } from '@angular/core';
import { EventManager } from '@angular/platform-browser';

interface IStudent {
  firstName: string,
  lastName: string,
  cgpa: number,
  profilePicture: string
}

@Pipe({ name: 'classifyCgpa' })
export class ClassifyCgpa implements PipeTransform {
  transform(value: number): string {
    if (value > 7.5) {
      return "green"
    } else if (value > 5.5) {
      return "yellow"
    } else {
      return "red"
    }
  }

}

@Component({
  selector: 'swabhav-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})

export class StudentComponent implements OnInit {
  allStudents: IStudent[]
  student: IStudent
  maxHeight: number = 100
  maxWidth: number = 100
  buttonDisabled: boolean = false

  constructor() {
    this.allStudents = [{
      firstName: "Niranjan",
      lastName: "Shetty",
      cgpa: 7.5,
      profilePicture: "/assets/student.jpeg"
    }]
  }


  loadAllStudents() {
    this.allStudents = [{
      firstName: "Niranjan",
      lastName: "Shetty",
      cgpa: 7.5,
      profilePicture: "/assets/student.jpeg"
    }, {
      firstName: "Nilesh",
      lastName: "Yadav",
      cgpa: 6.5,
      profilePicture: "/assets/student.jpeg"
    }, {
      firstName: "Ketan",
      lastName: "Kotian",
      cgpa: 8.0,
      profilePicture: "/assets/student.jpeg"
    }, {
      firstName: "Akshay",
      lastName: "Nadavde",
      cgpa: 1.0,
      profilePicture: "/assets/student.jpeg"
    }, {
      firstName: "Govind",
      lastName: "Yadav",
      cgpa: 8.2,
      profilePicture: "/assets/student.jpeg"
    }]

  }

  changeStudent(event, stud: IStudent) {
    console.log(event.target)
    // console.log(stud)
    // stud.lastName = "Changed"
    stud.cgpa = stud.cgpa + 1
    event.target.disabled = true
    setTimeout(() => {
      event.target.disabled = false
    }, 2000)


  }

  ngOnInit() {
  }

}
