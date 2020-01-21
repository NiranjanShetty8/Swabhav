var taskView = function () {

    var ul = $("#incompleteList");
    var ulComplete = $("#completeList");

    $('#addButton').on('click', () => {

        if (taskService.newTask() === false) {
            viewer.noTask();
        } else {
            viewer.showLists();
        }

    });

    var viewer = {};

    viewer.noTask = function () {
        var noText = $("#noText");
        noText.html("*Enter some Task");

    };

    viewer.showLists = function (task) {
        $("#noText").html("");
        if (!task) {
            task = taskService.addToList();
        }
        var li = document.createElement("li");
        var checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        if (task.done == true) {
            checkbox.checked = true;
        }
        li.appendChild(checkbox);
        li.appendChild(document.createTextNode(task.task));
        li.appendChild(document.createTextNode("--- Created on " + task.timeStamp));
        $('#taskText').val("");
        if (task.done) {
            li.style.textDecoration = 'line-through';
            ulComplete.append(li);
        } else {
            ul.append(li);
        }

        checkbox.addEventListener("change", function (e) {

            if (e.target.checked) {
                task.done = true;
                li.style.textDecoration = 'line-through';
                taskService.setToLocal();
                taskView.doneTask(li);
                ulComplete.appendChild(li);

            } else {
                task.done = false;
                taskService.setToLocal();
                li.style.textDecoration = 'none';
                taskView.unDoneTask(li);
            }
        });

    };

    viewer.doneTask = function (li) {
        ulComplete = document.getElementById("completeList");
        ulComplete.append(li);
    }

    viewer.unDoneTask = function (li) {
        ul.append(li);
    }

    window.addEventListener("keypress", checkPress, false);
    function checkPress(event) {
        {
            if (event.keyCode == "13") {

                if (taskService.newTask() === false) {
                    viewer.noTask();
                } else {
                    viewer.showLists();
                }
            }
        }
    }
    var loadedTaskArray = taskService.getFromLocal();
    if (loadedTaskArray != null) {
        for (var tasks of loadedTaskArray) {
            var loadText = tasks.task;
            var loadTime = tasks.timeStamp;
            var loadFlag = tasks.done;
            var loadedTask = taskService.addToList(loadText, loadTime, loadFlag);
            viewer.showLists(loadedTask);
        }
    }

    return viewer;
}();