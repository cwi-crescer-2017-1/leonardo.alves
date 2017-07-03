var app = angular.module("musicio", ['ngRoute', 'auth', 'ngtimeago']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        controller: "homeController",
        templateUrl: "home/home.html",        
    })
    .when("/cadastro", {
        controller: "cadastroController",
        templateUrl: "cadastro/cadastro.html"
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
    .when("/amigos", {
        templateUrl: "amigos/amigos.html",
        controller: "amigoController",
        resolve: {
            autenticado: function  (authService)  {
               return authService.isAutenticadoPromise();
            }
        }
    }) 
    .when("/amigo/:id", {
        templateUrl: "amigos/amigos-perfil.html",
        controller: "amigosPerfilController",
        resolve: {
            autenticado: function  (authService)  {
               return authService.isAutenticadoPromise();
            }
        }
    })
    .when("/pesquisa", {
        templateUrl: "pesquisa/pesquisa.html",
        controller: "pesquisaController",
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