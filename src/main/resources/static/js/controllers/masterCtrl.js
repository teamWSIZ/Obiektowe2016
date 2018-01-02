
angular.module('myApp.controllers',[]);


//Kontroler użyty na panelu userów (panel zarządzania danymi)
angular.module('myApp.controllers').controller('masterCtrl',
    ['$rootScope','$scope', '$http',
        function ($rootScope, $scope, $http) {
            //To jest uruchamiane przy każdym wejściu do widoku korzystającego z tego kontrolera
            //Lokalny obiekt modelu, tworzony przy każdym uruchomieniu kontrolera
            $scope.M = {};
            $scope.M.appItems = [];
            $scope.newItem = {};
            $scope.fff = '';

            $scope.cleanItem = function () {
                $scope.newItem = {id: '0', title: '', body: ''};
                console.log('New item set')
            };

            $scope.sendNewItem = function() {
                return $http({
                    url: $rootScope.M.URL + '/items',
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    data: JSON.stringify($scope.newItem)
                    // ,
                    // params: any_object
                }).success(function(data){
                    alert('Send operation OK' + data);
                    $scope.loadArray();
                    $scope.cleanItem();
                    $scope.newItem = null;
                });
            };

            $scope.loadArray = function () {
                $http.get($rootScope.M.URL + '/items')
                    .success(function (data) {
                        $scope.M.appItems = data;
                        $scope.M.appItems.sort(function (a, b) {
                            return a.title.toLowerCase() > b.title.toLowerCase();
                        })
                    })
            };

            //functions executed on loading the view
            $scope.loadArray();
            $scope.cleanItem();

        }
    ]
);
