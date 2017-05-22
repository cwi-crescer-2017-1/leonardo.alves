crudApp.directive("unicaAula", unicClassDirective);
crudApp.directive("unicoIns", unicInstDirective);
crudApp.directive("existeEssaAulaNome", notFoundClassByNameDirective);
crudApp.directive("instrutorDaAula", notAvailableInstDirective);
crudApp.directive("existeEssaAulaId", notFoundClassByIdDirective);
crudApp.directive("existeInstrutor", notFoundInstDirective);
crudApp.directive("aulaSendoUsada", inUseClassByIdDirective);
crudApp.directive("naoDuplicado", duplicatedEmailDirective);

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