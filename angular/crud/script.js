var crudApp = angular.module("crudApp", []);

crudApp.controller("aulaController", aulaController);
crudApp.controller("instrutorController", instrutorController);

crudApp.directive("unicaAula", unicClassDirective);
crudApp.directive("unicoIns", unicInstDirective);
crudApp.directive("existeEssaAulaNome", notFoundClassByNameDirective);
crudApp.directive("instrutorDaAula", notAvailableInstDirective);
crudApp.directive("existeEssaAulaId", notFoundClassByIdDirective);
crudApp.directive("existeInstrutor", notFoundInstDirective);
crudApp.directive("aulaSendoUsada", inUseClassByIdDirective);
crudApp.directive("naoDuplicado", duplicatedEmailDirective);


function aulaController($scope, $rootScope) {
    let idAulas = 0;
    $scope.success = {
        add: false,
        modify: false,
        delete: false
    };
    $rootScope.aulas = [{
        id: 0,
        nome: "Orientação à Objetos"
    }];
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

function instrutorController($scope, $rootScope) {
    $scope.success = {
        add: false,
        modify: false,
        delete: false
    };
    let idInstrutores = 0;
    $rootScope.instrutores = [{
        id: 0, // Gerado
        nome: 'Nome', // Obrigatório (length = min 3, max 20)
        sobrenome: 'Sobrenome', // Opcional (length = max 30)
        idade: 25, // Obrigatório (max 90)
        email: 'email@cwi.com.br', // Obrigatório (type=email)
        dandoAula: "Sim", // true ou false
        aula: [0, 4], // Opcional (array)
        urlFoto: 'https://bs.simplusmedia.com/i/730/838/banana-beneficios.jpg'
    }]
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


function unicClassDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function unicaAula(nome) {
                if (scope.aulas.find(a => a.nome === nome)) {
                    ctrl.$setValidity("unic", false);
                } else {
                    ctrl.$setValidity("unic", true);
                }
                return nome;
            }
            ctrl.$parsers.push(unicaAula);
        }
    }
}

function unicInstDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function unicoIns(nome) {
                if (scope.instrutores.find(a => a.nome === nome)) {
                    ctrl.$setValidity("unic", false);
                } else {
                    ctrl.$setValidity("unic", true);
                }
                return nome;
            }
            ctrl.$parsers.push(unicoIns);
        }
    }
}

function notFoundClassByNameDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function existeEssaAulaNome(nome) {
                if (ctrl.$isEmpty(nome)) {
                    ctrl.$setValidity("inexistentClass", true);
                } else if (scope.aulas.find(a => a.nome === nome)) {
                    ctrl.$setValidity("inexistentClass", true);
                } else {
                    ctrl.$setValidity("inexistentClass", false);
                }
                return nome;
            }
            ctrl.$parsers.push(existeEssaAulaNome);
        }
    }
}

function notFoundClassByIdDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function existeEssaAulaId(id) {

                if (ctrl.$isEmpty(id)) {
                    ctrl.$setValidity("existentClass", true);
                } else if (scope.aulas.find(a => a.id == id)) {
                    ctrl.$setValidity("existentClass", true);
                } else {
                    ctrl.$setValidity("existentClass", false);
                }
                return id;
            }
            ctrl.$parsers.push(existeEssaAulaId);
        }
    }
}

function inUseClassByIdDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function aulaEmUso(id) {                
                let aux = [];
                scope.instrutores.forEach(i => {
                    if(typeof i.aula.find(n => n == id) !== "undefined") {
                        aux.push(i.aula.find(n => n == id));                        
                    }
                });                
                if (ctrl.$isEmpty(id)) {
                    ctrl.$setValidity("inUseClass", true);
                } else if (typeof aux[0] === "undefined") {
                    ctrl.$setValidity("inUseClass", true);
                } else {
                    ctrl.$setValidity("inUseClass", false);
                }



                return id;
            }
            ctrl.$parsers.push(aulaEmUso);
        }
    }
}

function notFoundInstDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function existeEsseInst(id) {
                if(ctrl.$isEmpty(id)){
                    ctrl.$setValidity("notFoundInstructor", true);                    
                } else if (scope.instrutores.find(i => i.id == id)) {                    
                    ctrl.$setValidity("notFoundInstructor", true);
                } else {
                    ctrl.$setValidity("notFoundInstructor", false);
                }

                return id;
            }
            ctrl.$parsers.push(existeEsseInst);
        }
    }
}

function notAvailableInstDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function instrutorDaAula(id) {
                console.log(id);
                if (ctrl.$isEmpty(id)) {
                    ctrl.$setValidity("notAvailableInstructor", true);
                } else if (ctrl.$isEmpty(scope.instrutores[id])) {
                    ctrl.$setValidity("notAvailableInstructor", true);
                } else if(scope.instrutores[id].dandoAula === "Sim") {
                    ctrl.$setValidity("notAvailableInstructor", false);
                }
                return id;
            }
            ctrl.$parsers.push(instrutorDaAula);
        }
    }
}

function duplicatedEmailDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function procurarEmail(email) {
                if (scope.instrutores.find(i => i.email === email)) {
                    ctrl.$setValidity("duplicatedEmail", false);
                } else {
                    ctrl.$setValidity("duplicatedEmail", true);
                }
                return email;
            }
            ctrl.$parsers.push(procurarEmail);
        }
    }
}