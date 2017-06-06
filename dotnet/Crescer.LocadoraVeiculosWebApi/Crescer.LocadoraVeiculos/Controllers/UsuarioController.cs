using Crescer.LocadoraVeiculosDominio.Entidades;
using Crescer.LocadoraVeiculosInfraestrutura.Repositorio;
using EditoraCrescer.Api.App_Start;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace Crescer.LocadoraVeiculos.Controllers
{

    public class UsuarioController : ApiController, IMensagens
    {
        private UsuarioRepositorio _usuarioRepositorio = new UsuarioRepositorio();

        public HttpResponseMessage MensagemErro(dynamic mensagens)
        {
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = mensagens });
        }

        public HttpResponseMessage MensagemSucesso(dynamic dados)
        {
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = dados });
        }

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
            
        protected override void Dispose(bool disposing)
        {
            _usuarioRepositorio.Dispose();
            base.Dispose(disposing);
        }        
    }
}
