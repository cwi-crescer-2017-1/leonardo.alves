angular.module('locadoraCrescer').factory("veiculoService", veiculoService);

function veiculoService($http) {
    let url = "http://localhost:64748/api/veiculos/";
    var service = {
        getVeiculos: getVeiculos
    }

    function getVeiculos() {
        return $http.get(url)
    }

    return service;
}