import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { IStudent } from './IStudent'
import { Observable } from 'rxjs';


@Injectable({
    providedIn: "root"
})

export class StudentService {
    allStudents: IStudent[];
    studentsLink = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students"

    constructor(private _http: HttpClient) {


    }

    // getAllStudents() {
    //     console.log(this.studentsLink)
    //     console.log("there?")
    //     this._http.get(this.studentsLink)
    //         .subscribe((data: IStudent[]) => {
    //             console.log("check", data)
    //             this.allStudents = data
    //             console.log("HEre ", this.allStudents)
    //             // return 

    //         }, (error) => {
    //             console.log(error)
    //             // observer.error(`Something went wrong ${error.statusText}`)
    //         });
    // }



    getAllStudents(): Observable<any> {
        return new Observable<any>((observer) => {
            console.log("Inside")
            this._http.get(this.studentsLink)
                .subscribe((data: IStudent[]) => {
                    console.log("Inside Service", data);
                    observer.next(data);
                }, (err) => {
                    console.log('Error:', err);
                    observer.error(`Something went wrong. ${err.statusText}`);
                });
        });
    }

    addStudent() {
        this._http.post(this.studentsLink, { rollNo: 102, name: "Niranjan", isMale: true })
            .subscribe((data: any) => {
                console.log(data)
            }, (error) => {
                console.log(error)
            })
    }

}