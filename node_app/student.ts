export class Student {
    constructor(private _fName: string, private _lName: string) {
    }

    get FirstName() {
        return this._fName;
    }

    get LastName() {
        return this._lName;
    }

    set LastName(val) {
        this._lName = val;
    }
}

// var s1 = new Student("ab", "cd")
// console.log(s1.FirstName)
// console.log(s1.LastName)
// s1.LastName = "Champ";
// console.log(s1.LastName)

export class Address {
    constructor(private _description: string) {

    }
    display() {
        console.log(this._description)
    }
}
