app.controller("listagemLivroController", listagemLivroController);

function listagemLivroController($scope, livroService){
    $scope.parametros = {pegar: 6, pular: 0};
    $scope.paginacao = {proximo: true, anterior: false};
    $scope.proximaPagina = getLivros;
    $scope.paginaAnterior = getLivros;    
    getLivros();
    getLivrosNovos();

    //timeout pro carroussel funcionar
    setTimeout(() => $('.slider').slider(), 1000);

    function getLivros (){
       return livroService.readAll($scope.parametros)
            .then(response =>  {                   
               /*
                    se o servidor devolveu 6 livros, isso indica que há
                    mais livros a serem entregues, então pode avançar de
                    página. Se o servidor devolveu menos de 6 livros,
                    quer dizer que ele tá na ultima página.
               */
                if(recebeuSeisLivros(response.data.data)){     

                    seraQueEstaNaPrimeiraPagina();

                    avançarPagina();

                    if($scope.parametros.pular !== 6)   //como a pagina so atualiza apos o clique, apenas mostra
                         $scope.paginaAnterior = true;  // o botão de volta caso o pular seja diferente que o 
                                                        //valor da primeira pagina (0 mas que agora é 6)

                } else if (aindaHaLivros(response.data.data)){                                          
                    $scope.paginacao.anterior = true;               
                    voltarPagina();             
                    $scope.paginacao.proximo = false;                  
                }               
                
                //substitui a view apenas se haver livros.
                if(!!response.data.data) $scope.livros = response.data.data;
                
            });
    } 
    function getLivrosNovos () {
        return livroService.readNews()
            .then(response =>{$scope.livrosNovos = response.data.data});
    } 

    var haPaginaAnterior = () =>        
            $scope.paginacao.anterior = $scope.parametros.pular > 0;   

    function avançarPagina () {
        $scope.parametros.pegar +=6;
        $scope.parametros.pular +=6;  
    }

    var seraQueEstaNaPrimeiraPagina = () => {
        if($scope.parametros.pular == 0) {
            $scope.paginacao.proximo = true;                        
            $scope.paginacao.anterior = false;                        
        }    
    }

    function voltarPagina () {
        $scope.parametros.pegar -=6;
        $scope.parametros.pular -=6;  
    }

    var recebeuSeisLivros = (livrosRecebidos) => livrosRecebidos.length === 6;

    var aindaHaLivros = (livrosRecebidos) => livrosRecebidos.length > 0;        
    
}