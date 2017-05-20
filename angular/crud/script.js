var crudApp = angular.module("crudApp", []);

crudApp.controller("aulaController", aulaController);
crudApp.controller("instrutorController", instrutorController);
crudApp.directive("unicaAula", unicDirective);
crudApp.directive("existeEssaAula", notFoundDirective);

function aulaController ($scope, $rootScope) {
    let idAulas = 0;
    $scope.success = {add: false, modify: false};
    $rootScope.aulas = [
        {
            id: 0,
            nome: "Orientação à Objetos"
        }
        ];
    $scope.addAula = addAula;
    $scope.modAula = modAula;

    let procuraNome  = (nome) =>
        $scope.aulas.find(a => a.nome === nome);
    
        
    function addAula() { 
        $scope.success.add = false;       
        let find = procuraNome($scope.aula.nome);
       
        if(find || typeof  $scope.aula.nome === "undefined") return;

        let aula = angular.copy($scope.aula);
        aula.id = ++idAulas;
        $scope.aulas.push(aula);
        $scope.aula = {};    
        $scope.success.add = true;     
    }

    function modAula() {
        $scope.success.modify = false;
        let find = procuraNome($scope.mod.acha);

        if(!find || typeof $scope.mod.acha === "undefined" || typeof $scope.mod.novo === "undefined") return;

        let novaAula = angular.copy($scope.mod);       
        $scope.aulas[find.id].nome = $scope.mod.novo;
        $scope.mod = {};
        $scope.success.modify = true;
    }   
}

function instrutorController ($scope, $rootScope) {
    let idInstrutores = 0;
    $rootScope.instrutores = [
        {
            id: 0,                            // Gerado
            nome: 'Nome',                     // Obrigatório (length = min 3, max 20)
            sobrenome: 'Sobrenome',           // Opcional (length = max 30)
            idade: 25,                        // Obrigatório (max 90)
            email: 'email@cwi.com.br',        // Obrigatório (type=email)
            dandoAula: true,                  // true ou false
            aula: [1, 4],                     // Opcional (array)
            urlFoto: 'http://foto.com/3.png'
        }
    ]
    $scope.addInstrutor = addInstrutor;
    function addInstrutor () {
        console.log($scope.instrutor);
    }
}

function unicDirective () {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function unicaAula(nome) {
                if(scope.aulas.find(a => a.nome === nome)) {
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

function notFoundDirective () {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ctrl) {
            function existeEssaAula (nome) {                
                if(scope.aulas.find(a => a.nome === nome)) {                    
                    ctrl.$setValidity("inexistentClass", true);
                } else {
                    ctrl.$setValidity("inexistentClass", false);
                }
                return nome;
            }           
            ctrl.$parsers.push(existeEssaAula);
        }
    }
}