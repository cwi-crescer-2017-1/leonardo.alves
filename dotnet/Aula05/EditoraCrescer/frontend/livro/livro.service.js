app.factory("livroService", livroService);


function livroService ($http) {
    let url = "http://localhost:61097/api/livros/";

    var getLivros = (parametros) => $http({
           url: url,
           method: 'GET',
           params: parametros
         });   

    var getLivro = (id) => $http.get(url + id, id);

    var getLivrosPorGenero = (genero) => $http.get(url + genero, genero);

    var getLivrosLancamento = () => $http.get(url + "lancamentos");

    var postLivro = (livro) => $http.post(url, livro);    

    var putLivro = (livro) => $http.put(url + livro.id, livro);

    var deleteLivro = (livro) => $http.delete(url + livro.id, livro)


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