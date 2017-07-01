var app = angular.module("musicio", ['ngRoute', 'auth', 'ngtimeago']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        controller: "usuarioController",
        templateUrl: "home/home.html",        
    })
    .when("/cadastro", {
        templateUrl: "usuario/cadastro.html"
    })
    .when("/dashboard", {
        templateUrl: "usuario/dashboard.html",
        controller: "usuarioController",
        resolve: {
            autenticado: function  (authService)  {
               return authService.isAutenticadoPromise();
            }
        }
    })     
});


// Configurações utilizadas pelo módulo de autenticação (authService)
app.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:9090/api/usuarios/currentUser',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/dashboard',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/'
});