var checkbox = document.querySelector("input[id=check]");
var checkbox = document.getElementById("check");
console.log(checkbox);
var spinner = document.getElementById("spinner")

checkbox.addEventListener('change', function () {
    if (this.checked) {
        spinner.innerHTML = " <br><br><br><img src='25.gif' alt='805.gif'>";
    } else {
        spinner.innerHTML = "";
    }
})