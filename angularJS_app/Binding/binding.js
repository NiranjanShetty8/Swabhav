angular.module("bindingDemo", [])
    .controller("mainController", ['$scope', '$timeout', function ($scope, $timeout) {
        $scope.student = { id: "101", firstName: "Niranjan", location: "mumbai" };

        $timeout(function () {
            $scope.student.firstName = 'Swabhav';
        }, 2000);

    }])