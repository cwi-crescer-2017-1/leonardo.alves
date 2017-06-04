using EditoraCrescer.Api.App_Start;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web;
using System.Web.Http;
using System.Web.Security;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Usuarios")]
    
    public class UsuarioController : ApiController
    {
        private HttpResponseMessage responder(bool exito, dynamic mensagens)
        {
            if (exito)
                return Request.CreateResponse(HttpStatusCode.OK, new { mensagens = mensagens });
            
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = mensagens });
        }

        UsuarioRepositorio _usuarioRepositorio = new UsuarioRepositorio();

        [HttpGet, Autorizacao]       
        public HttpResponseMessage BuscarUsuario ()
        {
            var usuario = new
            {
                email = Thread.CurrentPrincipal.Identity.Name,
                Permissoes = _usuarioRepositorio.pegarPermissoes()
            };
            var e = usuario.email;
            if (e == "") return Request.CreateResponse(HttpStatusCode.Forbidden, new { mensagem = "Informações incorretas." });
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = usuario});
        }

        [HttpPut]
        public IHttpActionResult AlterarUsuario (Usuario usuario)
        {
            _usuarioRepositorio.Alterar(usuario);
            return Ok();


        }

        
        [HttpPost]        
        public HttpResponseMessage CadastrarUsuario (Usuario Usuario)
        {
            if (_usuarioRepositorio.Buscar(Usuario.Email) == null)
            {
                if (Usuario.Validar())
                    _usuarioRepositorio.Cadastrar(Usuario);

                else
                    return responder(false, Usuario.Mensagens);
            }
            else
                return responder(false, "usuário já existe.");

            return responder(true, "criado com sucesso!");

        }
                
        protected override void Dispose(bool disposing)
        {
            _usuarioRepositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
