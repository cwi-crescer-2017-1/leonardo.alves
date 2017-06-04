app.factory("usuarioService", usuarioService);

function usuarioService ($http) {
    let url = "http://localhost:6200/api/usuario";  

    var postUsuario = (usuario) => $http.post(url, usuario);

    return {
        create: postUsuario,
    } 
}
