app.factory("livroService", livroService);
app.factory("autorService", autorService);
app.factory("revisorService", revisorService);
app.factory("usuarioService", usuarioService);

var url = "http://localhost:61097/api/";

function livroService ($http) {

    var getLivros = () => $http.get(url + "livros");

    var getLivro = (id) => $http.get(url + "livros/" + id, id);

    var getLivrosPorGenero = (genero) => $http.get(url + "livros/" + genero, genero);

    var getLivrosLancamento = () => $http.get(url + "livros/" + "lancamentos");

    var postLivro = (livro) => $http.post(url + "livros", livro);    

    var putLivro = (livro) => $http.put(url + "livros/" + livro.id, livro);

    var deleteLivro = (livro) => $http.delete(url + "livros/" + livro.id, livro)


    return {
        read: getLivro,
        readAll: getLivros,
        readGender: getLivrosPorGenero,
        readNews: getLivrosLancamento,        
        create: postLivro,
        update: putLivro,
        delete: deleteLivro    
    }
}
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
