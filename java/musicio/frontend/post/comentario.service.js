app.factory("comentarioService", comentarioService);

function comentarioService ($http) {
    var url = "http://localhost:9090/api/comentarios";

    var comentar = (comentario) => $http.post(url, comentario);

    return {
       comentar: comentar
    }
}