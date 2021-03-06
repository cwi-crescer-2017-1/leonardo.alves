var app = angular.module("instrutorForm", []);

app.controller("controller", function ($scope) {
    
    let instrutores = [
        {
        nome: "Bernardo",
        sobrenome: "Rezende",
        idade: 30,
        email: "bernardo@cwi.com.br",
        jaDeuAula: true,
        aula: "OO"
        }
    ];

    let aulas = [
        "OO",
        "HTML e CSS",
        "Javascript",
        "AngularJS",
        "Banco de Dados I"
    ];
    $scope.instrutores = instrutores;
    $scope.aulas = aulas;   
    
    $scope.inserirInstrutor = function inserirInstrutor () {
        if($scope.instrutor.$invalid) return;             

        instrutores.push(angular.copy($scope.novoInstrutor));
        $scope.novoInstrutor = {};
    }
    
});