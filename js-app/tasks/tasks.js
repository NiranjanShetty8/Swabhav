(function () {
    use = "strict";
    var button = document.getElementById("addButton");
    button.addEventListener("click", newTask);
    var ul = document.getElementById("incompleteList");
    var ulComplete = document.getElementById("completeList");
    var item = document.getElementById("taskText").value;
    var taskList = [];


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
        if (!done) {
            done = false;
        }
        var task = { id: creation, task: text, timeStamp: creation, done: done };
        taskList.push(task);
        var li = document.createElement("li");
        var checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        li.appendChild(checkbox);
        li.appendChild(document.createTextNode(text));
        li.appendChild(document.createTextNode("--- Created on " + creation));
        setToLocal();

        if (task.done) {
            ulComplete.appendChild(li);
        } else {
            ul.appendChild(li);
        }
        ul.append(li);
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

    function loadToList(text, time, done) {
        var task = { id: time, task: text, timeStamp: time, done: done };
        taskList.push(task);
        console.log(task.task + " is " + task.done);
        var li = document.createElement("li");
        var checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        if (task.done == true) {
            console.log("ehhh");
            checkbox.checked = true;
        }
        li.appendChild(checkbox);
        li.appendChild(document.createTextNode(text));
        li.appendChild(document.createTextNode("--- Created on " + time));


        if (task.done) {
            console.log("inside");
            console.log(li);
            console.log(ulComplete);
            ulComplete.appendChild(li);
        } else {
            console.log("here");
            ul.appendChild(li);
        }

        checkbox.addEventListener("change", function (e) {

            if (e.target.checked) {
                task.done = true;
                li.style.textDecoration = 'line-through';
                doneTask(li);
                ulComplete.appendChild(li);
                setToLocal();


            } else {
                task.done = false;

                li.style.textDecoration = 'none';
                unDoneTask(li);
                setToLocal();
            }

        });

    }

    (function () {

        var test = localStorage.getItem("taskList");
        var loadedTask = JSON.parse(test);
        for (var tasks of loadedTask) {
            var loadText = tasks.task;
            var loadTime = tasks.timeStamp;
            var loadFlag = tasks.done;
            loadToList(loadText, loadTime, loadFlag);
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
// }        // for (var iter = 0; iter < indexC; iter++) {
        //     var loadCompTask = localStorage.getItem("tasksC" + iter + "");
        //     // console.log(loadCompTask);
        //     var loadCompTime = localStorage.getItem("timeC" + iter);
        //     var checkbox = document.createElement("input");
        //     checkbox.type = "checkbox";
        //     checkbox.select;
// }