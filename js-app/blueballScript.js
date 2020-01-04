var button = document.getElementById("startButton");
var firstPage = document.getElementById("firstPage");
var secondPage = document.getElementById("secondPage");
var randomNo = Math.floor(Math.random() * 50) + 1;
var attempts;
console.log(randomNo);

button.addEventListener("click", startGame)

function hidePage() {
    firstPage.style.display = "none";
}

function restartGame() {
    var endGame = document.getElementById("endGame");
    endGame.style.display = "none";
    startGame();
}

function startGame() {
    attempts = 7;
    hidePage();
    secondPage.innerHTML = "<head><title>BlueBall Game</title></head><h1 id='guessHeader'>Make your guess </h1> <br> \
    <div id='attemptId'>Attempts Remaining: "+ attempts + "</div>";
    for (noOfButtons = 1; noOfButtons <= 50; noOfButtons++) {
        var tempString = "playingGame('" + noOfButtons + "')"
        secondPage.innerHTML += "<button class = 'button' id ='" + noOfButtons +
            "' type = 'button' onclick = " + tempString + " >" + noOfButtons + "</button>";
    }
    console.log(secondPage);
}

function playingGame(event) {
    document.getElementById(event).disabled = true;
    attempts = attempts - 1;
    var showAttempts = document.getElementById("attemptId");
    showAttempts.innerHTML = "";
    showAttempts.innerHTML = "Attempts Remaining: " + attempts;
    if (attempts >= 0) {

        if (event == randomNo) {
            var result = true;
            document.getElementById(event).style.backgroundColor = "blue";
            setTimeout(function () { endGame(result) }, 500);
        } else if (event < randomNo) {
            document.getElementById(event).style.backgroundColor = "green";
        } else {
            document.getElementById(event).style.backgroundColor = "red";
        }
    } else {
        result = false;
        endGame(result);
    }
    if (attempts == 0) {
        setTimeout(function () { endGame(false) }, 500);
    }
}

function endGame(result) {
    var endGame = document.getElementById("endGame");
    endGame.style.display = "block";
    for (var noOfButton = 1; noOfButton <= 50; noOfButton++) {
        document.getElementById(noOfButton).disabled = true;
    }

    if (result) {

        endGame.innerHTML = "<h1 id='resultId' class = 'resultClass'>Congratulations you won.</h1>"
    } else {
        endGame.innerHTML = "<span id='resultId' class = 'resultClass'>Sorry,<br> all your attempts are over.<br>Try again</span>"
    }
    secondPage.innerHTML = '<style> *{background-color: black;}</style>';
    secondPage.innerHTML += "<Button onclick ='restartGame()' id='restartButton' type = 'button'>Start over</button>"
}