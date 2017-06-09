angular.module('locadoraCrescer').controller("usuarioController", usuarioController);

function usuarioController ($scope, authService) {
    $scope.auth = authService;
    $scope.login = login;
    $scope.logout = authService.logout;

    function login (usuario) {           
        authService.login(usuario)       
        .then(
            function (response) {          
                alert("logado!");
            },
            function (response) {  
                alert("Erro ocorreu");
            });

    }
}
    
    