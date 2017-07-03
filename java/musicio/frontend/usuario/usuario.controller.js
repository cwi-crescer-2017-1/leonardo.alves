app.controller("usuarioController", usuarioController);

function usuarioController ($scope, $rootScope, amizadeService, authService, 
            $location, postService, comentarioService, usuarioService) {

    $scope.ultimaPagina = false;       
    $scope.numPagina = 0;
    $scope.posts = [];
    $scope.comentario = [];
    $scope.infoUsuario = authService.getUsuario();

    $rootScope.isAutenticado = authService.isAutenticado();
    $rootScope.isHome = false;
    $rootScope.logout = authService.logout;
    
    $rootScope.pesquisar = pesquisar;

    $scope.postar = postar;
    $scope.carregarPosts = carregarPosts;
    $scope.comentar = comentar;
    $scope.aceitarAmigo = aceitarAmigo;
    $scope.recusarAmigo = recusarAmigo;

    
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
                erroGenerico.setText(fail.data.message);
                erroGenerico.show();
            })
    }

    function comentar(idPost) {
        let comentario = setCommentProperties(idPost);
        comentarioService.comentar(comentario)
            .then(response => {               
                $scope.comentario[idPost] = [];
                atualizarPostsAposPostar(0);
            },fail => {
                erroGenerico.setText(fail.data.message);
                erroGenerico.show();
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
                erroGenerico.setText(fail.data.message);
                erroGenerico.show();
            })
    }

    function recusarAmigo (idUsuario) {
        let usuario = { "idUsuario": idUsuario };
        amizadeService.recusarAmizade(usuario)
            .then(response => {
                recusarAmizade.show();
            }, fail => {
                erroGenerico.setText(fail.data.message);
                erroGenerico.show();
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