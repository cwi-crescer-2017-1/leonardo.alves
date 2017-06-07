using Crescer.LocadoraVeiculosInfraestrutura.Repositorio;
using EditoraCrescer.Api.App_Start;
using System.Collections.Generic;
using System.Net.Http;
using System.Web.Http;

namespace Crescer.LocadoraVeiculos.Controllers
{
    [RoutePrefix("api/opcionais")]
    [Autorizacao]
    public class OpcionalController : ControllerBasico
    {
        OpcionalRepositorio _opcionalRepositorio = new OpcionalRepositorio();

       [HttpGet]
       [Route("")]
       public HttpResponseMessage ObterOpcionais ()
        {
            var opcionais = _opcionalRepositorio.ObterTodos();

            return MensagemSucesso(opcionais);
        }


    }
}
