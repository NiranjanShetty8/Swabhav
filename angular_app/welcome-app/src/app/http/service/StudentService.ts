import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: "root"
})

export class StudentService {
    allStudents = [];
    studentsLink = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students"

    constructor(private _http: HttpClient) {


    }

    getAllStudents() {
        // console.log(this.studentsLink)
        this._http.get(this.studentsLink)
            .subscribe((data: any) => {
                this.allStudents = data
                console.log(this.allStudents)
            }, (error) => {
                console.log(error)
            });
        // return this.allStudents
    }

    addStudent() {
        this._http.post(this.studentsLink, { id: 102, name: "Niranjan" })
            .subscribe((data: any) => {
                console.log(data)
            }, (error) => {
                console.log(error)
            })
    }

}