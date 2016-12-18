
angular.module('myApp.controllers',[]);


//Kontroler użyty na panelu userów (panel zarządzania danymi)
angular.module('myApp.controllers').controller('masterCtrl',
    ['$rootScope','$scope', '$http',
        function ($rootScope, $scope, $http) {
            //To jest uruchamiane przy każdym wejściu do widoku korzystającego z tego kontrolera
            console.log('Uruchamiam masterCtrl; M:' + $scope.M);

            //Lokalny obiekt modelu, tworzony przy każdym uruchomieniu kontrolera
            $scope.M = {};
            $scope.M.newUser = {userid: '-1', username: 'nowy user'};
            $scope.usersList = [];

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
                }).success(function (data) {
                    $scope.usersList = data;
                });
            };

            //Dodaje usera do systemu; przykład metody POST z jsonem w body
            $scope.addUser = function () {
                //addUser(M.newuser)
                var userToSave = $scope.M.newUser;

                return $http({
                    url: $rootScope.M.rootUrl + '/users',
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    data: JSON.stringify(userToSave)
                }).success(function (data) {
                    console.log("OK");
                });

                //Przykład wysyłania obiektów w polu `params`
                // return $http({
                //     url: $rootScope.M.rootUrl + '/users',
                //     method: 'POST',
                //     params: userToSave
                // }).success(function(data){
                //     console.log("OK");
                // });
            };
        }
    ]
);
