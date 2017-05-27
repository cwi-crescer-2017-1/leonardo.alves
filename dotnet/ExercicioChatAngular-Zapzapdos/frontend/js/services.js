app.factory("usuarioService", usuarioService);
app.factory("mensagemService", mensagemService);

var url = "http://localhost:50693/api";

function usuarioService ($http) {

    var getUsuario = () => $http.get(url + "/usuario");

    var getUmUsuario = (usuario) => $http.get(url + "/usuario/" + usuario.id, usuario);

    var postUsuario = (usuario) => $http.post(url + "/usuario", usuario);

    return {
        create: postUsuario,
        read:   getUsuario
    }
}

function mensagemService ($http) {

    var getMensagem = () => $http.get(url + "/mensagem");

    var postMensagem = (mensagem) => $http.post(url + "/mensagem", mensagem);

    return {
        create: postMensagem,
        read: getMensagem
    }
}