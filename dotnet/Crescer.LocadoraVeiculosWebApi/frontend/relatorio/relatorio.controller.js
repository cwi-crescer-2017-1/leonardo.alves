angular.module('locadoraCrescer').controller("relatorioController", relatorioController);

function relatorioController($scope, pedidoService, clienteService, opcionalService, pacoteService, authService) {
    $scope.getPedidosAtrasados = getPedidosAtrasados;
    $scope.getRelatorioMensal = getRelatorioMensal;      
    $scope.lucroMensal = "Informe uma data.";    
    $scope.auth = authService;
    
    function getRelatorioMensal(data) {
        let dataCopia = angular.copy(data);
        let date = moment(dataCopia.Data).format("YYYY-MM-DDTHH:mm:ss.SSS[Z]");

        dataCopia.Data = date;
        pedidoService.getRelatorio(dataCopia)
            .then(response => {
                $scope.pedidosMensais = [];
                response.data.dados.forEach(d => {                   
                    $scope.pedidosMensais.push(pedidoService.gerarPedidoComValor(d));
                    $scope.lucroMensal = gerarLucroMensal($scope.pedidosMensais);
                });
            }, fail => {
                alert(fail.data.mensagens);
            });
    }  

    function getPedidosAtrasados () {
        pedidoService.getAtrasos()
            .then(response => {
                $scope.pedidosAtrasados = response.data.dados;
            }, fail => {
                alert(fail.data.mensagens);
            })
    }  

    function gerarLucroMensal(pedidos){
        return pedidos.map(p => p.precoTotal).reduce((a,b) => a + b);
    }
}