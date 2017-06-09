angular.module('locadoraCrescer').controller("clienteController", clienteController);

function clienteController ($scope, clienteService) {
    $scope.cadastrar = cadastrar;

    function cadastrar (cliente) {
        clienteService.criarCliente(cliente)
            .then(response => {alert("Cadastrado com sucesso")}, fail => {alert(fail.data.mensagens)});

    }
}
    