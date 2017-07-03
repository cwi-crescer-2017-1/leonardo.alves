app.factory("amizadeService", amizadeService);

function amizadeService ($http) {
    var url = "http://localhost:9090/api/amizades";

    var getAmizadesPendentes = () => $http.get(url);

    var recusarAmizade = (amigo) => $http.put(`${url}/recusar`, amigo);

    var aceitarAmizade = (amigo) => $http.put(`${url}/aceitar`, amigo);     

    var getAmigos = () => $http.get(`${url}/todos`);

    var getAmigo = (id) => $http.get(`${url}/${id}`, id);

    var enviarSolicitacao = (usuario) => $http.post(url, usuario);

    return {
        getAmigo: getAmigo,
        getAmizadesPendentes : getAmizadesPendentes,
        getAmigos: getAmigos,
        aceitarAmizade: aceitarAmizade,
        recusarAmizade: recusarAmizade,
        enviarSolicitacao: enviarSolicitacao
    }
}