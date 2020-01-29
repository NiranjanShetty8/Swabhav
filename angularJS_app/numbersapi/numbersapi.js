var allFacts = [];
// var loadData;
// load();

//$scope.data = NumbersApiService.getFact(2);

angular.module('numbersApi', [])
    .factory('NumbersApiService', ['$q', '$http', function ($q, $http) {
        var service = {};
        service.getFacts = function (number) {
            return $q(function (resolve, reject) {
                $http({
                    method: "GET",
                    url: "http://numbersapi.com/" + number
                }).then(function success(response) {
                    resolve(response.data)

                }, function error(reject) {
                    reject(reject.data)
                });
            })
        }
        return service;
    }]);

angular.module('numbersApi')
    .controller('controllerA', ['$scope', '$http', 'NumbersApiService', function ($scope, $http, NumbersApiService) {
        $scope.number;
        $scope.data = NumbersApiService.getFacts(2);
        $scope.data

        console.log($scope.data);


    }]);
function store() {
    console.log("this", allFacts)
    var storeData = JSON.stringify(allFacts);
    localStorage.setItem = ("facts", storeData);

}

function load() {
    loadData = JSON.parse(localStorage.getItem("facts"));
    console.log("in Load ", loadData);
}