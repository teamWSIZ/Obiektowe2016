var app = angular.module("dyzury", []);
var url = "http://localhost:8081/";

app.controller("users", function($scope, $http) {
    $scope.infoVisible = 'hidden';
    $scope.info = '';

    function getUsers(){
        $http.get(url+"users").then(function(response){
            $scope.users = response.data;
        });
    }
    getUsers();

    $scope.deleteUser = function (userid) {
        if(confirm('Czy na pewno chcesz usunąć tego użytkownika?')){
            $http.delete(url+"users/"+userid).then(function(response){
                $scope.infoVisible = '';
                $scope.info = 'Użytkownik został usunięty.';
                getUsers();
            });
        }
    }

    $scope.addUser = function () {
        $http.post(url+"users/add", {
            name: $scope.addUserName
        }).then(function(response){
            $scope.addUserName = '';
            $('#addUserModal').modal('hide');
            $scope.infoVisible = '';
            $scope.info = 'Użytkownik został dodany.';
            getUsers();
        });
    }

    $scope.editUserModal = function (user){
        $scope.editUserNameTitle = user.name;
        $scope.editUserName = user.name;
        $scope.editUserUserid = user.userid;
    }

    $scope.editUser = function () {
        $http.put(url+"users/"+$scope.editUserUserid, {
            name: $scope.editUserName
        }).then(function(response){
            $scope.editUserName = '';
            $scope.editUserUserid = '';
            $('#editUserModal').modal('hide');
            $scope.infoVisible = '';
            $scope.info = 'Użytkownik został edytowany.';
            getUsers();
        });
    }

});