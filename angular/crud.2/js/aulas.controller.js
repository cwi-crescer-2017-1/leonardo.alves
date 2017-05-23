crudApp.controller("aulaController", aulaController);

function aulaController($scope, $routeParams, aulaService, instrutorService) {
    let id = $routeParams.idAula;    
    
    $scope.success = {
        add: false,
        modify: false,
        delete: false
    };   

    //requisições GET pro servidor
    getAula();  
    getInstrutor();

    $scope.addAula = addAula;
    $scope.modAula = modAula;
    $scope.delAula = delAula;
   
    //funções para requisitar o servidor
    function getAula() {
       aulaService.read().then(response => {
         $scope.aulas = response.data;  
       })
    }
    
    function addAula() {
        $scope.success.add = false;
        let find = procuraNome($scope.aula.nome);
        if ($scope.adicionaAula.$invalid) return;
        if (find || typeof $scope.aula.nome === "undefined") return;

        let aula = angular.copy($scope.aula);
        aulaService.create(aula);   

        $scope.aula = {};

        setTimeout(() => {$scope.success.add = false;}, 500);        
    }

    function modAula() {
        $scope.success.modify = false;        
        let find = procuraNome($scope.mod.acha);
        if (!find || typeof $scope.mod.acha === "undefined" || typeof $scope.mod.novo === "undefined") return;

        find.nome = $scope.mod.novo; //renomeia 

        aulaService.update(find);   

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

        aAulaEstaSendoDada();

        if (typeof aulaDadaAux[0] !== "undefined") return; //verifica se a aula está sendo dada
               
        aulaService.delete(find).then(getAula());

        $scope.success.delete = true;
        setTimeout(() => {$scope.success.delete = false;}, 500);
    }  

    function getInstrutor () {
       instrutorService.read().then(response => {
           $scope.instrutores = response.data;
       });
    }

    //funções para logica de negocio
    var aAulaEstaSendoDada = () => {
        $scope.instrutores.forEach(i => {
            let aulaNotNull = i.aula.find(n => n == $scope.idAula);
            if(typeof aulaNotNull !== "undefined")
                aulaDadaAux.push($scope.idAula);
        })      
    }; 

    var procuraNome = (nome) =>
        $scope.aulas.find(a => a.nome === nome);

    var procuraId = (id) =>
        $scope.aulas.find(a => a.id == id);
}