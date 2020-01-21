
var studentService = (function () {
    const tableHtml = $('#display').html();
    var service = {};
    var students = [];
    $('document').ready(function () {
        $("[name ='add']").hide();


        $('#addButton').on('click', function () {
            $("[name ='add']").show();
            $('#addButton').hide();
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
                    console.log(student);
                }
            })
            console.log("hello")
            service.getStudents();
        }

        service.removeStudent = function (id) {
            var data = service.getStudents();
            for (var student of data) {
                $.ajax({
                    type: "DELETE",
                    url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/" + data.id,
                    success: function () {
                        console.log("deleted");
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
                console.log("in get");
                $('#display').html(tableHtml);
                $.ajax({
                    type: "GET",
                    url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/",
                    success: function (data) {
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
                        return data;
                    }
                })
            }


            service.removeStudent("16551028-419a-485c-a02c-e7e5addb70ba");
            service.getStudents();
        })


    return service;
})();