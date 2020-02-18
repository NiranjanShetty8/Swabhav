import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: "root"
})

export class StudentService {
    student: IStudent;
    allStudents: IStudent[];
    studentsLink = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students"

    constructor(private _http: HttpClient) {


    }
    getAllStudents(): Observable<IStudent[]> {
        return new Observable<IStudent[]>((observer) => {
            this._http.get(this.studentsLink)
                .subscribe((data: IStudent[]) => {
                    // console.log("Inside Service", data);
                    observer.next(data);
                }, (err) => {
                    console.log('Error:', err);
                    observer.error(`Something went wrong. ${err.statusText}`);
                });
        });
    }

    addStudent(): Observable<any> {
        return new Observable<any>((observer) => {
            this._http.post(this.studentsLink, this.student)
                .subscribe((data: any) => {
                    console.log(data)
                    this.student.id = data;
                }, (error) => {
                    console.log(error)

                })
        });
    }

}

export interface IStudent {
    rollNo: number
    name: string
    age: number
    email: string
    date: string
    isMale: boolean
    id?: number
}