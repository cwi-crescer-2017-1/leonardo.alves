crudApp.controller("aulaController", aulaController);

function aulaController($scope) {
    let idAulas = 0;
    $scope.success = {
        add: false,
        modify: false,
        delete: false
    };   
    $scope.addAula = addAula;
    $scope.modAula = modAula;
    $scope.delAula = delAula;

    let procuraNome = (nome) =>
        $scope.aulas.find(a => a.nome === nome);

    let procuraId = (id) =>
        $scope.aulas.find(a => a.id == id);


    function addAula() {
        $scope.success.add = false;
        let find = procuraNome($scope.aula.nome);
        if ($scope.adicionaAula.$invalid) return;
        if (find || typeof $scope.aula.nome === "undefined") return;

        let aula = angular.copy($scope.aula);
        aula.id = ++idAulas;
        $scope.aulas.push(aula);
        $scope.aula = {};
        $scope.success.add = true;

        setTimeout(() => {$scope.success.add = false;}, 500);
        
    }

    function modAula() {
        $scope.success.modify = false;

        //if($scope.modificaAula.$invalid) return;
        let find = procuraNome($scope.mod.acha);

        if (!find || typeof $scope.mod.acha === "undefined" || typeof $scope.mod.novo === "undefined") return;

        let novaAula = angular.copy($scope.mod);
        $scope.aulas[find.id].nome = novaAula.novo;
        $scope.mod = {};
        $scope.success.modify = true;

        setTimeout(() => {$scope.success.modify = false;}, 500);
    }

    function delAula() {
        $scope.success.delete = false;
        let aulaDadaAux = [];
        console.log($scope.idAula);
        let find = procuraId($scope.idAula);

        if (!find) return; //caso nao encontre o ID, ele retorna              
        aulaDada();
        if (typeof aulaDadaAux[0] !== "undefined") return; //verifica se a aula está sendo dada

        let idAula = angular.copy($scope.idAula);
        $scope.aulas[idAula] = {};

        $scope.success.delete = true;
        setTimeout(() => {$scope.success.delete = false;}, 500);

        function aulaDada() {
            
            $scope.instrutores.forEach(i => {
                let aulaNotNull = i.aula.find(n => n == $scope.idAula);
                if(typeof aulaNotNull !== "undefined"){
                    aulaDadaAux.push($scope.idAula);                    
                }
            })
        }

    }
}