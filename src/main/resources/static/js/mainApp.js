
//List modules which it uses
var app = angular.module('myApp', [
    'ngRoute',
    'myApp.controllers'
]);

app.config(['$routeProvider', function ($routeProvider) {
    var urlBase='partials/';

    $routeProvider.when('/', {
        templateUrl: urlBase + 'basicView.html',
        controller: 'masterCtrl'
    }).when('/view1', {
        templateUrl: urlBase + 'basicView.html',
        controller: 'masterCtrl'
    }).when('/view2', {
        templateUrl: urlBase + 'dataView.html',
        controller: 'masterCtrl'
    });
}]);

app.run(function ($rootScope) {
    console.log('Uruchamiam app.run');

    $rootScope.M = {};
    //Global properties
    $rootScope.M.URL = 'https://localhost:8443';

    // Globalnie-dostępna tablica i referencja do jednego z jej elementów (M.selStud)
    $rootScope.users = [
        {nazwisko:'Xilan', imie:'Wu', studentid:1},
        {nazwisko:'Xi', imie:'Jinping', studentid:2},
        {nazwisko:'Hu', imie:'Jintao', studentid:3}
    ];
    $rootScope.M.selStud = $rootScope.users[0];
});