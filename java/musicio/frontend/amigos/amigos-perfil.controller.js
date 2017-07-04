app.controller("amigosPerfilController", amigosPerfilController);

function amigosPerfilController ($scope, $routeParams, $location, amizadeService, comentarioService, authService) {
    $scope.comentar = comentar;
    $scope.comentario = [];
    $scope.saoAmigos = false;
    $scope.enviarSolicitacao = enviarSolicitacao;

    if($routeParams.id == authService.getUsuario().idUsuario){
        $location.path("dashboard");
        seuPerfil.show();
    }
    carregarInfoAmigo();

    function carregarInfoAmigo () {
        amizadeService.getAmigo($routeParams.id)
            .then(response => {
                $scope.amigo = response.data;
                $scope.amigo.urlFoto = 
                "https://api.adorable.io/avatars/200/" + Math.floor(Math.random() * 100); 
                if($scope.amigo.posts)
                    $scope.saoAmigos = true;
            }, fail => {
                $scope.saoAmigos = true;
                new Noty({
                    text: fail.data.message,
                    type: 'error',
                    modal: true,
                    timeout: 4000,
                    closeWith: ['click', 'button']                    
                }).show();
            })
    }

    function comentar(idPost) {
        let comentario = setCommentProperties(idPost);
        comentarioService.comentar(comentario)
            .then(response => {               
                $scope.comentario[idPost] = [];
                location.reload();
            },fail => {
                    new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
            });            
    }

    function enviarSolicitacao (idUsuario) {
    let usuario = {"idUsuario": idUsuario};
    amizadeService.enviarSolicitacao(usuario)
        .then(response => {
            solicitacaoAmizade.show();
        }, fail => {
                new Noty({                    
                type: 'error',
                text: fail.data.message
            }).show();
        });
    }

    function setCommentProperties (idPost) {        
        $scope.comentario[idPost].postIdPost = {"idPost": idPost};
        $scope.comentario[idPost].usuario = {"email": authService.getUsuario().email};
        return $scope.comentario[idPost];
    }      

}