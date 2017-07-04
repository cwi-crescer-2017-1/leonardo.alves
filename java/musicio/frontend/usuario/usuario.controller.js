app.controller("usuarioController", usuarioController);

function usuarioController ($scope, $rootScope, amizadeService, authService, 
            $location, postService, comentarioService, usuarioService, curtidaService) {

    $scope.ultimaPagina = false;       
    $scope.numPagina = 0;
    $scope.posts = [];
    $scope.comentario = [];
    $scope.verificaCurtida = verificaCurtida;
    $scope.corLike = corLike;
    $scope.infoUsuario = authService.getUsuario(); 

    //converte string data para date 
    if(typeof $scope.infoUsuario.dataNascimento != 'object'){
        var from =  $scope.infoUsuario.dataNascimento.split("-");
        $scope.infoUsuario.dataNascimento = new Date(from[2], from[1] - 1, from[0]);     

    }  
    $scope.copiaUsuario = angular.copy($scope.infoUsuario);   
   
    $scope.postar = postar;
    $scope.carregarPosts = carregarPosts;
    $scope.comentar = comentar;
    $scope.aceitarAmigo = aceitarAmigo;
    $scope.recusarAmigo = recusarAmigo;
    $scope.editar = editar;
    $scope.closeEdit = closeEdit;
    $scope.curtir = curtir;

    carregarPosts();
    carregarSolicitacoes(); 

    if($location.hash() !== ""){
        $rootScope.hash = $location.hash();
        $location.path("musica");
    }  

    $scope.infoUsuario.urlFoto = 
        "https://api.adorable.io/avatars/200/" + Math.floor(Math.random() * 100);            

    function postar () {

        postService.addPost($scope.post)
            .then(response => {
                $scope.post.texto = "";
                atualizarPostsAposPostar(0);
                publicacaoPostada.show();
            }, fail => { 
                    new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
                
            })
    }

    function editar(){
        $scope.open = '';
        let copia = {
            "idUsuario": $scope.infoUsuario.idUsuario,
            "email": $scope.infoUsuario.email,
            "senha": $scope.infoUsuario.senha,
            "sexo": $scope.infoUsuario.sexo,
            "dataNascimento": $scope.infoUsuario.dataNascimento,
            "nome": $scope.infoUsuario.nome
        }
       
        usuarioService.editarUsuario(copia)
            .then(response => {
                editarConta.show();
                $scope.infoUsuario.senha = '';
            }, fail => {
                new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
                $scope.infoUsuario = $scope.copiaUsuario;
            })
        
    }

    function closeEdit() {
        $scope.infoUsuario = angular.copy($scope.copiaUsuario);
        $scope.open = '';
        new Noty({                    
            type: 'information',
            text: "Edição cancelada."
        }).show();
    }

    function comentar(idPost) {
        let comentario = setCommentProperties(idPost);
        comentarioService.comentar(comentario)
            .then(response => {               
                $scope.comentario[idPost] = [];
                atualizarPostsAposPostar(0);
            },fail => {
                   new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
            });            
    }

    function carregarPosts () {
        
        postService.pegarPosts($scope.numPagina)
            .then(response => {                 
                $scope.ultimaPagina = response.data.last;
                   
                response.data.content.forEach(                  
                    post => { $scope.posts.push(post); }                    
                );
                $scope.numPagina++;
            }, fail => {
                alert("Erro ao carregar");
            });
    }

    function carregarSolicitacoes () {
        amizadeService.getAmizadesPendentes()
            .then(response => {
                $scope.amizadesPendentes = response.data;
            }, fail => {
                alert("erooooooo");
            })
    }

    function aceitarAmigo (idUsuario) {
        let usuario = { "idUsuario": idUsuario };
        amizadeService.aceitarAmizade(usuario)
            .then(response => {
                aceitarAmizade.show();
            }, fail => {
                    new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
            })
    }

    function recusarAmigo (idUsuario) {
        let usuario = { "idUsuario": idUsuario };
        amizadeService.recusarAmizade(usuario)
            .then(response => {
                recusarAmizade.show();
            }, fail => {
                   new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
            })
    }

    function atualizarPostsAposPostar (numeroPagina) {
        $scope.posts = [];
        postService.pegarPosts(numeroPagina)
            .then(response => {                                
                $scope.ultimaPagina = response.data.last;
                response.data.content.forEach(
                    post => { $scope.posts.push(post); });
            }, 
            fail => { alert("Erro ao carregar"); });
    }

    function setCommentProperties (idPost) {        
        $scope.comentario[idPost].postIdPost = {"idPost": idPost};
        $scope.comentario[idPost].usuario = {"email": authService.getUsuario().email};
        return $scope.comentario[idPost];
    }          

    function curtir(postIdPost) {
        let usuarioCurtiu = verificaCurtida(postIdPost).length > 0; 
        let curtida = { "postIdPost": { "idPost": postIdPost } };

        if(usuarioCurtiu)
            curtidaService.descurtirPost(postIdPost)
                .then(response => {
                    location.reload();
                }, fail => {
                    new Noty({                    
                        type: 'error',
                        text: fail.data.message
                    }).show();
                });
        else
            curtidaService.curtirPost(curtida)
                .then(response => {
                    location.reload();
                    curtirPost.show();
                }, fail => {
                    new Noty({                    
                            type: 'error',
                            text: fail.data.message
                        }).show();
                })
    }

    function verificaCurtida (postIdPost) {
        let post = $scope.posts.filter(p => p.idPost === postIdPost);
        return post[0].curtidaList.filter(c => c.idUsuario === $scope.infoUsuario.idUsuario);
    }  

    function corLike (idPost)  {
        if(verificaCurtida(idPost).length > 0)
            return {'liked-post': true};
        return {'not-liked-post': true};
    }
}