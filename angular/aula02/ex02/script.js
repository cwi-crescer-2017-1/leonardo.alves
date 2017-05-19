var app = angular.module('horaApp', []);


app.controller("controller", function ($scope) {
    $scope.converterHora = converterHora;

    function converterHora() {
    let data = new Date(formatarData($scope.inputHora));    
    $scope.horaConvertida = data;
    }
});

function formatarData(data) {
    return data.replace(/(\d{2})\D(\d{2})\D(\d{4})/, "$3,$2,$1");
}
