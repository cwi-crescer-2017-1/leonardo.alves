app.controller("musicaController", musicaController);



function musicaController ($scope, $rootScope,$http, Spotify, $sce) {   
    $scope.params = [];
    $scope.procuraMusica = procuraMusica;
    $scope.urlMusica = urlMusica;
    if($rootScope.hash !== "" && typeof $rootScope.hash !== 'undefined'){
        let hash = angular.copy($rootScope.hash);
        $rootScope.hash = "";
        let x = hash.split("&");
        let y = x[0].split("=")[1];       
        $scope.accessToken = y;
    }

    function procuraMusica () {
        Spotify.setAuthToken($scope.accessToken);
        Spotify.search($scope.pesquisa.texto, $scope.pesquisa.tipo)
            .then(response => {
                $scope.dados = response.data;
                console.log(response.data);
               
            });
    }  

    function urlMusica(musica){       
        let uri = "https://open.spotify.com/embed?uri=" + musica.uri + "&theme=white&view=coverart";
        return $sce.trustAsResourceUrl(uri);
    }  
}