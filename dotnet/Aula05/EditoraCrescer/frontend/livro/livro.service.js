app.factory("livroService", livroService);


function livroService ($http) {
    let url = "http://localhost:6200/api/livros/";

    var getLivros = (parametros) => $http({
           url: url + "/todos",
           method: 'GET',
           params: parametros
         }); 

    var getLivrosPublicados = (parametros) => $http({
        url: url,
        method: 'GET',
        params: parametros
    })

    var getLivro = (id) => $http.get(url + id, id);

    var getLivrosPorGenero = (genero) => $http.get(url + genero, genero);

    var getLivrosLancamento = () => $http.get(url + "lancamentos");

    var postLivro = (livro) => $http.post(url, livro);    

    var putLivro = (idLivro,livro) => $http.put(url + idLivro, livro);

    

    var deleteLivro = (id) => $http({
        url: url + id,
        method: 'DELETE',
        params: id
    });


    return {
        read: getLivro,
        readAll: getLivros,
        readGender: getLivrosPorGenero,
        readNews: getLivrosLancamento, 
        readPublished: getLivrosPublicados,       
        create: postLivro,
        update: putLivro,        
        delete: deleteLivro    
    }
}