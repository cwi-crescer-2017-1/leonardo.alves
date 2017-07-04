app.controller("headerController", headerController);

function headerController ($scope, $rootScope,usuarioService, authService, $location, homeService) {    
    $rootScope.isAutenticado = authService.isAutenticado();
    $scope.pesquisar = pesquisar;
    $scope.logout = function() {
        $rootScope.isAutenticado = false;
        authService.logout();
    }  

    function pesquisar () {
        usuarioService.pesquisarUsuario($scope.pesquisa)
            .then(response =>{
                $scope.pesquisa = "";
                usuarioService.resultadoPesquisa = response.data;                
                $location.path("pesquisa");
               
            }, fail => {
                alert("não foi possivel buscar.");
            });
    }
}