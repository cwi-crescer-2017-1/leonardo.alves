var app = angular.module('pokemon', []);

app.controller("controller", function ($scope) {
    // $scope.pokemons = [
    //     {nome: "Bulbassauro", tipo: "Grama"},
    //     {nome: "Charmander", tipo: "Fogo"},
    //     {nome: "Squirtle", tipo: "Água"}
    // ];
    $scope.pokemons = pokenames;
    
});
