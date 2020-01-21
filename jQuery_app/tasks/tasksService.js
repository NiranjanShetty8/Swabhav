
var taskService = (function () {

    var ul = document.getElementById("incompleteList");
    var ulComplete = document.getElementById("completeList");
    var taskList = [];
    var item;




    var service = {};

    service.newTask = function () {
        item = $('#taskText').val();
        console.log(item);

        if (item == "") {
            return false;
        }
    }

    service.addToList = function (text, time, done) {
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

        service.setToLocal();
        return task;
    }

    service.setToLocal = function () {
        var stringTaskList = JSON.stringify(taskList);
        localStorage.setItem("taskLists", stringTaskList);
    };

    service.getFromLocal = function () {

        var test = localStorage.getItem("taskLists");
        var loadedTask = JSON.parse(test);
        console.log(loadedTask);
        if (loadedTask != null) {
            return loadedTask;
        }
    };


    return service;

})();