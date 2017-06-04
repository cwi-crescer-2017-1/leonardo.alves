app.factory("usuarioService", usuarioService);

function usuarioService ($http) {
    let url = "http://localhost:6200/api/usuario";

    var usuario   = () => $http.get(url + "usuario");   

    return {
        read: getAutor,
        readall: getAutores,
        readAuthorBook: getLivrosAutor,
        create: postAutor,
        update: putAutor,
        delete: deleteAutor
    } 
}
