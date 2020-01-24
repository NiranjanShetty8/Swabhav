
var studentService = (function () {
    const tableHtml = $('#display').html();

    var service = {};
    var students = [];
    var updateId;
    $('document').ready(function () {
        $('#addButton').css({ "display": "inline" });
        $('#updateButton').css({ "display": "none" });
        $("[name ='add']").hide();
        $('.message').html("");

        $('#toggleForm').on('click', function () {
            $("[name ='add']").toggle();
            $('.message').html("");

        })


        service.getStudents();
    })

    service.addStudent = function () {

        var student = service.getFormDetails();
        // debugger;
        $.ajax({
            type: "POST",
            url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/",
            data: student,

            success: function (id) {
                student.id = id;
                console.log($('#opeartionResult').html())
                $('#operationResult').html("Student added successfully with ID : " + id);
                $('#operationResult').css({ "color": "green" });
                service.getStudents();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $('#operationResult').html("* Could not add student. Try again." + errorThrown);
                $('#operationResult').css({ "color": "red" });
            }
        })
    }

    service.getFormDetails = function () {
        var rollNo = $("[name='rollNo']").val();
        var name = $("[name = 'name']").val();
        var age = $("[name = 'age']").val();
        var email = $("[name = 'email']").val();
        var date = $("[name = 'date']").val();
        var isMale = $("input[name = 'isMale']:checked").val();
        var studentObj = { rollNo: rollNo, name: name, age: age, email: email, date: date, isMale: isMale }
        return studentObj;
    }


    service.removeStudent = function (id) {
        var decision = confirm("Do you wish to delete the student?");
        if (decision === false) {
            return;
        }
        $.ajax({
            type: "DELETE",
            url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/" + id,
            success: function () {
                console.log("deleted");
                service.getStudents();
                $('#deleteOperationResult').html("*Student with ID: " + id + " was deleted");
                $('#deleteOperationResult').css({ "color": "red" });
            }
        })
    }


    service.updateStudent = function () {

        $('#updateButton').css({ "display": "none" });
        $('#addButton').css({ "display": "inline" });
        var student = service.getFormDetails();
        $.ajax({
            type: "PUT",
            url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/" + updateId,
            data: student,
            success: function () {
                console.log("updated");
                service.getStudents();
                $('#operationResult').html("Student updated successfully with ID : " + updateId);
                $('#operationResult').css({ "color": "green" });
            }
        })
    }

    service.getStudents = function () {
        $('#display').html(tableHtml);

        $.ajax({
            type: "GET",
            url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/",
            success: function (data) {
                $('#count').html("<strong>Total number of students are: " + data.length + "</strong>")
                for (var student of data) {
                    var stringStudent = JSON.stringify(student);
                    var rollNo = student.rollNo;
                    var name = student.name;
                    var age = student.age;
                    var email = student.email;
                    var date = student.date;
                    var isMale = student.isMale;
                    var id = JSON.stringify(student.id);
                    var stringOfData = "<tr id = " + stringStudent + " class='entriesClass'> <td>" + rollNo + "</td> <td> "
                        + name + "</td> <td> " + age + "</td> <td> " + email + "</td> <td>  " + date + "</td> <td>  "
                        + isMale + "</td> <td> " + student.id + "</td><td> \
                     <button type= 'button' onclick = 'studentService.removeStudent("+ id
                        + ");' class = 'deleteButton'>Delete</button> </td></tr>"
                    $('#displayTable').append(stringOfData + '<br>')
                }
                $('.entriesClass').on('click', function (e) {
                    var stringOfStudent = e.currentTarget.id;
                    var stud = JSON.parse(stringOfStudent);
                    $("[name='rollNo']").val(stud.rollNo);
                    $("[name = 'name']").val(stud.name);
                    $("[name = 'age']").val(stud.age);
                    $("[name = 'email']").val(stud.email);
                    $("[name = 'date']").val(stud.date);
                    $("#female").prop("checked", true);
                    if (stud.isMale) {
                        $("#male").prop("checked", true);
                    }
                    updateId = stud.id;
                    $('#updateButton').css({ "display": "inline" });
                    $('#addButton').css({ "display": "none" });
                    $("[name ='add']").show();


                })
            }
        })
    }
    return service;
})();