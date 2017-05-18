var app = angular.module('pokemon', []);


app.controller("controller", function ($scope) {
    let dPoke = addPoke();
    // $scope.pokemons = [
    //     {nome: "Bulbassauro", tipo: "Grama"},
    //     {nome: "Charmander", tipo: "Fogo"},
    //     {nome: "Squirtle", tipo: "Água"}
    // ];
    $scope.pokemons = pokenames;
    $scope.objPokemons = dPoke;
});

var tipoAleatorio = function (obj) {
    var keys = Object.keys(obj)
    return obj[keys[keys.length * Math.random() << 0]];
};


function addPoke() {
    let pokemons = [];
    let tipos = ["fire", "grass", "water", "psychic", "ground", "normal",
        "fighting", "flying", "poison", "electric", "rock", "ice", "bug", 
        "dragon", "ghost", "dark", "steel", "fairy", "???"
    ];
    for (let i = 1; i <= 200; i++) {
        pokemons.push({
            nome: "Pokemon " + i,
            tipo: " Tipo: " + tipoAleatorio(tipos),
            id: i
        });
    }
    return pokemons;
}