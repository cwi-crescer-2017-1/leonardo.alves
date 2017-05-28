app.controller("mensagemController", mensagemController);


function mensagemController($scope, $location, usuarioService, mensagemService) {
    atualizarMensagens();
    if($location.path = "/chat") setInterval(atualizarMensagens, 5000);    
    $scope.enviarMensagem = enviarMensagem;
    
    function enviarMensagem() {
        var copiaMensagem = angular.copy($scope.mensagem);   
        $scope.mensagem = {};

        copiaMensagem.Usuario = pegarUsuario();

        mensagemService.create(copiaMensagem)
            .then(atualizarMensagens);        
    }

    function atualizarMensagens() {
        return mensagemService.read()
            .then(response => { $scope.mensagens = response.data });
           
    function pegarUsuario () {
        var usuario = JSON.parse(localStorage.getItem("usuario"));
        return usuario;
    }
    
}