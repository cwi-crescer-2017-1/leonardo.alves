angular.module('locadoraCrescer').controller("usuarioController", usuarioController);

function usuarioController ($scope, $rootScope,authService) {
    $rootScope.login = login;
    $scope.auth = authService;    
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
    
    