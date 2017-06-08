angular.module('locadoraCrescer').factory("pedidoService", pedidoService);

function pedidoService($http) {
    let url = "http://localhost:64748/api/pedidos/";

    var service = {
        getPedidoPendente: getPedidoPendente,
        getRelatorio: getRelatorio,
        getAtrasos: getAtrasos,
        criarPedido: criarPedido,
        devolverPedido: devolverPedido
    }

    function getPedidoPendente(cpf) {
        return $http.get(url + "pendente", cpf);
    }

    function getRelatorio(data) {
        return $http.get(url + "relatorio", data);
    }

    function getAtrasos() {
        return $http.get(url + "atrasos");
    }

    function criarPedido(pedido) {
        return $http.post(url, pedido);
    }

    function devolverPedido(id) {
        return $http.put(url + "devolver", id);
    }

    return service;
}