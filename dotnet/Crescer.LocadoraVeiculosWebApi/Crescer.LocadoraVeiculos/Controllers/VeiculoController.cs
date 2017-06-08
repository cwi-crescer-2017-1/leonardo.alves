using Crescer.LocadoraVeiculosDominio.Entidades;
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
    [RoutePrefix("api/veiculos")]
    [Autorizacao]
    public class VeiculoController : ControllerBasico
    {
        VeiculoRepositorio _veiculoRepositorio = new VeiculoRepositorio();        

        [HttpGet]
        [Route("")]
        public HttpResponseMessage ObterVeiculos ()
        {
           List<Veiculo> veiculos = _veiculoRepositorio.ObterTodos();

            return MensagemSucesso(veiculos);
        }
    }
}
