var app = angular.module("aula02", []);

app.controller("controller", function ($scope) {
    let instrutores = [{
            nome: 'Pedro (PHP)',
            aula: [{
                numero: 3,
                nome: 'HTML e CSS'
            }]
        },
        {
            nome: 'Zanatta',
            aula: [{
                numero: 5,
                nome: 'AngularJS'
            }]
        },
        {
            nome: 'Bernardo',
            aula: [{
                    numero: 1,
                    nome: 'OO'
                },
                {
                    numero: 4,
                    nome: 'Javascript'
                }
            ]
        },
        {
            nome: 'Nunes',
            aula: [{
                numero: 2,
                nome: 'Banco de Dados I'
            }]
        }
    ];   
    let instToSort = []; //variavel auxiliar para exibição

    let newInst = instrutores.map(e => { //mapeia todos os os obj dentro de instrutores 
        let newObj = [];                 //para um obj contendo arrays que possuem numero, nome do instrutor
        e.aula.forEach(a =>              //e nome da aula
            newObj.push({
                numero: a.numero,
                nomeIns: e.nome,
                nome: a.nome
            }))
        return newObj
    });
    newInst.forEach(e => e.forEach(d => instToSort.push(d))); //ordena os instrutores com base no numero

    instToSort.sort(instSort);

    $scope.instToSort = instToSort;
    $scope.instrutores = instrutores;

});

var instSort = function (a, b) {
    if(a.numero > b.numero) return 1;
    if(a.numero < b.numero) return -1;
    return 0;
}

