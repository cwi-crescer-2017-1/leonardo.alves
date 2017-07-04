app.controller("pesquisaController", pesquisaController);

function pesquisaController($scope, usuarioService, $rootScope, amizadeService) {

    $scope.resultadoPesquisa = usuarioService.resultadoPesquisa;
    $scope.enviarSolicitacao = enviarSolicitacao;
   
    function enviarSolicitacao (idUsuario) {
        let usuario = {"idUsuario": idUsuario};
        amizadeService.enviarSolicitacao(usuario)
            .then(response => {
                solicitacaoAmizade.show();
            }, fail => {
                 new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
            });
    }


}