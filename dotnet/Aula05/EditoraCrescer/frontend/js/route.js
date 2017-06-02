angular.module('livrariaCrescer')
  .config(function ($routeProvider) {

    $routeProvider
      .when('/home', {
        controller: 'livroController',
        templateUrl: 'livro/listagem-livro.html'
      })
      .otherwise('/home');

  });