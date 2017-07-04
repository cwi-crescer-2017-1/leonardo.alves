app.factory("curtidaService", curtidaService);

function curtidaService($http) {
    let url = "http://localhost:9090/api/curtidas";

    var curtirPost = (curtida) => $http.post(url, curtida);

    var descurtirPost = (idPost) => 
            $http({
                    method: 'DELETE',
                    url: `${url}/${idPost}`                    
                });

    return {
        curtirPost: curtirPost,
        descurtirPost: descurtirPost
    }

}

