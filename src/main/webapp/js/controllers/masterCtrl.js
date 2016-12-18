
angular.module('myApp.controllers',[]);


//Kontroler użyty na panelu userów (panel zarządzania danymi)
angular.module('myApp.controllers').controller('masterCtrl',
    ['$rootScope','$scope', '$http',
        function ($rootScope, $scope, $http) {
            //To jest uruchamiane przy każdym wejściu do widoku korzystającego z tego kontrolera
            console.log('Uruchamiam masterCtrl; M:' + $scope.M);

            //Lokalny obiekt modelu, tworzony przy każdym uruchomieniu kontrolera
            $scope.M = {};
            $scope.users = [];
            $scope.M.selUser = {userid:'', username: ''};
            $scope.M.uU = false;

            //Aliasy
            var url = $rootScope.M.rootUrl;


            $scope.addEmptyUser = function () {
                $scope.users.push({userid:'', username:'---'});
                $scope.M.selUser = $scope.users[$scope.users.length - 1];
            };

            //Wczytuje userów systemu z bazy przez kontroler serwera
            $scope.loadUsers = function () {
                return $http({
                    url: $rootScope.M.rootUrl + '/users',
                    method: 'GET'
                }).success(function (data) {
                    $scope.users = data;
                });
            };

            //Dodaje usera do systemu; przykład metody POST z jsonem w body
            $scope.upsertUser = function (user) {
                if (user.userid=='') insertUser(user);
                else updateUser(user);
            };

            $scope.deleteUser = function (u) {
                if (u.userid=='') return;
                return $http({
                    url: url + '/users/' + u.userid,
                    method: 'DELETE'
                }).success(function (data) {
                    $scope.loadUsers();
                });
            };

            $scope.saveAllUsers = function () {
                $scope.users.forEach(function (u) {
                    updateUser(u);
                });
            };


            ///////////////////////////////////////////

            var insertUser = function (u) {
                return $http({
                    url: url + '/users',
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    data: JSON.stringify(u)
                }).success(function (data) {
                    $scope.loadUsers();
                });
            };

            var updateUser = function (u) {
                return $http({
                    url: url + '/users/' + u.userid,
                    method: 'PUT',
                    headers: {'Content-Type': 'application/json'},
                    data: JSON.stringify(u)
                }).success(function (data) {
                    $scope.loadUsers();
                });
            };



            //Akcje do wykonania przy włączaniu widoku
            $scope.loadUsers();
        }
    ]
);
