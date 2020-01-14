(function () {
    "use strict";
    var allQuestions = [];
    var correctAnswerArray = [];
    var givenAnswers;
    var options;
    var givenAnswersArray = [];
    var counter = 0;
    var correctPercentage = 0;
    var questionNo = document.getElementById("questionNo");
    var questionDetails = document.getElementById("questionDetails");
    var button = document.getElementById("button");
    var percentageIncrement;
    button.addEventListener("click", (e) => {
        showNextQuestion();

    });
    var prevButton = document.getElementById("previousButton");
    prevButton.addEventListener("click", showPreviousQuestion);
    prevButton.style.display = "none";
    var finishButton = document.getElementById("finishButton");
    finishButton.style.display = "none";
    finishButton.addEventListener("click", function () {
        finalResult();

    });


    addQuestions();
    getQuestiions();
    getCorrectAnswers();
    showNextQuestion();
    percentageIncrement = 1 / allQuestions.length * 100;

    document.querySelector('body').addEventListener('click', function (event) {
        if (event.target.tagName.toLowerCase() === 'input') {
            givenAnswers = event.target.value;
            givenAnswersArray[counter - 1] = givenAnswers;
        }
    });

    function getQuestiions() {
        var stringAllQuestions = localStorage.getItem("allQuestions");
        allQuestions = JSON.parse(stringAllQuestions);
        givenAnswersArray.length = allQuestions.length;
        return allQuestions;
    }

    function addQuestions() {
        var question1 = { id: 1, body: "What is 144 * 9?", options: ["1286", "1276", "1296", "1306"], correctAnswer: "2" };
        var question2 = {
            id: 2, body: "Which is my color?", options: ["Black", "Brown", "Red", "Sky-Blue"],
            correctAnswer: "0"
        };
        var question3 = { id: 3, body: "Who is Jay's fav cricketer?<br>(hint: not yours,Jay's)", options: ["V. Kohli", "M.S. Dhoni", "J. Bumrah", "N. Shetty ;)"], correctAnswer: "1" };
        var question4 = {
            id: 4, body: "Which is the correct choice?", options: ["Mixer", "Juicer", "Grinder", "Oven"],
            correctAnswer: "1"
        };
        var question5 = { id: 5, body: "Guess your soon-to-be favourite Vegetable.", options: ["Onion", "Ginger", "Garlic", "BeetRoot"], correctAnswer: "2" };
        allQuestions.push(question1, question2, question3, question4, question5);
        console.log(question4.options.b == question4.correctAnswer);
        var stringAllQuestions = JSON.stringify(allQuestions);
        localStorage.setItem("allQuestions", stringAllQuestions);
    };

    function getCorrectAnswers() {
        for (var itr = 0; itr < allQuestions.length; itr++) {
            var ans = allQuestions[itr].correctAnswer;
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
            finishButton.style.display = "inline";
        }
        questionDetails.innerHTML = allQuestions[counter].id + ") " + allQuestions[counter].body + "<br>";
        createOptions();
        counter++;
        console.log("array " + givenAnswersArray);

    }

    function checkAnswers() {
        for (var iterate = 0; iterate < allQuestions.length; iterate++) {
            if (givenAnswersArray[iterate] == correctAnswerArray[iterate]) {
                correctPercentage = correctPercentage + percentageIncrement;
            }
        }
    }

    function showPreviousQuestion() {
        finishButton.style.display = "none";

        if (counter == 2) {
            prevButton.style.display = "none";
        }
        counter = counter - 2;
        showNextQuestion();

    }

    function finalResult() {
        checkAnswers();
        document.querySelector('body').innerHTML = "<style>*{background-color: black;}</style>\
        <h1 id ='congo'> <strong>I REALLY WANNA BE WITH YOU!!!! </strong></h1>\
        <body><img src = 'results.jpeg'><div class = 'bg2'><div id= 'finalResult'>\
        <strong>Your Tatti Result is : "+ correctPercentage + "% </strong></div>\
        <div id='progressBar'><progress id = 'progress' value = "+ correctPercentage + " min = 0, max = 100></div></div></body>";

    }

    function createOptions() {
        var optionText = allQuestions[counter].options;
        var ans = -1;
        if (givenAnswersArray[counter]) {
            ans = parseInt(givenAnswersArray[counter])
        }
        for (var index = 0; index < optionText.length; index++) {
            options = document.createElement("input");
            options.className = "optionClass";
            options.name = "button";
            options.type = "radio";
            options.id = index;
            options.value = index;
            questionDetails.append(options);
            questionDetails.append(optionText[index]);
            questionDetails.innerHTML += "&nbsp &nbsp &nbsp"
        }
        if (ans != -1)
            document.forms['form']['button'].value = ans;
    }
})();