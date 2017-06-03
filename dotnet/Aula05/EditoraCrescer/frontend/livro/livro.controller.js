app.controller("livroController", livroController);

function livroController($scope, $routeParams, livroService) {
    var idLivro = $routeParams.idLivro;
    getLivro();

    function getLivro() {
        livroService
        .read(idLivro)
        .then(response => 
            { 
                $scope.livro = response.data.data; 
                $scope.exibir = true;
            },
            fail => 
            {                 
                $scope.mensagens = fail.data.mensagem;
                $scope.showError = true;
            }
        );
    }
}