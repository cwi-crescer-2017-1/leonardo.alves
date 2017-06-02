app.factory("autorService", autorService);
app.factory("revisorService", revisorService);
app.factory("usuarioService", usuarioService);

var url = "http://localhost:61097/api/";


function autorService ($http) {

    var getAutores  = () => $http.get(url + "autores");

    var getAutor = (id) => $http.get(url + "autores/" + id, id);

    var getLivrosAutor = (autor) => $http.post(url + "autores/" + autor.id, autor);   
    
    var postAutor = (autor) => $http.post(url + "autores", autor);

    var putAutor = (id, autor) => $http.post(url + "autores/" + id, autor);

    var deleteAutor = (id, autor) => $http.delete(url + "autores/" + id, autor);

    return {
        read: getAutor,
        readall: getAutores,
        readAuthorBook: getLivrosAutor,
        create: postAutor,
        update: putAutor,
        delete: deleteAutor
    } 

    
}
function revisorService ($http) {

    
    var getRevisores  = () => $http.get(url + "revisores");

    var getRevisor = (id) => $http.get(url + "revisores/" + id, id);
    
    var postRevisor = (autor) => $http.post(url + "revisores", autor);

    var putRevisor = (id, autor) => $http.post(url + "revisores/" + id, autor);

    var deleteRevisor = (id, autor) => $http.delete(url + "revisores/" + id, autor);

    return {
        read: getRevisor,
        readall: getRevisores,        
        create: postRevisor,
        update: putRevisor,
        delete: deleteRevisor
    } 
    
}
function usuarioService ($http) {
    
}
