angular.module('locadoraCrescer').factory("opcionalService", opcionalService);

function opcionalService($http) {
    let url = "http://localhost:64748/api/opcionais/";
    var service = {
        getOpcionais: getOpcionais
    };

    function getOpcionais() {
        return $http.get(url);
    }

    return service;
}