using Crescer.LocadoraVeiculos.Models;
using Crescer.LocadoraVeiculosDominio.Entidades;
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
    public class PedidoController : ControllerBasico
    {
        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();

        [HttpGet, Autorizacao]
        [Route("pendente")]
        public HttpResponseMessage ObterPedidoPendente (string cpf)
        {
            var pedido = _pedidoRepositorio.ObterPedido(cpf);

            if (pedido == null) return MensagemErro("Não há pedidos pendentes para esse CPF");

            return MensagemSucesso(pedido);
        }

        [HttpGet]
        [Route("relatorio")]        
        public HttpResponseMessage ObterRelatorio (string data)
        {
           var pedidosMensais = _pedidoRepositorio.ObterPedidosMensais(DateTime.Parse(data));

            if (pedidosMensais.Count == 0) return MensagemErro("Data inválida.");

            return MensagemSucesso(pedidosMensais);
        }

        [HttpGet]
        [Route("atrasos")]
        public HttpResponseMessage ObterAtrasos ()
        {
            var pedidosAtrasados = _pedidoRepositorio.ObterPedidosAtrasados();
            if (pedidosAtrasados.Count == 0) return MensagemErro("Não há pedidos atrasados.");

            return MensagemSucesso(pedidosAtrasados);
        }

        [HttpPost]
        [Route(""), Autorizacao]        
        public HttpResponseMessage CriarPedido (CriarPedidoModel pedido)
        {
            try
            {
                _pedidoRepositorio.GerarPedido(pedido.Cpf, pedido.IdVeiculo, pedido.IdPacote, pedido.IdOpcional, pedido.DataEntrega);
                return MensagemSucesso("Pedido criado com sucesso.");
            }
            catch (PedidoInvalidoException e)
            {
                return MensagemErro(e.Message);
            }
            catch (CombinacoesImpossiveisException e)
            {
                return MensagemErro(e.Message);
            }
        }  

        [HttpPut]
        [Route("devolver"), Autorizacao]
        public HttpResponseMessage Devolver (int id)
        {            
            _pedidoRepositorio.Devolver(id);
            return MensagemSucesso("Veiculo devolvido com sucesso.");
        }
    }
}

