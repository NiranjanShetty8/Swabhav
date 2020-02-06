"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var student_1 = require("./student");
var add = new student_1.Address("Andheri");
console.log(add);
var stud = new student_1.Student("Niranjan", "Shetty");
console.log(stud);
stud.LastName = "Shettyy";
console.log("After modification", stud);
