using Crescer.LocadoraVeiculosDominio.Entidades;
using Crescer.LocadoraVeiculosInfraestrutura.Repositorio;
using EditoraCrescer.Api.App_Start;
using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace Crescer.LocadoraVeiculos.Controllers
{

    public class UsuarioController : ApiController, IMensagens
    {
        private UsuarioRepositorio _usuarioRepositorio = new UsuarioRepositorio();

        

        [HttpGet, Autorizacao]
        public HttpResponseMessage Obter()
        {
            var usuario = new
            {
                email = Thread.CurrentPrincipal.Identity.Name,
                Permissoes = _usuarioRepositorio.pegarPermissoes()
            };
            
            if (usuario.email == "") return MensagemErro("Informações inválidas.");

            return MensagemSucesso(usuario);
        }       

        [HttpPost]
        public HttpResponseMessage Criar(dynamic usuario)
        {
            if (_usuarioRepositorio.Obter(usuario.Email) == null)
            {
                if (usuario.Validar())
                    _usuarioRepositorio.Cadastrar(usuario);

                else
                    return MensagemErro(usuario.Mensagens);
            }
            else
                return MensagemErro("usuário já cadastrado.");

            return MensagemSucesso(usuario);
        }
      
        protected override void Dispose(bool disposing)
        {
            _usuarioRepositorio.Dispose();
            base.Dispose(disposing);
        }

        public HttpResponseMessage MensagemErro(dynamic mensagens)
        {
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = mensagens });
        }

        public HttpResponseMessage MensagemSucesso(dynamic dados)
        {
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = dados });
        }
    }
}
