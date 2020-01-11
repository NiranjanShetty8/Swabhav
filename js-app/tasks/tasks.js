(function () {
    "use strict";
    var button = document.getElementById("addButton");
    button.addEventListener("click", newTask);
    var ul = document.getElementById("incompleteList");
    var ulComplete = document.getElementById("completeList");
    // var enterPress = document.getElement;
    var item = document.getElementById("taskText").value;
    var taskList = [];

    window.addEventListener("keypress", checkPress, false);
    function checkPress(event) {
        {
            if (event.keyCode == "13") {
                newTask();
            }
        }
    }


    function newTask() {

        item = document.getElementById("taskText").value;
        var noText = document.getElementById("noText");
        console.log(item);
        if (item == "") {
            noText.innerHTML = "*Enter some Task"
            document.getElementById("taskText").value = "";
            return;
        }
        noText.innerHTML = "";
        addToList();
    }

    function addToList(text, time, done) {
        if (!text) {
            text = item;
        }
        var creation;
        if (!time) {
            creation = new Date();
        } else {
            creation = time;
        }
        if (done == undefined) {
            done = false;
        }

        var task = { id: creation, task: text, timeStamp: creation, done: done };
        taskList.push(task);
        var li = document.createElement("li");
        var checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        if (task.done == true) {
            checkbox.checked = true;
        }
        li.appendChild(checkbox);
        li.appendChild(document.createTextNode(text));
        li.appendChild(document.createTextNode("--- Created on " + creation));


        if (task.done) {
            li.style.textDecoration = 'line-through';
            ulComplete.appendChild(li);
        } else {
            ul.appendChild(li);
        }
        setToLocal();

        document.getElementById("taskText").value = "";

        checkbox.addEventListener("change", function (e) {

            if (e.target.checked) {
                task.done = true;
                li.style.textDecoration = 'line-through';
                setToLocal();
                doneTask(li);
                ulComplete.appendChild(li);

            } else {
                task.done = false;
                setToLocal();
                li.style.textDecoration = 'none';
                unDoneTask(li);
            }
        });
    }

    function doneTask(li) {
        ulComplete = document.getElementById("completeList");
        ulComplete.appendChild(li);
    }

    function unDoneTask(li) {
        ul.appendChild(li);
    }

    function setToLocal() {
        var stringTaskList = JSON.stringify(taskList);
        localStorage.setItem("taskList", stringTaskList);
    }

    (function () {

        var test = localStorage.getItem("taskList");
        var loadedTask = JSON.parse(test);
        if (loadedTask != null) {
            for (var tasks of loadedTask) {
                var loadText = tasks.task;
                var loadTime = tasks.timeStamp;
                var loadFlag = tasks.done;
                addToList(loadText, loadTime, loadFlag);
            }
        }
    }());
})();