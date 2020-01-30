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
                    rreject(err);
                })
            })
        }

    }])
    .controller('StudentController', ['$scope', 'studentService', function ($scope, studentService) {
        studentService.get()
            .then(function (response) {
                $scope.allStudents = response;
            }).catch(function (err) {
                $scope.allStudents = err;
            })

    }])