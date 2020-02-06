"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Student = /** @class */ (function () {
    function Student(_fName, _lName) {
        this._fName = _fName;
        this._lName = _lName;
    }
    Object.defineProperty(Student.prototype, "FirstName", {
        get: function () {
            return this._fName;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Student.prototype, "LastName", {
        get: function () {
            return this._lName;
        },
        set: function (val) {
            this._lName = val;
        },
        enumerable: true,
        configurable: true
    });
    return Student;
}());
exports.Student = Student;
var s1 = new Student("ab", "cd");
console.log(s1.FirstName);
console.log(s1.LastName);
s1.LastName = "Champ";
console.log(s1.LastName);
var Address = /** @class */ (function () {
    function Address(_description) {
        this._description = _description;
    }
    Address.prototype.display = function () {
        console.log(this._description);
    };
    return Address;
}());
exports.Address = Address;
