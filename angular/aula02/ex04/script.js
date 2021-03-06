var app = angular.module("aula02", []);

app.filter("mascada", function () {
    return function (nome) {
        return nome.replace(/(nunes)/i, "$ $1 $");
    }
});

app.filter("formatar", function () {
    return function (arg, uppercase) {
        if (uppercase) {
            arg = arg.toUpperCase();
            return arg;
        }
        let numParaString = String(arg);
        let lpad = "000";
        //substring (lpad.length - n.length) => 3 - 1 = 2 => 00 concatenado com n => 002
        return lpad.substring(0, lpad.length - numParaString.length) + numParaString;
    }
});

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
        let newObj = []; //para um obj contendo arrays que possuem numero, nome do instrutor
        e.aula.forEach(a => //e nome da aula
            newObj.push({
                numero: a.numero,
                nomeIns: e.nome,
                nome: a.nome
            }))
        return newObj
    });
    newInst.forEach(e => e.forEach(d => instToSort.push(d))); 

    instToSort.sort(instSort); //ordena os instrutores com base no numero

    $scope.instToSort = instToSort;
    $scope.instrutores = instrutores;

});

var instSort = function (a, b) {
    if (a.numero > b.numero) return 1;
    if (a.numero < b.numero) return -1;
    return 0;
}
