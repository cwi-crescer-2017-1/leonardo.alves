angular.module('locadoraCrescer').factory("pedidoService", pedidoService);

function pedidoService($http) {
    let url = "http://localhost:64748/api/pedidos/";

    var service = {
        getPedidoPendente: getPedidoPendente,
        getRelatorio: getRelatorio,
        getAtrasos: getAtrasos,
        criarPedido: criarPedido,
        devolverPedido: devolverPedido,
        gerarPedidoComValor: gerarPedidoComValor
    }

    function getPedidoPendente(cpf) {
        return $http({
            url: url + "pendente",
            method: 'GET',
            params: {cpf: cpf}
        });
    }

    function getRelatorio(data) {
        return $http({
            url: url + "relatorio",
            method: 'GET',
            params: {data: data.Data}
        });
    }   

    function getAtrasos() {
        return $http.get(url + "atrasos");
    }

    function criarPedido(pedido) {
        return $http.post(url, pedido);
    }

    function devolverPedido(id) {
        return $http({
            url: url + "devolver",
            method: 'PUT',
            params: {id: id}
        });        
    }

     function gerarPedidoComValor(pedido){
        let precoVeiculo = pedido.Veiculo.PrecoDiaria;
        let precoAdicionalAtraso = pedido.atraso ? pedido.Veiculo.AdicionalDiaria : 0;
        let precoPacote = pedido.Pacote.PrecoDiaria;        

        if(typeof precoPacote == "undefined") precoPacote = 0;

        let precoOpcionais = pedido.Opcionais.map(p => p.Opcional.Preco).reduce((a,b) => a+b);

        let diferencaDeDias = moment().diff(moment(pedido.DataPedido), "days");

        pedido.precoTotal = (diferencaDeDias || 1) * (precoVeiculo  + precoPacote + precoOpcionais + precoAdicionalAtraso);

        return pedido;
    }

    return service;
}