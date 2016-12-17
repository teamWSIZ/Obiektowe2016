
angular.module('myApp.controllers',[]);


angular.module('myApp.controllers').controller('masterCtrl',
    ['$rootScope','$scope', '$http',
        function ($rootScope, $scope, $http) {
            console.log('Uruchamiam masterCtrl');

            $scope.napis = 'Lorem ipsum dolor sit';
            $scope.firstLoad = true;
            $scope.usersList = [];
            $scope.M = {};
            $scope.M.newUser = {userid:'', username:'nowy user'};

            if ($scope.firstLoad) {
                $scope.tabRezerwacji = [
                    {id:1, nazwa:'Alpha'},
                    {id:2, nazwa:'Beta'},
                    {id:3, nazwa:'Gamma'}
                ];
            } else {
                $scope.tabRezerwacji = [
                    {id:1, nazwa:'Alpha'}
                ];
            }

            $scope.nowa = {id: '', nazwa: ''};

            $scope.dodajRezerwacje = function (nnn) {
                $scope.tabRezerwacji.push(nnn);
                $scope.nowa = {id: '', nazwa: ''};
                $scope.MMM.showNewBooking = false;
            };

            //Wczytuje userów systemu z bazy przez kontroler serwera
            $scope.loadUsers = function () {
                return $http({
                    url: $rootScope.M.rootUrl + '/users',
                    method: 'GET'
                }).success(function(data){
                    $scope.usersList = data;
                });      
            };

            $scope.addUser = function () {
                //addUser(M.newuser)
                var userToSave = $scope.M.newUser;
                return $http({
                    url: $rootScope.M.rootUrl + '/users',
                    method: 'POST',
                    params: userToSave
                }).success(function(data){
                });
            };


        //    Tu piszemy funkcje dostępne w view:
            $scope.loadIt = function() {
                var toSave = {
                    token: 'abcd',
                    obronaId: 1234
                };

                return $http({
                    url: rootUrl + '/users',
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
