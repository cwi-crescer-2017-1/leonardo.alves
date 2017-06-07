using Crescer.LocadoraVeiculos.Models;
using Crescer.LocadoraVeiculosDominio.Entidades;
using Crescer.LocadoraVeiculosInfraestrutura.Repositorio;
using EditoraCrescer.Api.App_Start;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace Crescer.LocadoraVeiculos.Controllers
{
    [RoutePrefix("api/usuarios")]
    public class UsuarioController : ControllerBasico
    {
        private UsuarioRepositorio _usuarioRepositorio = new UsuarioRepositorio();        

        [HttpGet, Autorizacao]
        [Route("")]
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
        [Route("")]
        public HttpResponseMessage Criar (UsuarioModel usuarioModel)
        {
            if (_usuarioRepositorio.Obter(usuarioModel.Email) == null)
            {
                var usuario = new Usuario(usuarioModel.Email, usuarioModel.Senha);
                if (usuario.Validar())
                    _usuarioRepositorio.Cadastrar(usuario);
                else
                    return MensagemErro("Verifique os dados no usuário.");
            }
            return MensagemErro("Usuario cadastrado no sistema");
        }     
            
        protected override void Dispose(bool disposing)
        {
            _usuarioRepositorio.Dispose();
            base.Dispose(disposing);
        }        
    }
}
