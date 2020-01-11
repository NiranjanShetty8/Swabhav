"use strict";
var allQuestions = [];
var correctAnswerArray = [];
var givenAnswers;
var givenAnswersArray = [];
var call = 0;
var counter = 0;
var correctPercentage = 0;
var questionNo = document.getElementById("questionNo");
var questionDetails = document.getElementById("questionDetails");
var button = document.getElementById("button");
button.addEventListener("click", (e) => {
    givenAnswersArray.push(givenAnswers);
    showNextQuestion();

});
var prevButton = document.getElementById("previousButton");
prevButton.addEventListener("click", showPreviousQuestion);
prevButton.style.display = "none";
var finishButton = document.getElementById("finishButton");
finishButton.style.display = "none";
finishButton.addEventListener("click", function () {
    givenAnswersArray.push(givenAnswers);
    finalResult();

});
var percentageIncrement;

addQuestions();
getQuestiions();
getCorrectAnswers();
showNextQuestion();

percentageIncrement = 1 / allQuestions.length * 100;

document.querySelector('body').addEventListener('click', function (event) {
    if (event.target.tagName.toLowerCase() === 'input') {
        givenAnswers = event.target.id;
    }
});

function getQuestiions() {
    var stringAllQuestions = localStorage.getItem("allQuestions");
    allQuestions = JSON.parse(stringAllQuestions);
    return allQuestions;
}

function addQuestions() {
    var question1 = { id: 1, body: "What is 1 + 4?", options: ["20", "4", "5", "12"], correctAnswer: "2" };
    var question2 = { id: 2, body: "What is 10 + 4?", options: ["14", "3", "5", "12"], correctAnswer: "0" };
    var question3 = { id: 3, body: "What is 2+5?", options: ["14", "3", "5", "7"], correctAnswer: "3" };
    var question4 = { id: 4, body: "What is 10 + 14?", options: ["14", "24", "20", "12"], correctAnswer: "1" };
    var question5 = { id: 5, body: "What is 15 + 4?", options: ["14", "3", "19", "12"], correctAnswer: "2" };
    allQuestions.push(question1, question2, question3, question4, question5);
    console.log(question4.options.b == question4.correctAnswer);
    var stringAllQuestions = JSON.stringify(allQuestions);
    localStorage.setItem("allQuestions", stringAllQuestions);
};

function getCorrectAnswers() {
    for (var itr = 0; itr < allQuestions.length; itr++) {
        var ans = allQuestions[itr].correctAnswer;
        // correctAnswerArray.push(allQuestions[itr].options[ans]);
        correctAnswerArray.push(ans);
    }
    console.log(correctAnswerArray);
}


function showNextQuestion() {
    button.style.display = "inline";
    if (counter == 1) {
        prevButton.style.display = "inline";
    }
    if (counter < allQuestions.length) {
        questionNo.innerHTML = "Question : " + (counter + 1) + "/" + allQuestions.length;
    }
    if (counter >= allQuestions.length - 1) {
        button.style.display = "none";
        showFinalQuestion();
    } else {
        questionDetails.innerHTML = allQuestions[counter].id + ") " + allQuestions[counter].body + "<br>";
        createOptions();
        counter++;
    }
}

function checkAnswers() {
    for (var iterate = 0; iterate < allQuestions.length; iterate++) {
        if (givenAnswersArray[iterate] == correctAnswerArray[iterate]) {
            correctPercentage = correctPercentage + percentageIncrement;
        }
    }
}

function showPreviousQuestion() {
    givenAnswersArray.pop();
    if (counter == 5) {
        call = 0;
    }
    finishButton.style.display = "none";

    if (counter == 2) {
        prevButton.style.display = "none";
    }
    counter = counter - 2;
    showNextQuestion();

}

function finalResult() {
    checkAnswers();
    document.querySelector('body').innerHTML = "<h1> Congratulations, you completed the quiz!!!</h1>\
    <body><div id= 'finalResult'> <strong>Your Result is : "+ correctPercentage + "% </strong></div></body>";

}

function createOptions() {
    var optionText = allQuestions[counter].options;
    for (var index = 0; index < optionText.length; index++) {
        var options = document.createElement("input");
        if (index == 0) {
            options.defaultChecked = true;
            givenAnswers = 0;
        }
        options.name = "button";
        options.type = "radio";
        options.id = index;
        questionDetails.append(options);
        questionDetails.append(optionText[index]);
        questionDetails.innerHTML += "</br>"
    }
}

function showFinalQuestion() {

    call = call + 1;
    if (call == 1) {

        questionDetails.innerHTML = allQuestions[counter].id + ") " + allQuestions[counter].body + "<br>";
        createOptions();
        finishButton.style.display = "inline";
        counter++;
        call++;

    }

}