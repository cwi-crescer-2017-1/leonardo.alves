app.controller("amigoController", amigoController);

function amigoController ($scope, $rootScope, amizadeService, authService) {
    $scope.usuario = authService.getUsuario();
    $rootScope.isAutenticado = authService.isAutenticado;
    carregarAmigos();

    function carregarAmigos () {
        amizadeService.getAmigos()
            .then(response => {
                $scope.amigos = response.data;
            }, fail => {
                alert("erro ao carregar.");
            })
    }
}