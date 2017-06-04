app.controller("livroController", livroController);

function livroController($scope, $routeParams, $rootScope, $location,livroService, authService) {
    $scope.auth = authService;
    var idLivro = $routeParams.idLivro;

    $rootScope.isAutenticado = authService.isAutenticado;
    $rootScope.logout = authService.logout;
    getLivro();

    $scope.editarLivro = editarLivro;
    $scope.deletarLivro = deletarLivro;
    function getLivro() {
        livroService
            .read(idLivro)
            .then(response => {
                
                    $scope.livro = response.data.data;
                    $scope.exibir = true;
                },
                fail => {
                    
                    $scope.mensagens = fail.data.mensagens;
                    $scope.showError = true;
                }
            );
    }


    function editarLivro(livro) {        
       return livroService.update(idLivro, livro)
            .then(response => {
                Materialize.toast("Livro atualizado com sucesso!", 1500, 'round');
            }, fail => {
                let mensagens = "";
                for (i in fail.data.mensagem) mensagens + " , " + mensagem[i];
                Materialize.toast(mensagens, 3000, 'round');
            });
    }

    function deletarLivro() {
        return livroService.delete($scope.livro.Isbn)
            .then(response => {
                Materialize.toast("Livro deletado.", 1500, 'round');
                $scope.livro = [];
                $location.path("/administrativo");
            }, fail =>{
                let mensagens = "";
                for (i in fail.data.mensagem) mensagens + " , " + mensagem[i];
                Materialize.toast(mensagens, 3000, 'round');
            })
    }
}