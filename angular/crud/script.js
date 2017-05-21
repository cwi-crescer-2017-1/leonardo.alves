var crudApp = angular.module("crudApp", []);

crudApp.controller("aulaController", aulaController);
crudApp.controller("instrutorController", instrutorController);

crudApp.directive("unicaAula", unicClassDirective);
crudApp.directive("unicoIns", unicInstDirective);
crudApp.directive("existeEssaAulaN", notFoundClassByNameDirective);
crudApp.directive("instrutorDaAula", notAvailableInstDirective);
crudApp.directive("existeEssaAulaI", notFoundClassByIdDirective);
crudApp.directive("existeInstrutor", notFoundInstDirective);
crudApp.directive("aulaEmUso", inUseClassByIdDirective);
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
        if($scope.adicionaAula.$invalid) return;
        if (find || typeof $scope.aula.nome === "undefined") return;

        let aula = angular.copy($scope.aula);
        aula.id = ++idAulas;
        $scope.aulas.push(aula);
        $scope.aula = {};
        $scope.success.add = true;
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

        function aulaDada() {
            $scope.instrutores.forEach(i => {
                aulaDadaAux.push(i.aula.find(n => n === $scope.idAula));
            })
        }
    }
}

function instrutorController($scope, $rootScope) {
    $scope.success = {
        add: false,
        modify: false
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
        if($scope.adicionaInstrutor.$invalid) return;
        let findEmail = procuraEmail($scope.instrutor);
        if(findEmail) return; //email duplicado
        let instrutor = angular.copy($scope.instrutor);
        instrutor.id = ++idInstrutores;

        if(instrutor.aula)  instrutor.aula = Object.keys(instrutor.aula);
        instrutor.urlFoto = !instrutor.urlFoto ? "https://bs.simplusmedia.com/i/730/838/banana-beneficios.jpg" : instrutor.urlFoto;
        instrutor.dandoAula = !instrutor.dandoAula ? "Não" : "Sim";

        $scope.instrutores.push(instrutor);
        $scope.instrutor = {};
        $scope.success.add = true;        
    }

    function modInstrutor() {
        $scope.success.modify = false;
        let find = acharInst($scope.instrutor);

        if (!find) return;
        if($scope.adicionaInstrutor.$invalid) return;

        let instrutor = angular.copy($scope.instrutor);
        instrutor = !instrutor.urlFoto ? "https://bs.simplusmedia.com/i/730/838/banana-beneficios.jpg" : instrutor.urlFoto;
        
        $scope.instrutores[find.id] = instrutor;
        
        $scope.instrutor = {};
        $scope.success.modify = true;
    }

    function delInstrutor() {
        $scope.success.del = false;
        let find = acharInst($scope.instrutor);
        let isUndefined = typeof find.aula;
        if (!find) return;
        if (isUndefined !=="undefined") return;
        if($scope.adicionaInstrutor.$invalid) return;
        $scope.instrutores[find.id] = {};
        $scope.instrutor = {};

    }

    let acharInst = (instrutor) =>
        $scope.instrutores.find(i => i.id == instrutor.id);

    let procuraEmail = (instrutor) =>
        $scope.instrutores.find(i => i.email === instrutor.email);
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
            function existeEssaAula(nome) {
                if (scope.aulas.find(a => a.nome === nome)) {                    
                    ctrl.$setValidity("inexistentClass", false);
                } else {
                    ctrl.$setValidity("inexistentClass", true);
                }                
                return nome;
            }
            ctrl.$parsers.push(existeEssaAula);
        }
    }
}

function notFoundClassByIdDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {

            function existeEssaAula(id) {
                if (scope.aulas.find(a => a.id === id)) {
                    ctrl.$setValidity("existentClass", true);
                } else {
                    ctrl.$setValidity("existentClass", false);
                }
                return id;
            }
            ctrl.$parsers.push(existeEssaAula);
        }
    }
}

function inUseClassByIdDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {


            function existeAula(id) {
                let aux = [];
                scope.instrutores.forEach(i =>
                    aux.push(i.aula.find(n => n === id)));
                if(ctrl.$isEmpty(id)) {
                ctrl.$setValidity("inUseClass", false);
                } else if (aux.length) {
                    ctrl.$setValidity("inUseClass", false);
                } else {
                    ctrl.$setValidity("inUseClass", true);
                }
                return id;
            }
            ctrl.$parsers.push(existeAula);
        }
    }
}

function notFoundInstDirective() {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function existeEsseInst(id) {
                if (scope.instrutores.find(i => i.id == id)) {
                    console.log(id);
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

function notAvailableInstDirective () {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function instrutorDaAula (id) {
                if(scope.instrutores[id]){
                    let isUndefined = typeof scope.instrutores[id].aula;
                    if(isUndefined !== "undefined" || scope.instrutores[id].aula.length > 0){                                                       
                        ctrl.$setValidity("notAvailableInstructor", false);
                    } else {
                        ctrl.$setValidity("notAvailableInstructor", true);
                    }                    
                }                  
                return id;
            }
            ctrl.$parsers.push(instrutorDaAula);
        }
    }
}

function duplicatedEmailDirective () {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function procurarEmail (email) {
                if(scope.instrutores.find(i => i.email === email)){
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

