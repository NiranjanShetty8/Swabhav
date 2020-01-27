angular.module("moduleA", [])
    .controller('controllerA', ['$scope', '$timeout', function ($scope, $timeout) {
        $timeout(function () {
            $scope.load();
        }, 3000);
        $scope.load = function () {
            $scope.student = { id: "101", name: "Prakash", cgpa: "7.8", img: "student.jpeg" };
        };

        $scope.loadMany = function () {
            $scope.studentList = [{ id: "101", name: "Prakash", cgpa: "7.8", img: "student.jpeg" },
            { id: "102", name: "Vijay", cgpa: "8.1", img: "student.jpeg" },
            { id: "103", name: "Kamal", cgpa: "8.8", img: "student.jpeg" }];

        }
    }])