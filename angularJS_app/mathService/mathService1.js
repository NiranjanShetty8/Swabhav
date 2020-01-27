angular.module('math.app', [])
    .factory('MathService', ['$log', '$rootScope', function ($log, $rootScope) {
        $log.info("Inside Service");
        $rootScope.companyName = "Swabhav";
        var service = {};
        service.cube = function (number) {
            return number * number * number;
        }

        service.square = function (num) {
            return num * num;
        }





        return service;
    }])