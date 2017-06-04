app.controller("listagemLivroController", listagemLivroController);

function listagemLivroController($scope, livroService) {
    $scope.parametros = {
        pegar: 6,
        pular: 0
    };
    $scope.carregarLivros = getLivros;
    $scope.haLivros = true;
    $scope.livros = [];
    getLivros();
    getLivrosNovos();

    //timeout pro carroussel funcionar
    setTimeout(() => $('.slider').slider(), 1000);

    function getLivros() {
        return livroService.readPublished($scope.parametros)
            .then(response => {
                if (response.data.dados.length > 0) {
                    for (livro in response.data.dados)
                        $scope.livros.push(response.data.dados[livro]);

                    $scope.parametros.pegar += 6;
                    $scope.parametros.pular += 6;
                } else {
                     $scope.haLivros = false;
                     Materialize.toast("Opa! Parece que você já viu todos os livros! :O", 4000, 'rounded');
                }
            });
    }

    function getLivrosNovos() {
        return livroService.readNews()
            .then(response => {
                $scope.livrosNovos = response.data.dados
            });
    }
}