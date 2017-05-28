
var app = angular.module("zapzapdos", ["ngRoute", "ngtimeago"]);

app.config(function ($routeProvider, $locationProvider){
    $routeProvider
        .when("/chat", {
            controller: "mensagemController",
            templateUrl: "../html/chat.html"
        })
        .when("/welcome", {
            controller: "usuarioController",
            templateUrl: "../html/welcome.html"
        })
        .otherwise({redirectTo: "/welcome"});
});