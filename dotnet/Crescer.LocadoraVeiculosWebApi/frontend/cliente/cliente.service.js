angular.module('locadoraCrescer').factory("clienteService", clienteService);

function clienteService($http) {
    let url = "http://localhost:64748/api/clientes/";
    
    var service = {
        getCliente: getCliente,
        criarCliente: criarCliente
    };

    function getCliente(cpf) {
        return $http.get(url, cpf)
    }

    function criarCliente(cliente) {
        return $http.post(url, cliente)
    }

    return service;
}