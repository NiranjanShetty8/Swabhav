
angular.module('StudentAPI', [])
    .service('studentService', ['$log', '$q', '$http', function ($log, $q, $http) {
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
    }])
    .controller('StudentController', ['$scope', 'studentService', function ($scope, studentService) {
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
        $scope.student = {};
        $scope.loading = false;

        $scope.addStudent = function () {
            new Date
            var date = new Date($scope.student.date);
            mnth = ("0" + (date.getMonth() + 1)).slice(-2),
                day = ("0" + date.getDate()).slice(-2);
            $scope.student.date = [day, mnth, date.getFullYear()].join("/");

            $scope.loading = true;
            studentService.add($scope.student)
                .then(function (response) {
                    $scope.loading = false;
                    $scope.student.id = response;
                    $scope.addedMessage = "Student added successfully with id: " + response;

                    $scope.callGet();
                })
                .catch(function (err) {
                    $scope.error = "There was a problem in adding the student. Check if you have specified all details";
                    $scope.loading = false;
                })
        }
    }]);

