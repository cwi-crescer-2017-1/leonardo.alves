
Noty.overrideDefaults({
    layout: 'topRight',
    theme: 'metroui',
    timeout: 2000,
    progressBar: true,
    closeWith: [],
    animation: {
        open: 'noty_effects_open',
        close: 'noty_effects_close'
    },
    buttons: []
});

var publicacaoPostada = new Noty({
                        text: 'Publicação foi postada!',
                        type: 'success'
                    });
                    
var erroGenerico = new Noty({                    
                    type: 'error'
                });

var recusarAmizade = new Noty({
                    text: 'Solicitação recusada.'                    
                });

var aceitarAmizade = new Noty({
                    text: 'Solicitação aceita.'                    
                });

                
var seuPerfil = new Noty({
                    text: 'Esse é você :p.',
                    type: 'information'                   
                });

var solicitacaoAmizade = new Noty({
                    text: 'Solicitação enviada.'                    
                });     

var contaCriada = new Noty({
                    text: 'Conta criada com sucesso',
                    type: 'success'
                });


var curtirPost = new Noty({
                    text: 'Curtido com sucesso',
                    type: 'success'
                });

var editarConta = new Noty({
    text: 'Edições salvas.',
    type: 'success'
});

var boasVindas = new Noty({
                    text:'Seja bem-vindo novamente!',                   
                });