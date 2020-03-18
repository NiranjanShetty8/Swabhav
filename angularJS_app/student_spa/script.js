// var apiLink = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/";
var apiLink = "http://127.0.0.1:8080/api/techlabs/students/";
angular.module('StudentSPA', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            // .when("/", {
            //     templateUrl: "home.html",
            //     controller: "StudentController"
            // })
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
            .otherwise({
                templateUrl: "home.html",
                controller: "StudentController"

            })
    }])
    .service('studentService', ['$log', '$q', '$http', '$window', '$routeParams',
        function ($log, $q, $http, $window, $routeParams) {
            this.redirectToHome = function () {
                $window.location.href = "/student_spa/index.html#!/home";
            }
            this.get = function () {
                return $q(function (resolve, reject) {
                    $http({
                        method: 'GET',
                        url: apiLink
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
                        url: apiLink,
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
                        url: apiLink + student.id,
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
                        url: apiLink + $routeParams.id,
                    }).then(function success(response) {
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
                            url: apiLink + student.id,
                        }).then(function success(response) {
                            resolve(response);
                            $scope.deleted = "*Student with " + student.id + " has been deleted*"
                            $scope.callGet();
                        }).catch(function error(err) {
                            reject(err);
                        })
                    })

                }
            }
        }])
    .controller('AddingStudentController', ['$scope', '$timeout', 'studentService', '$route', "$window",
        function ($scope, $timeout, studentService, $route, $window) {
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
                        $scope.loading = false
                        $scope.student.id = response;
                        $scope.addedMessage = "Student added successfully with id: " + response;
                        // $timeout(function () { $scope.disableLoading(); }, 1000);
                        $timeout($scope.redirect, 2000);

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
                        $scope.newDate = new Date($scope.student.date)
                        $scope.student.date = $scope.newDate
                    })
                    .catch(function (err) {
                        $scope.error = "There was a problem in editing the student. Check if you have specified all details";
                        $scope.loading = false;
                    })
            }
            $scope.getStudentDetails();

        }]);

