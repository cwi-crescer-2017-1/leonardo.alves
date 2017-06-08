angular.module('locadoraCrescer').factory("pacoteService", pacoteService);

function pacoteService($http) {
    let url = "http://localhost:64748/api/pacotes/";

    var service = {
        getPacotes: getPacotes
    };

    function getPacotes() {
        return $http.get(url);
    }

    return service;
}