var slider = document.getElementById("myRange");
var output = document.getElementById("value");
var button = document.getElementById("buttonSpace");

output.innerHTML = slider.value;
slider.oninput = function () {
    button.innerHTML = "";
    currentValue = this.value
    output.innerHTML = this.value

    for (var number = 1; number <= currentValue; number++) {
        button.innerHTML += "<button type='button' id = " + number + ">" + number + "</button> ";
    }
}

button.addEventListener("click", function (e) {
    console.log(e.target.id);
});



