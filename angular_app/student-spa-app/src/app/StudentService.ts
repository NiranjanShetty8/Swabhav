import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';


@Injectable({
    providedIn: "root"
})

export class StudentService {
    student: IStudent;
    allStudents: IStudent[];
    // studentsLink = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students"
    studentsLink = 'http://127.0.0.1:8080/api/techlabs/students'

    constructor(private _http: HttpClient) {

    }
    getAllStudents(): Observable<IStudent[]> {
        return new Observable<IStudent[]>((observer) => {
            this._http.get(this.studentsLink)
                .subscribe((data: IStudent[]) => {
                    observer.next(data);
                }, (err) => {
                    observer.error(`*Check your Internet connection.* `);
                });
        });
    }

    addStudent(student: IStudent): Observable<any> {
        console.log(student)
        return new Observable<any>((observer) => {
            this._http.post(this.studentsLink, student)
                .subscribe((data: any) => {
                    observer.next(data)
                    // student.id = data;
                }, (error) => {
                    observer.error(error.message)

                })
        });
    }

    getStudentById(id: string): Observable<IStudent> {
        return new Observable<IStudent>((observer) => {
            this._http.get(this.studentsLink + "/" + id)
                .subscribe((data: IStudent) => {
                    console.log(typeof (data))
                    console.log(data)
                    observer.next(data[0])
                    this.student = data;
                }, (error) => {
                    observer.error(`${error.message}`);
                })
        })
    }

    editStudent(student: IStudent, id: string): Observable<any> {
        return new Observable<any>((observer) => {
            this._http.put(this.studentsLink + "/" + id, student)
                .subscribe((data: any) => {
                    observer.next(data)
                }, (error) => {
                    observer.error(`${error.message}`);
                })

        })
    }

    deleteStudent(id: string): Observable<any> {
        return new Observable<any>((observer) => {
            this._http.delete(this.studentsLink + "/" + id)
                .subscribe((data: any) => {
                    observer.next(data)
                }, (error) => {
                    observer.error(error.message);
                })
        })
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