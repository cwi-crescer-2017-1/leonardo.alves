app.controller("usuarioController", usuarioController);

function usuarioController ($scope, $rootScope, amizadeService, authService, 
            $location, postService, comentarioService, usuarioService) {

    $scope.ultimaPagina = false;       
    $scope.numPagina = 0;
    $scope.posts = [];
    $scope.comentario = [];
    $scope.infoUsuario = authService.getUsuario();    
    //converte string data para date    
    $scope.infoUsuario.dataNascimento = new Date($scope.infoUsuario.dataNascimento);
    
    $scope.copiaUsuario = angular.copy($scope.infoUsuario);

    $rootScope.isAutenticado = authService.isAutenticado();
    $rootScope.isHome = false;
    $rootScope.logout = authService.logout;
    
    $rootScope.pesquisar = pesquisar;

    $scope.postar = postar;
    $scope.carregarPosts = carregarPosts;
    $scope.comentar = comentar;
    $scope.aceitarAmigo = aceitarAmigo;
    $scope.recusarAmigo = recusarAmigo;
    $scope.editar = editar;
    $scope.closeEdit = closeEdit;
    
    carregarPosts();
    carregarSolicitacoes();
   

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