
//List modules which it uses
var app = angular.module('myApp', [
    'ngRoute',
    'myApp.controllers'
]);

app.config(['$routeProvider', function ($routeProvider) {
    var urlBase='partials/';

    $routeProvider.when('/', {
        templateUrl: urlBase + 'otherView.html',
        controller: 'masterCtrl'
    }).when('/view1', {
        templateUrl: urlBase + 'otherView.html',
        controller: 'masterCtrl'
    }).when('/rezerwacje', {
        templateUrl: urlBase + 'rezerwacjeView.html',
        controller: 'masterCtrl'
    }).when('/users', {
        templateUrl: urlBase + 'usersView.html',
        controller: 'masterCtrl'
    }).when('/view2', {
        templateUrl: urlBase + 'serwisHttp.html',
        controller: 'internetowyCtrl'
    });
}]);

app.run(function ($rootScope) {
    console.log('Uruchamiam app.run');
    //Model object --- main data
    $rootScope.M = {};
    $rootScope.M.url = 'http://localhost:8090/forum-0.1.1/';
    $rootScope.M.rootUrl = 'http://localhost:8081';

    $rootScope.dyplomanci = [
        {nazwisko:'Xilan', imie:'Wu', studentid:1},
        {nazwisko:'Xi', imie:'Jinping', studentid:2},
        {nazwisko:'Hu', imie:'Jintao', studentid:3}
    ];
    $rootScope.M.selEgz = {};
    $rootScope.M.selEgz.student = $rootScope.dyplomanci[0];
});