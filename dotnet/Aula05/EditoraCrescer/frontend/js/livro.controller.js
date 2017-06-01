app.controller("livroController", livroController);

function livroController($scope, livroService){
    getLivros();

    console.log($scope.livros)

    function getLivros (){
       return livroService.readAll()
            .then(response =>  {                
                $scope.livros = response.data.data;
            });
    }
}