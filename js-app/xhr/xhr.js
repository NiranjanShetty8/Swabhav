var button = document.getElementById("button");
button.addEventListener("click", getFacts);
var writeFacts = document.getElementById("facts");
var allSearches = [];
var search = {};
var checkbox = document.getElementById("check");
checkbox.addEventListener('click', (e) => {
    if (e.target.checked) {
        getEvenSearches();
    } else {
        getPrevousSearches();
    }
});
getPrevousSearches();

function getPrevousSearches() {
    var stringAll = localStorage.getItem("allSearches");
    if (stringAll != null) {
        allSearches = JSON.parse(stringAll);
        writeFacts.innerHTML = "";

        for (var search of allSearches) {
            writeFacts.innerHTML += "<br>" + search.number + " " + search.text + " " + search.timeStamp;
        }
    }
};

function getFacts() {

    var number = document.getElementById("textArea").value;
    if (isNaN(parseInt(number))) {
        var warning = document.getElementById("warning");
        warning.innerHTML = "*Please Enter a number";
        document.getElementById("textArea").value = "";
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open('GET', 'http://numbersapi.com/' + number);
        xhr.onload = () => {

            search = { number: number, text: xhr.response, timeStamp: new Date() };
            allSearches.push(search);
            var stringAllSearches = JSON.stringify(allSearches);
            localStorage.setItem("allSearches", stringAllSearches);
            getPrevousSearches();
        }
        xhr.send();
    }
}

function getEvenSearches() {
    var stringAll = localStorage.getItem("allSearches");
    if (stringAll != null) {
        allSearches = JSON.parse(stringAll);
        writeFacts.innerHTML = "";
        var stringEvenNumbers;
        for (var search of allSearches) {
            if (search.number % 2 == 0) {
                writeFacts.innerHTML += "<br>" + search.number + " " + search.text + " " + search.timeStamp;

            }
        }

    }
}