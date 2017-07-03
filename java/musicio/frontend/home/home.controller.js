app.controller("homeController", homeController);

function homeController ($rootScope, authService, $location, $scope) {
    $scope.logar = logar;
    $rootScope.home = true;
    if(!$rootScope.home) {
        $rootScope.home = true;
        $rootScope.$apply();
    }

    if(authService.isAutenticado()){
        $location.path("dashboard");
    }

    function logar () {
        authService.login($scope.usuario)
            .then(response => {
                boasVindas.show();
            }, fail => {
                new Noty({                    
                    type: 'error',
                    text: fail.data.message
                }).show();
            });
    }
}
