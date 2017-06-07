using Crescer.LocadoraVeiculos.Models;
using Crescer.LocadoraVeiculosDominio.Exceções;
using Crescer.LocadoraVeiculosInfraestrutura.Repositorio;
using EditoraCrescer.Api.App_Start;
using System;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Crescer.LocadoraVeiculos.Controllers
{
    [RoutePrefix("api/pedidos")]   
    public class PedidoController : ApiController, IMensagens
    {
        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();

        public HttpResponseMessage MensagemErro(dynamic mensagens)
        {
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = mensagens });
        }

        public HttpResponseMessage MensagemSucesso(dynamic dados)
        {
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = dados });
        }            

        [HttpGet, Autorizacao]
        public HttpResponseMessage ObterPedidoPendente (string cpf)
        {
            var pedido = _pedidoRepositorio.ObterPedido(cpf);

            if (pedido == null) return MensagemErro("Não há pedidos pendentes para esse CPF");

            return MensagemSucesso(pedido);
        }

        [HttpGet, Autorizacao(Roles ="Gerente")]
        public HttpResponseMessage ObterRelatorio (DateTime data)
        {
           var pedidosMensais = _pedidoRepositorio.ObterPedidosMensais(data);

            if (pedidosMensais == null) return MensagemErro("Data inválida.");

            return MensagemSucesso(pedidosMensais);
        }

        [HttpGet]
        [Route("")]
        public HttpResponseMessage ObterAtrasos ()
        {
            var pedidosAtrasados = _pedidoRepositorio.ObterPedidosAtrasados();
            if (pedidosAtrasados == null) return MensagemErro("Não há pedidos atrasados.");

            return MensagemSucesso(pedidosAtrasados);
        }

        [HttpPost]
        [Route("")]        
        public HttpResponseMessage CriarPedido (CriarPedidoModel pedido)
        {
            try
            {
                _pedidoRepositorio.GerarPedido(pedido.IdCliente, pedido.IdVeiculo, pedido.IdPacote, pedido.IdOpcional, pedido.DataEntrega);
                return MensagemSucesso("Pedido criado com sucesso.");
            }
            catch (PedidoInvalidoException e)
            {
                return MensagemErro(e.Message);
            }
        }  

        [HttpPost]
        public HttpResponseMessage Devolver ()
        {
            throw new NotImplementedException();
        }
    }
}

