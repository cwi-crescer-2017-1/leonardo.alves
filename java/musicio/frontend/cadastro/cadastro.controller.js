app.controller("cadastroController", cadastroController)

function cadastroController ($scope, $rootScope,usuarioService, authService) {
    $scope.cadastrar = cadastrar;

    function cadastrar () {
        if($scope.cadastro.$invalid) {
            for(erro of $scope.cadastro.$error.required){
                new Noty({
                    text: erro.$name + " é obrigatório.",
                    type: 'error'
                }).show();
            }
           
            return;
        }

        usuarioService.cadastrarUsuario($scope.usuario)
            .then(response => {
                $rootScope.isAutenticado = true;
                authService.login($scope.usuario);
                
                delete $scope.usuario;
                contaCriada.show();
            }, fail => { 
                new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
            });
    }
}