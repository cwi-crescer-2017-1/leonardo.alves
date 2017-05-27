app.controller("usuarioController", usuarioController);


function usuarioController($scope, $location, usuarioService) {

    $scope.adicionarUsuario = adicionarUsuario;

    function adicionarUsuario() {
        debugger;
        usuarioService.create($scope.usuario).then(()=>{
            $scope.usuario = {};            
            $location.path("/chat");
        });
        
    }
}