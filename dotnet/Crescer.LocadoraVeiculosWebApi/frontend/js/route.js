angular.module('locadoraCrescer')
  .config(function ($routeProvider) {

    $routeProvider    
      .when("/home", {
            controller: "usuarioController",
            templateUrl: "usuario/login.html"
      })
      .when("/cadastro", {
            controller: "usuarioController",
            templateUrl: "usuario/cadastro.html"
      })
      .when("/administrativo", {
            controller: "usuarioController",
            templateUrl: "usuario/administrativo.html",
            resolve: {
              autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
            }
      })
      .otherwise({ redirectTo:'/home' });

  });