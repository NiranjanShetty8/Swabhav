
var studentService = (function () {
    const tableHtml = $('#display').html();
    var service = {};
    var students = [];
    $('document').ready(function () {
        $("[name ='add']").hide();
        $('#operationResult').html("");

        $('#toggleForm').on('click', function () {
            $("[name ='add']").toggle();
            $('#operationResult').html("");
            // $('#addButton').html("&#26D7");
            // if ($("[name ='add']").is(":visible")) {
            //     $('#addButton').html("&#26D7");
            // }

        })
        service.getStudents();

    })

    service.addStudent = function () {
        var rollNo = $("[name='rollNo']").val();
        var name = $("[name = 'name']").val();
        var age = $("[name = 'age']").val();
        var email = $("[name = 'email']").val();
        var date = $("[name = 'date']").val();
        var isMale = $("input[name = 'isMale']:checked").val();
        console.log(isMale);
        var student = { rollNo: rollNo, name: name, age: age, email: email, date: date, isMale: isMale }

        console.log(student);
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

    service.removeStudent = function (id) {
        $.ajax({
            type: "DELETE",
            url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/" + id,
            success: function () {
                console.log("deleted");
                service.getStudents();
            }
        })

    }


    service.updateStudent = function (id) {
        $.ajax({
            type: "PUT",
            url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/" + id,
        })

    }

    service.getStudents = function () {
        $('#display').html(tableHtml);

        $.ajax({
            type: "GET",
            url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/",
            success: function (data) {
                $('#count').html("Total number of students are: " + data.length)
                for (var student of data) {
                    var rollNo = student.rollNo;
                    var name = student.name;
                    var age = student.age;
                    var email = student.email;
                    var date = student.date;
                    var isMale = student.isMale;
                    var id = student.id;
                    var stringOfData = "<tr> <td>" + rollNo + "</td> <td> " + name + "</td> <td> " + age + "</td> <td> "
                        + email + "</td> <td>  " + date + "</td> <td>  " + isMale + "</td> <td> " + id + "</td> </tr> "
                    $('#displayTable').append(stringOfData + '<br><br>')
                }
            }
        })
    }
    // service.removeStudent("7dd1fcca-7dea-4179-a05c-e7629ce53eed");
    return service;
})();