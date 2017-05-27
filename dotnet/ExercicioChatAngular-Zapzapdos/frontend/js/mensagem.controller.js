app.controller("mensagemController", mensagemController);


function mensagemController($scope, $location, usuarioService, mensagemService) {
    atualizarMensagens();
    if($location.path = "/chat") setInterval(atualizarMensagens, 5000);    
    $scope.enviarMensagem = enviarMensagem;
    
    function enviarMensagem() {        
        mensagemService.create($scope.mensagem)
            .then(atualizarMensagens);
        $scope.mensagem = {};
    }

    function atualizarMensagens() {
        return mensagemService.read()
            .then(response => { $scope.mensagens = response.data });
           
    }
    
}