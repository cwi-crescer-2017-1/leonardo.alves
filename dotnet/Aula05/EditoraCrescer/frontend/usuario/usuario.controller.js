app.controller("usuarioController", usuarioController);

function usuarioController($scope, $rootScope,authService, livroService) {
    $scope.auth = authService;
    $scope.livros = [];
    $rootScope.isAutenticado = authService.isAutenticado;
    $rootScope.logout = authService.logout;  

    $scope.parametros = {pegar: 6, pular: 0};

    $scope.getLivros = getLivros;
    $scope.login = login;
    $scope.adicionarLivro = adicionarLivro;

    getLivros();
    
    
    function login (usuario) {         
        authService.login(usuario)       
        .then(
            function (response) {          
                Materialize.toast('Logado com sucesso!', 1000, 'rounded');       
            },
            function (response) {  
                Materialize.toast('Opa! Algo deu errado.', 1000, 'rounded');             
            });
    }

     function getLivros (){
       return livroService.readAll($scope.parametros)
            .then(response =>  { 
                for(livro of response.data.data){
                    $scope.livros.push(livro);
                }
                
                $scope.parametros.pegar += 6;
                $scope.parametros.pular += 6;
             })
            
    } 

    function adicionarLivro (livro){
        return livroService.create(livro)
            .then(response => {
                Materialize.toast("Livro adicionado com sucesso!", 1500, 'rounded');
                $scope.livro = [];
            }, fail => {
                mensagens = "";
                for(i in fail.data.mensagem) mensagens  + " , " + mensagem[i];
               
                Materialize.toast(mensagens, 3000, 'rounded');
            })
    }
}