app.controller("homeController", homeController);

app.factory("homeService", homeService);

function homeService () {
    var isAutenticado;

    return {
        isAutenticado: isAutenticado
    }
}

function homeController ($rootScope, authService, $location, $scope, homeService) {
    $scope.logar = logar;
    $rootScope.home = true;    

    if(authService.isAutenticado()){
        $location.path("dashboard");
    }

    function logar () {
        authService.login($scope.usuario)
            .then(response => {
                boasVindas.show();
                $rootScope.isAutenticado = true;
            }, fail => {
                new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
            });
    }
}
