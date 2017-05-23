crudApp.factory("aulaService", aulaService);
crudApp.factory("instrutorService", instrutorService);

var url = "http://localhost:3000";

function aulaService ($http) {   

    var getAula = () => $http.get(url + "/aula");    

    var putAula = (aula) => $http.put(url + "/aula/" + aula.id, aula);

    var postAula = (aula) => $http.post(url + "/aula", aula);

    var deleteAula = (aula) => $http.delete(url + "/aula/" + aula.id, aula);

    return {
        create: postAula,        
        read: getAula,
        update: putAula,
        delete: deleteAula
    }
}

function instrutorService ($http) {

    var getInstrutor = () => $http.get(url + "/instrutor");

    var putInstrutor = () => $http.put(url + "/instrutor/" + instrutor.id, instrutor);

    var postInstrutor = () => $http.post(url + "/instrutor", instrutor);

    var deleteInstrutor = () => $http.delete(url + "/instrutor/" + instrutor.id, instrutor);

    return {
        create: postInstrutor,
        read:   getInstrutor,
        update: putInstrutor,
        delete: deleteInstrutor
    }
}