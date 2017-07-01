app.controller("usuarioController", usuarioController);

function usuarioController ($scope, $rootScope, usuarioService, authService, $location, postService) {
    $scope.logar = logar;
    $rootScope.isAutenticado = authService.isAutenticado();
    $rootScope.isHome = isHome;
    $rootScope.logout = authService.logout;   

    $scope.postar = postar;

    function postar () {

        postService.addPost($scope.post)
            .then(response => {
                alert("Postado");
            }, fail => {
                alert("Não foi dessa vez.");
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