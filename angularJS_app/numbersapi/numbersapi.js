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
                    console.log("in get Facts: ", response);
                    resolve(response.data)

                }).catch(function error(err) {
                    reject(err)
                });
            })
        }
        return service;
    }]);

angular.module('numbersApi')
    .controller('controllerA', ['$scope', '$http', 'NumbersApiService', function ($scope, $http, NumbersApiService) {
        $scope.error = "";
        // $scope.data = NumbersApiService.getFacts($scope.number);
        $scope.execute = function () {
            NumbersApiService.getFacts($scope.number)
                .then(function (num) {
                    $scope.data = num;
                    console.log($scope.data);
                }).catch(function (err) {
                    console.log(err);
                    $scope.error = err;
                })
        }

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