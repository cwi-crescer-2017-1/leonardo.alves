angular.module('locadoraCrescer').controller("pedidoController", pedidoController);

function pedidoController($scope, authService, pedidoService, opcionalService, pacoteService, veiculoService, clienteService) {
    $scope.precoTotal = "Gere o pedido para visualizar o preço total.";      
    $scope.gerarPedido = gerarPedido;
    $scope.reservar = reservar;
    $scope.getPendente = getPendente;
    $scope.devolverPedido = devolverPedido;

    getOpcionais();
    getPacotes();
    getVeiculos();  

    function gerarPedido() {

        let precoVeiculo = $scope.pedido.Veiculo.PrecoDiaria;
        let precoPacote = $scope.pedido.Pacote.PrecoDiaria;

        if(typeof precoPacote == "undefined") precoPacote = 0;

        let precoOpcionais = $scope.opcionais.map(p => {            
            if(getIdOpcionais().includes(p.Id)) 
                return p.Preco;
             else 
                return 0;            
        }).reduce((a,b) => a+b);

        let diferencaDeDias = moment($scope.pedido.dataEntrega).diff(moment(), "days");

        $scope.precoTotal = diferencaDeDias * (precoVeiculo  + precoPacote + precoOpcionais);
    }  

    function reservar () {
        var pedidoRetorno = {};

        pedidoRetorno.Cpf  = $scope.pedido.cliente.cpf; 
        pedidoRetorno.IdOpcional = getIdOpcionais();
        pedidoRetorno.IdVeiculo = $scope.pedido.Veiculo.Id;
        pedidoRetorno.IdPacote = $scope.pedido.Pacote.Id;
        pedidoRetorno.DataEntrega = $scope.pedido.dataEntrega;

        pedidoService.criarPedido(pedidoRetorno)
        .then(response => {
            alert("Sucesso");
        }, fail => {
            alert(fail.data.mensagens);
        })
    }

    function devolverPedido () {
        pedidoService.devolverPedido($scope.pendente.Id)
            .then(response => {
                alert(response.data.dados);
            }, fail => {
                alert(response.data.mensagens);
            })
        
    }

    function getOpcionais() {
        opcionalService.getOpcionais()
            .then(response => {
                $scope.opcionais = response.data.dados;                
            }, fail => {
                console.log(fail.data.mensagens);
            });
    }

    function getPacotes() {
        pacoteService.getPacotes()
            .then(response => {
                $scope.pacotes = response.data.dados;
            }, fail => {
                console.log(fail.data.mensagens);
            });
    }

    function getVeiculos() {
        veiculoService.getVeiculos()
            .then(response => {
                $scope.veiculos = response.data.dados;
            }, fail => {
                console.log(fail.data.mensagens);
            });
    }   

    function getIdOpcionais(){
        let idOpcionais = [];
        for(x in $scope.pedido.idOpcional){
            if($scope.pedido.idOpcional[x] === true)
                idOpcionais.push(Number(x));
        }
        return idOpcionais;
    }

    function getPendente(cpf) {
        pedidoService.getPedidoPendente(cpf)
            .then(response => {
                $scope.pendente = pedidoService.gerarPedidoComValor(response.data.dados);
                $scope.pendente.atraso = 
                    moment($scope.pendente.DataEntregaPrevista).isBefore(moment());
                
            }, fail => {
                alert(fail.data.mensagens);
            });
    }   
}