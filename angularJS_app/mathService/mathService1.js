angular.module('math.app', [])
    .factory('MathService', ['$log', '$rootScope', function ($log, $rootScope) {
        $log.info("Using Factory (inside)");
        $rootScope.companyName = "Swabhav";
        var service = {};
        service.cube = function (number) {
            return number * number * number;
        }

        service.square = function (num) {
            return num * num;
        }

        return service;
    }]);

angular.module('math.app')
    .controller('ControllerA', ['$scope', 'MathService', '$rootScope', function ($scope, MathService, $rootScope) {
        // $rootScope.companyName = "Niru";
        $scope.result = MathService.square(5);
    }])

    .controller('ControllerB', ['$scope', 'MathService', function ($scope, MathService) {
        $scope.result = MathService.cube(5);
    }])
