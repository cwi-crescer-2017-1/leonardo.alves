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
        if(!podeAdicionarAula()) return;

        let aula = angular.copy($scope.aula);
        aulaService.create(aula);   

        $scope.aula = {};

        setTimeout(() => {$scope.success.add = false;}, 500);        
    }

    function modAula() {
        $scope.success.modify = false;    
        if(!podeModificarAula()) return;

        find.nome = $scope.mod.novo; //renomeia 

        aulaService.update(find).then(getAula());   

        $scope.mod = {};
        $scope.success.modify = true;

        setTimeout(() => {$scope.success.modify = false;}, 500);
    }

    function delAula() {
        $scope.success.delete = false;        
        let aula = podeDeletarAula();
        if(!aula) return; //se o metodo podeDeletarAula retornar undefined ele sai
        
        aulaService.delete(aula).then(getAula());

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

    var podeAdicionarAula = () => {
        let find = procuraNome($scope.aula.nome);
        if ($scope.adicionaAula.$invalid) return false;
        if (find || typeof $scope.aula.nome === "undefined") return false;
        return true;
    };

    var podeModificarAula = () => {
        let find = procuraNome($scope.mod.acha);
        if (!find || 
            typeof $scope.mod.acha === "undefined" || 
            typeof $scope.mod.novo === "undefined") return false;
        return true;
    };

    var podeDeletarAula = () => {
        let aulaDadaAux = [];       
        let find = procuraId($scope.idAula);

        if (!find) return false; //caso nao encontre o ID, ele retorna
        aAulaEstaSendoDada();
        if (typeof aulaDadaAux[0] !== "undefined") 
            return false; //verifica se a aula está sendo dada

        return find;
    };
}