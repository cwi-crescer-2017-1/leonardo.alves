app.controller("pesquisaController", pesquisaController);

function pesquisaController($scope, usuarioService, $rootScope, amizadeService) {

    $scope.resultadoPesquisa = usuarioService.resultadoPesquisa;
    $scope.enviarSolicitacao = enviarSolicitacao;
    $rootScope.pesquisar = pesquisar;


    function pesquisar() {
        usuarioService.pesquisarUsuario($scope.pesquisa)
            .then(response => {
                $rootScope.pesquisa = "";
                usuarioService.resultadoPesquisa = response.data;
                $scope.resultadoPesquisa = usuarioService.resultadoPesquisa;
            }, fail => {
                 new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
            });
    }

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