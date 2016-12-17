
angular.module('myApp.controllers',[]);


angular.module('myApp.controllers').controller('masterCtrl',
    ['$rootScope','$scope', '$http',
        function ($rootScope, $scope, $http) {
            console.log('Uruchamiam masterCtrl');

            $scope.napis = 'Abra kadabra';
            
            $scope.tabRezerwacji = [
                {id:1, nazwa:'Alpha'},
                {id:2, nazwa:'Beta'},
                {id:3, nazwa:'Gamma'}
            ];

            $scope.nowa = {id: '', nazwa: ''};

            $scope.dodajRezerwacje = function (nnn) {
                $scope.tabRezerwacji.push(nnn);
                $scope.nowa = {id: '', nazwa: ''};
                $scope.MMM.showNewBooking = false;
            };


        //    Tu piszemy funkcje dostępne w view:
            $scope.loadIt = function() {
                var toSave = {
                    token: 'abcd',
                    obronaId: 1234
                };

                return $http({
                    url: rootUrl + 'obrony/setWynik',
                    method: 'POST',
                    params: toSave
                }).success(function(data){
                    //tu mamy dostęp do scope
                    // $scope.tabRezerwacji = data.result;
                });
            }

        }
    ]
);
