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
      .when("/pedido", {
            controller: "pedidoController",
            templateUrl: "pedido/pedido.html"
      })
      .when("/relatoriomensal", {
            controller: "relatorioController",
            templateUrl: "relatorio/relatorio-mensal.html"
      })
      .when("/relatorioatrasos", {            
            controller: "relatorioController",
            templateUrl: "relatorio/relatorio-atrasos.html"
      })
      .when("/cadastrocliente", {            
            controller: "clienteController",
            templateUrl: "cliente/cadastrocliente.html"
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