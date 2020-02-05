setTimeout(() => {
    console.log("hello");
}, 2000)

var getData = function () {
    return new Promise((resolve, reject) => {
        var r = Math.floor(Math.random() * 10);
        if (r == 0) {
            resolve("Number is:" + r);
        } else
            reject("In reject :" + r);
    })
}

getData()
    .then((r) => {
        console.log(r)
    })
    .catch((err) => {
        console.log(err)
    });

function Student(fName, lName) {
    this.fName = fName;
    this.lName = lName;

    this.show1 = function () {
        setTimeout(function () {
            console.log("this is:", this);
            console.log(`${this.fName} ${this.lName}`)
        }, 3000);
    }

    this.show2 = function () {
        var that = this;
        setTimeout(function () {
            console.log("this is:", that)
            console.log(`${that.fName} ${that.lName}`)
        }, 4000)
    }

    this.show3 = function () {
        setTimeout(() => {
            console.log("this is: ", this)
            console.log(`${this.fName} ${this.lName}`)
        }, 5000)
    }

}

var s1 = new Student("a", "b");
s1.show1();
s1.show2();
s1.show3();