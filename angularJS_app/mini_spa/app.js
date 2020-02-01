angular.module("spa.app", ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            //#&! ignored in when
            .when("/", {
                templateUrl: "fragments/home.html",
                controller: "homeController"
            })
            .when("/home", {
                templateUrl: "fragments/home.html",
                controller: "homeController"
            })
            .when("/about", {
                templateUrl: "fragments/about.html",
                controller: "aboutController"
            })
            .when('/career', {
                templateUrl: "fragments/career.html",
                controller: "careerController"
            })

            .otherwise({
                templateUrl: "fragments/career.html",
                controller: "homeController"
            })
    }])

    .controller('homeController', ['$scope', function ($scope) {
        $scope.data = "Inside Home";
    }])

    .controller('aboutController', ['$scope', function ($scope) {
        $scope.data = "Inside About";
    }])

    .controller('careerController', ['$scope', function ($scope) {
        $scope.data = "Inside Career";
    }])

