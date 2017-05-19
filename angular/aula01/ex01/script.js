var app = angular.module('pokemon', []);


app.controller("controller", function ($scope) {    
    var tipos =["fire", "grass", "water", "psychic", "ground", "normal",
        "fighting", "flying", "poison", "electric", "rock", "ice", "bug", 
        "dragon", "ghost", "dark", "steel", "fairy", "???"];
    let dPoke = addPoke(tipos);
    $scope.tipos =  tipos;    
    $scope.pokemons = pokenames;
    $scope.objPokemons = dPoke;    
});

function tipoAleatorio (obj) {
    var keys = Object.keys(obj)
    return obj[keys[keys.length * Math.random() << 0]];
};

function addPoke(tipos) {
    let pokemons = [];
    
    for (let i = 1; i <= 200; i++) {
        pokemons.push({
            nome: "Pokemon " + i,
            tipo: " Tipo: " + tipoAleatorio(tipos),
            id: i
        });
    }
    return pokemons;
}

