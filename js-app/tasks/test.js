(function () {
    var button = document.getElementById("addButton");
    button.addEventListener("click", newTask);
    var ul = document.getElementById("incompleteList");
    var ulComplete;
    var index = 0;
    var indexC = 0;
    var item = document.getElementById("taskText").value;


    function newTask() {
        item = document.getElementById("taskText").value;
        var noText = document.getElementById("noText");
        if (item === "") {

            noText.innerHTML = "*Enter some Task"
            return;
        }
        noText.innerHTML = "";


        addToList();
    }

    function addToList(text, time) {
        if (!text) {
            text = item;
        }
        var creation;
        if (!time) {
            creation = new Date();
        } else {
            creation = time;
        }
        var li = document.createElement("li");
        var checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        li.appendChild(checkbox);
        li.appendChild(document.createTextNode(text));
        localStorage.setItem("tasks" + index, text);

        li.appendChild(document.createTextNode("--- Created on " + creation));
        var time = JSON.stringify(creation);
        localStorage.setItem("time" + index, time);
        index++;
        localStorage.setItem("ind", index);
        checkbox.addEventListener("change", function (e) {
            if (e.target.checked) {
                li.style.textDecoration = 'line-through';
                localStorage.setItem("tasksC" + indexC, text);
                localStorage.setItem("timeC" + indexC, creation);
                indexC++;
                doneTask(li)
            } else {
                li.style.textDecoration = 'none';
                unDoneTask(li);
            }
        });
        ul.appendChild(li);
        document.getElementById("taskText").value = "";

    }
    function doneTask(li) {
        ulComplete = document.getElementById("completeList");
        ulComplete.appendChild(li);

    }

    function unDoneTask(li) {
        ul.appendChild(li);

    }


    (function () {
        var count = localStorage.getItem("ind");
        // console.log(count);
        for (var iter = 0; iter < count; iter++) {
            var loadedTask = localStorage.getItem("tasks" + iter + "");
            // console.log(loadedTask);
            var loadTime = localStorage.getItem("time" + iter + "");
            loadTime = JSON.parse(loadTime);
            // console.log(loadTime);
            addToList(loadedTask, loadTime);
        }
        for (var iter = 0; iter < indexC; iter++) {
            var loadCompTask = localStorage.getItem("tasksC" + iter + "");
            // console.log(loadCompTask);
            var loadCompTime = localStorage.getItem("timeC" + iter);
            var checkbox = document.createElement("input");
            checkbox.type = "checkbox";
            checkbox.select;







        }
    }());


})();

// function GetFormattedDate() {
//     var todayTime = new Date();
//     var month = todayTime.getMonth() + 1;
//     var day = todayTime.getDate();
//     var year = todayTime.getFullYear();
//     var time = todayTime.getTime();
//     return month + "/" + day + "/" + year + " at " + time;
// }