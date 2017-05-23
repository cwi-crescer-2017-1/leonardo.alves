crudApp.controller("instrutorController", instrutorController);


function instrutorController($scope, $routeParams, aulaService, instrutorService) {
    let id = $routeParams.idInstrutor;   

    $scope.success = {
        add: false,
        modify: false,
        delete: false
    };
    
    getAula();
    getInstrutor();
       
    $scope.addInstrutor = addInstrutor;
    $scope.modInstrutor = modInstrutor;
    $scope.delInstrutor = delInstrutor;

    function getInstrutor () {
        instrutorService.read().then(response => {
            $scope.instrutores = response.data;
        })
    }

    function getAula () {
        aulaService.read().then(response => {
            $scope.aulas = response.data;
        })
    }

    function addInstrutor() {
        $scope.success.add = false;        
        if(!podeAdicionarInstrutor()) return;
        let instrutor = angular.copy($scope.instrutor);        

        if (instrutor.aula) {
            instrutor.aula = Object.keys(instrutor.aula); //converte valores
            instrutor.aula.sort(sortIdAulaByName);            
        } 

        instrutor.urlFoto = !instrutor.urlFoto ? "https://bs.simplusmedia.com/i/730/838/banana-beneficios.jpg" : instrutor.urlFoto;
        instrutor.dandoAula = !instrutor.dandoAula ? "Não" : "Sim";

        instrutorService.create(instrutor).then(() =>  getInstrutor());
        
        $scope.instrutor = {};
        $scope.success.add = true;       

        setTimeout(() => {$scope.success.add = false;}, 500);
    }

    function modInstrutor() {
        $scope.success.modify = false;          
        if(!podeModificarInstrutor()) return;

        let instrutor = angular.copy($scope.instrutor);

        instrutor.urlFoto = !instrutor.urlFoto ? 
            "https://bs.simplusmedia.com/i/730/838/banana-beneficios.jpg" : instrutor.urlFoto;

        if(instrutor.aula) {
            instrutor.aula = Object.keys(instrutor.aula);
            instrutor.aula.sort(sortIdAulaByName);  
        }
        
        instrutorService(instrutor).then(() =>  getInstrutor());

        $scope.instrutor = {};
        $scope.success.modify = true;

        setTimeout(() => {$scope.success.modify = false;}, 500);
    }

    function delInstrutor() {
        $scope.success.delete = false; 
        let instrutor = podeDeletarInstrutor();       
        if(!instrutor) return;

        instrutorService.delete(instrutor).then(() =>  getInstrutor());
        $scope.instrutor = {};
        $scope.success.delete = true;

        setTimeout(() => {$scope.success.delete = false;}, 500);

    }

    var acharInst = (instrutor) =>
        $scope.instrutores.find(i => i.id == instrutor.id);

    var procuraEmail = (instrutor) =>
        $scope.instrutores.find(i => i.email === instrutor.email);

    

    var sortIdAulaByName = (aula1, aula2) => {
        if($scope.aulas[aula1].nome.toLowerCase() > $scope.aulas[aula2].nome.toLowerCase()) return 1;
        if($scope.aulas[aula1].nome.toLowerCase() < $scope.aulas[aula2].nome.toLowerCase()) return -1;
        return 0;
    }

    var podeAdicionarInstrutor = () => {
        if ($scope.adicionaInstrutor.$invalid) return;
        let findEmail = procuraEmail($scope.instrutor);
        if (findEmail) return false; //email duplicado
        if($scope.instrutor.id) 
            return false; //usuario informou id. usuario nao pode informar

        return true;
    }

    var podeModificarInstrutor = () => {
        if ($scope.adicionaInstrutor.$invalid) return false;
        let find = acharInst($scope.instrutor);
        if (!find) return false;
        return true;     
    }

    var podeDeletarInstrutor = () => {
        let find = acharInst($scope.instrutor);        
        if (!find) return false;
        if(find.dandoAula === "Sim") return false;
        return find;
    }
}