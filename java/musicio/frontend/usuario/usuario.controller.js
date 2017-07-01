app.controller("usuarioController", usuarioController);

function usuarioController ($scope, $rootScope, usuarioService, authService, $location, postService) {
    $scope.ultimaPagina = false;
    $scope.logar = logar;
    $scope.numPagina = 0;
    $scope.posts = [];
    $rootScope.isAutenticado = authService.isAutenticado();
    $rootScope.isHome = isHome;
    $rootScope.logout = authService.logout;   

    $scope.postar = postar;
    $scope.carregarPosts = carregarPosts;

    carregarPosts();

    function postar () {

        postService.addPost($scope.post)
            .then(response => {
                $scope.post.texto = "";
                atualizarPostsAposPostar();
            }, fail => {
                alert("Não foi dessa vez.");
            })
    }

    function carregarPosts () {
        
        postService.pegarPosts($scope.numPagina)
            .then(response => {
                 if (response.data.last) 
                    $scope.ultimaPagina = true;
                   
                response.data.content.forEach(
                   
                    post => { 
                       
                        $scope.posts.push(post); 
                    }                    
                );
                $scope.numPagina++;
            }, fail => {
                alert("Erro ao carregar");
            });
    }

    function atualizarPostsAposPostar () {
        $scope.posts = [];
        postService.pegarPosts(0)
            .then(response => {
                response.data.content.forEach(
                    post => {
                        $scope.posts.push(post);
                    }
                );
            }, fail => {
                alert("Erro ao carregar");
            })
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