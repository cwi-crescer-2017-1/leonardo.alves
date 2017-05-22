var crudApp = angular.module("crudApp", ["ngRoute"]);
crudApp.controller("main", mainController);

crudApp.config(function ($routeProvider){
    $routeProvider
        .when("/aulas", {
            controller: "aulaController",
            templateUrl: "aulas.html"
        })
        .when("/instrutores", {
            controller: "instrutorController",
            templateUrl: "instrutores.html"
        })
        .otherwise({redirectTo: "/aulas"});
});

function mainController ($scope){
     $scope.instrutores = [{
        id: 0, // Gerado
        nome: 'Nome', // Obrigatório (length = min 3, max 20)
        sobrenome: 'Sobrenome', // Opcional (length = max 30)
        idade: 25, // Obrigatório (max 90)
        email: 'email@cwi.com.br', // Obrigatório (type=email)
        dandoAula: "Sim", // true ou false
        aula: [0, 4], // Opcional (array)
        urlFoto: 'https://bs.simplusmedia.com/i/730/838/banana-beneficios.jpg'
    }]

     $scope.aulas = [{
        id: 0,
        nome: "Orientação à Objetos"
    }];
}

