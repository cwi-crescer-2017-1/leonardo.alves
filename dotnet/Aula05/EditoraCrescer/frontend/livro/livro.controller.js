app.controller("livroController", livroController);

function livroController($scope, $routeParams, $rootScope, $location, livroService, authService) {
    $scope.auth = authService;
    var idLivro = $routeParams.idLivro;

    $rootScope.isAutenticado = authService.isAutenticado;
    $rootScope.logout = authService.logout;
    getLivro();

    $scope.editarLivro = editarLivro;
    $scope.deletarLivro = deletarLivro;
    $scope.podeSerPublicado = podeSerPublicado;
    $scope.isLivroRevisado = isLivroRevisado;
    $scope.revisar = revisar;

    function podeSerPublicado() {
        let diaAtual = new Date().getDay;
        let podePublicar = diaAtual !== 0 && diaAtual !== 6 && typeof $scope.livro.DataPublicacao === "undefined";

        if (podePublicar)
            publicarLivro();
        else {
            Materialize.toast("Não é possível publicar em final de semana ou o livro já foi publicado.", 4000, 'rounded')

        }
    }

    function isLivroRevisado() {
        return $scope.livro.DataRevisao !== null &&
            $scope.livro.IdRevisor !== null;
    }

    function revisar() {
        let diaAtual = new Date();
        let Revisor = authService.getUsuario().email;

        copiaLivro = angular.copy($scope.livro);
        copiaLivro.Revisor = {Nome: ""}; 
        copiaLivro.Revisor.Nome = Revisor;
        copiaLivro.DataRevisao = diaAtual;

        livroService.update(idLivro, copiaLivro)
            .then(response => {
                Materialize.toast("Livro revisado!", 3000, 'rounded');
            }, fail => {
                Materialize.toast("Não foi possível revisar o livro", 3000, 'rounded');
            }
        );
    }

    function publicarLivro() {
        let copiaLivro = angular.copy($scope.livro);

        copiaLivro.DataPublicacao = new Date();

        livroService.update(idLivro, copiaLivro)
            .then(response => {
                Materialize.toast("Livro publicado!", 3000, 'rounded');
                getLivro();
            }, fail => {
                Materialize.toast("Não foi possível publicar o livro.", 4000, 'rounded');
            })
    }

    function getLivro() {
        livroService
            .read(idLivro)
            .then(response => {
                    $scope.livro = response.data.dados;
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
            }, fail => {
                let mensagens = "";
                for (i in fail.data.mensagem) mensagens + " , " + mensagem[i];
                Materialize.toast(mensagens, 3000, 'round');
            })
    }
}