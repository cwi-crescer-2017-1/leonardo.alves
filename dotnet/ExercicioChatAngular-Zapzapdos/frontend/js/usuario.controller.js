app.controller("usuarioController", usuarioController);


function usuarioController($scope, redirecionarService, usuarioService) {
    redirecionarService.redirect();

    $scope.adicionarUsuario = adicionarUsuario;    
    function adicionarUsuario() {        
        usuarioService.create($scope.usuario).then((usuarioRetorno)=>{
            $scope.usuario = {};            
            var usuarioCopia = JSON.stringify(usuarioRetorno.data);
            localStorage.setItem("usuario", usuarioCopia);            
            redirecionarService.redirect();       
        });        
    }   
}