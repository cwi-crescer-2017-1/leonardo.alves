using Crescer.LocadoraVeiculosInfraestrutura.Repositorio;
using EditoraCrescer.Api.App_Start;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Crescer.LocadoraVeiculos.Controllers
{
    [RoutePrefix("api/pacotes")]
    [Autorizacao]
    public class PacoteController : ControllerBasico
    {
        PacoteRepositorio _pacoteRepositorio = new PacoteRepositorio();

        [HttpGet]
        [Route("")]
        public HttpResponseMessage ObterPacotes()
        {
            var pacotes = _pacoteRepositorio.ObterTodos();

            return MensagemSucesso(pacotes);
        }
    }
}
