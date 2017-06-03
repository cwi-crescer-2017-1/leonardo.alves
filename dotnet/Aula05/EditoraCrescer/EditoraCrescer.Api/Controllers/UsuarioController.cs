using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    
    public class UsuarioController : ApiController
    {
        private HttpResponseMessage responder(bool exito, dynamic mensagens)
        {
            if (exito)
                return Request.CreateResponse(HttpStatusCode.OK, new { mensagens = mensagens });
            
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = mensagens });
        }

        UsuarioRepositorio _usuarioRepositorio = new UsuarioRepositorio();

        [HttpGet]
        public IHttpActionResult BuscarUsuario (string email)
        {
            _usuarioRepositorio.Buscar(email);
            return Ok();
        }

        [HttpPut]
        public IHttpActionResult AlterarUsuario (Usuario usuario)
        {
            _usuarioRepositorio.Alterar(usuario);
            return Ok();


        }

        [HttpPost]
        public HttpResponseMessage CadastrarUsuario (Usuario usuario)
        {
            if (_usuarioRepositorio.Buscar(usuario.Email) == null)
            {
                if (usuario.Validar())
                    _usuarioRepositorio.Cadastrar(usuario);

                else
                    return responder(false, usuario.Mensagens);
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
