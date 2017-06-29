var app = angular.module("musicio", ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl: "home/home.html"
    })
    .when("/cadastro", {
        templateUrl: "usuario/cadastro.html"
    })
});
