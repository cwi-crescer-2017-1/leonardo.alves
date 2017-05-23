var crudApp = angular.module("crudApp", ["ngRoute"]);

crudApp.config(function ($routeProvider){
    $routeProvider
        .when("/aulas", {
            controller: "aulaController",
            templateUrl: "aulas.html"
        })
        .when("/aulas/:idAula", {
            controller: "aulaController",
            templateUrl: "aulas.html"
        })
        .when("/instrutores", {
            controller: "instrutorController",
            templateUrl: "instrutores.html"
        })
        .when("/instrutores/:idInstrutor", {
            controller: "instrutorController",
            templateUrl: "instrutores.html"
        })
        .otherwise({redirectTo: "/aulas"});
});