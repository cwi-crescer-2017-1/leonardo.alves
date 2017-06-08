angular.module('locadoraCrescer').controller("relatorioController", relatorioController);

function relatorioController ($scope, pedidoService) {   
   $scope.getRelatorioMensal = getRelatorioMensal;


    function getRelatorioMensal (data) {
        pedidoService.getRelatorio(data.Data)
            .then(response => {
                $scope.pedidos = response.data.dados; 
            }, fail => {
                alert(fail.data.mensagens);
            })
    }

}
    
    