angular.module('livrariaCrescer')
  .config(function ($routeProvider) {

    $routeProvider
      .when('/home', {
        controller: 'listagemLivroController',
        templateUrl: 'livro/listagem-livro.html'
      })
      .when("/livro/:idLivro", {
            controller: "livroController",
            templateUrl: "livro/livro.html"
        })
      .when("/login", {
            controller: "usuarioController",
            templateUrl: "usuario/login.html"
      })
      .when("/cadastro", {
            controller: "usuarioController",
            templateUrl: "usuario/cadastro.html"
      })
      .otherwise({ redirectTo:'/home' });

  });