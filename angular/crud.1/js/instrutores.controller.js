crudApp.controller("instrutorController", instrutorController);


function instrutorController($scope) {
    $scope.success = {
        add: false,
        modify: false,
        delete: false
    };
    let idInstrutores = 0;   
    $scope.addInstrutor = addInstrutor;
    $scope.modInstrutor = modInstrutor;
    $scope.delInstrutor = delInstrutor;

    function addInstrutor() {
        $scope.success.add = false;
        if ($scope.adicionaInstrutor.$invalid) return;
        let findEmail = procuraEmail($scope.instrutor);
        if (findEmail) return; //email duplicado
        if($scope.instrutor.id) return; //usuario informou id. usuario nao pode informar
        let instrutor = angular.copy($scope.instrutor);
        instrutor.id = ++idInstrutores;

        if (instrutor.aula) {
            instrutor.aula = Object.keys(instrutor.aula);
            instrutor.aula.sort(sortIdAulaByName);            
        } 
        instrutor.urlFoto = !instrutor.urlFoto ? "https://bs.simplusmedia.com/i/730/838/banana-beneficios.jpg" : instrutor.urlFoto;
        instrutor.dandoAula = !instrutor.dandoAula ? "Não" : "Sim";


        $scope.instrutores.push(instrutor);
        $scope.instrutor = {};
        $scope.success.add = true;       

        setTimeout(() => {$scope.success.add = false;}, 500);
    }

    function modInstrutor() {
        $scope.success.modify = false;
        let find = acharInst($scope.instrutor);

        if (!find) return;        

        let instrutor = angular.copy($scope.instrutor);
        instrutor.urlFoto = !instrutor.urlFoto ? "https://bs.simplusmedia.com/i/730/838/banana-beneficios.jpg" : instrutor.urlFoto;

        if(instrutor.aula) {
            instrutor.aula = Object.keys(instrutor.aula);
            instrutor.aula.sort(sortIdAulaByName);  
        }

        $scope.instrutores[find.id] = instrutor;

        $scope.instrutor = {};
        $scope.success.modify = true;

        setTimeout(() => {$scope.success.modify = false;}, 500);
    }

    function delInstrutor() {
        $scope.success.delete = false;
        let find = acharInst($scope.instrutor);        
        if (!find) return;
        if($scope.instrutores[find.id].dandoAula === "Sim") return;
       
        $scope.instrutores[find.id] = {};
        $scope.instrutor = {};
        $scope.success.delete = true;

        setTimeout(() => {$scope.success.delete = false;}, 500);

    }

    let acharInst = (instrutor) =>
        $scope.instrutores.find(i => i.id == instrutor.id);

    let procuraEmail = (instrutor) =>
        $scope.instrutores.find(i => i.email === instrutor.email);

    function sortIdAulaByName (aula1, aula2) {
        if($scope.aulas[aula1].nome.toLowerCase() > $scope.aulas[aula2].nome.toLowerCase()) return 1;
        if($scope.aulas[aula1].nome.toLowerCase() > $scope.aulas[aula2].nome.toLowerCase()) return -1;
        return 0;
    }
}