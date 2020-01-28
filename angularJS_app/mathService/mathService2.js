angular.module('math.app', [])
    .service('MathService', ['$log', '$rootScope', function ($log, $rootScope) {
        $log.info("Using Service (inside)");
        $rootScope.companyName = "Swabhav";
        this.cube = function (number) {
            return number * number * number;
        }

        this.square = function (num) {
            return num * num;
        }

    }]);

angular.module('math.app')
    .controller('ControllerA', ['$scope', 'MathService', function ($scope, MathService) {
        $scope.result = MathService.square(5);
    }])

    .controller('ControllerB', ['$scope', 'MathService', function ($scope, MathService) {
        $scope.result = MathService.cube(5);
    }])
