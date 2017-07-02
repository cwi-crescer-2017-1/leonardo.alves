app.controller("usuarioController", usuarioController);

function usuarioController ($scope, $rootScope, amizadeService, authService, $location, postService, comentarioService) {
    $scope.ultimaPagina = false;
    $scope.logar = logar;    
    $scope.numPagina = 0;
    $scope.posts = [];
    $scope.comentario = [];
    $scope.infoUsuario = authService.getUsuario();

    $rootScope.isAutenticado = authService.isAutenticado();
    $rootScope.isHome = isHome;
    $rootScope.logout = authService.logout;   

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
            }, fail => {
                alert("Não foi dessa vez.");
            })
    }

    function comentar(idPost) {
        let comentario = setCommentProperties(idPost);
        comentarioService.comentar(comentario)
            .then(response => {
                alert("Comentado");
                $scope.comentario[idPost] = [];
                atualizarPostsAposPostar(0);
            },fail => {
                alert("Não deu");
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
                alert("aceito");
            }, fail => {
                alert("erro");
            })
    }

    function recusarAmigo (idUsuario) {
        let usuario = { "idUsuario": idUsuario };
        amizadeService.recusarAmigo(usuario)
            .then(response => {
                alert("recusado");
            }, fail => {
                alert("erro");
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

    //se o usuario esta logado, ao acessar a index é redirecionado.
    if($rootScope.isAutenticado && isHome())
        $location.path("dashboard");

    function isHome() {
        return $location.url() === "/";
    }

    function logar () {
        authService.login($scope.usuario)
            .then(response => {
                alert("Logado");
            }, fail => {
                alert("Deu pau");
            });
    }

}