app.factory("usuarioService", usuarioService);

function usuarioService ($http) {
    let url = "http://localhost:9090/api/usuarios";

    var pesquisarUsuario = (pesquisa) => $http.get(`${url}/pesquisa/${pesquisa}`);

    var cadastrarUsuario = (usuario) => $http.post(url, usuario);

    var resultadoPesquisa = [];

    return {
        pesquisarUsuario: pesquisarUsuario,
        resultadoPesquisa: resultadoPesquisa,
        cadastrarUsuario: cadastrarUsuario
    }
}