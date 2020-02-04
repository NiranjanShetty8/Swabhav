
angular.module('StudentSPA', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl: "home.html",
                controller: "StudentController"
            })
            .when("/home", {
                templateUrl: "home.html",
                controller: "StudentController"
            })
            .when("/add", {
                templateUrl: "add.html",
                controller: "AddingStudentController"
            })
            .when("/edit/:id", {
                templateUrl: "edit.html",
                controller: "ModifyStudentController"
            })
    }])
    .service('studentService', ['$log', '$q', '$http', '$window', '$routeParams', function ($log, $q, $http, $window, $routeParams) {
        this.redirectToHome = function () {
            $window.location.href = "/student_spa/index.html#!/home";
        }

        // this.redirectToEdit = function (studentId) {
        //     $window.location.href = "/student_spa/index.html#!/edit"
        //     return studentId;
        // }

        this.get = function () {
            return $q(function (resolve, reject) {
                $http({
                    method: 'GET',
                    url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students"
                }).then(function success(response) {
                    resolve(response.data);
                }).catch(function error(err) {
                    reject(err);
                })
            })
        }

        this.add = function (student) {
            return $q(function (resolve, reject) {
                $http({
                    method: 'POST',
                    url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students",
                    data: student
                }).then(function success(response) {
                    resolve(response.data);
                }).catch(function error(err) {
                    reject(err);
                })
            })
        }

        this.edit = function (student) {
            return $q(function (resolve, reject) {
                $http({
                    method: "PUT",
                    url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/" + student.id,
                    data: student
                }).then(function success(response) {
                    resolve(response);
                }).catch(function error(err) {
                    reject(err);
                })
            })
        }
        this.getStudentByID = function () {
            return $q(function (resolve, reject) {
                $http({
                    method: 'GET',
                    url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/" + $routeParams.id,
                    params: { id: $routeParams.id }
                    // data: student
                }).then(function success(response) {
                    console.log(response.data);
                    resolve(response.data);
                }).catch(function error(err) {
                    reject(err);
                })
            })
        }

    }])
    .controller('StudentController', ['$scope', 'studentService', '$q', '$http',
        function ($scope, studentService, $q, $http) {

            $scope.student = {};
            $scope.callGet = function () {
                studentService.get()
                    .then(function (response) {
                        $scope.allStudents = response;
                        $scope.count = "Total Number of Students are: " + $scope.allStudents.length;

                    }).catch(function (err) {
                        $scope.error = "*There was a problem in retrieving students. Please check Internet Connection";
                    })
            }
            $scope.callGet();
            $scope.deleteStudent = function (student) {
                if (confirm("Are you Sure?")) {
                    return $q(function (resolve, reject) {
                        $http({
                            method: 'DELETE',
                            url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/" + student.id,
                        }).then(function success(response) {
                            resolve(response);
                            $scope.callGet();
                        }).catch(function error(err) {
                            reject(err);
                        })
                    })

                }
            }
        }])

    .controller('AddingStudentController', ['$scope', 'studentService', '$route', "$window",
        function ($scope, studentService, $route, $window) {
            $scope.loading = false;

            $scope.redirect = studentService.redirectToHome;

            $scope.addStudent = function () {
                var date = new Date($scope.newDate),
                    month = ("0" + (date.getMonth() + 1)).slice(-2),
                    day = ("0" + date.getDate()).slice(-2);
                $scope.student.date = [day, month, date.getFullYear()].join("/");

                $scope.loading = true;
                studentService.add($scope.student)
                    .then(function (response) {
                        $scope.loading = false;
                        $scope.student.id = response;
                        $scope.addedMessage = "Student added successfully with id: " + response;
                        $scope.redirect();

                    })
                    .catch(function (err) {
                        $scope.error = "There was a problem in adding the student. Check if you have specified all details";
                        $scope.loading = false;
                    })
            }
        }])

    .controller('ModifyStudentController', ['$scope', 'studentService',
        function ($scope, studentService) {
            $scope.loading = false;
            $scope.redirect = studentService.redirectToHome;

            $scope.editStudent = function () {
                var date = new Date($scope.newDate),
                    month = ("0" + (date.getMonth() + 1)).slice(-2),
                    day = ("0" + date.getDate()).slice(-2);
                $scope.student.date = [day, month, date.getFullYear()].join("/");
                studentService.edit($scope.student)
                    .then(function (response) {
                        $scope.loading = false;
                        $scope.student.id = response;
                        $scope.addedMessage = "Student added successfully with id: " + response;
                        $scope.redirect();

                    })
                    .catch(function (err) {
                        $scope.error = "There was a problem in adding the student. Check if you have specified all details";
                        $scope.loading = false;
                    })
            }
            $scope.loading = true;
            $scope.getStudentDetails = function () {
                studentService.getStudentByID()
                    .then(function (response) {
                        $scope.loading = false;
                        $scope.student = response[0];
                        console.log("date", $scope.student.date, "male", $scope.student.isMale)

                    })
                    .catch(function (err) {
                        $scope.error = "There was a problem in editing the student. Check if you have specified all details";
                        $scope.loading = false;
                    })
            }
            $scope.getStudentDetails();
            // studentService.edit()

        }])
    // .controller('DeleteController', ['$scope', 'studentService', '$routeParams',
    //     function ($scope, studentService, $routeParams) {

    //     }])

