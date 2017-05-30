using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidosController : ApiController
    {
        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();
        ItemPedidoRepositorio _itemPedidoRepositorio = new ItemPedidoRepositorio();

        public IHttpActionResult Get ()
        {
            var pedidos = _pedidoRepositorio.Listar();

            return Ok(pedidos);
        }

        public IHttpActionResult Get(int id)
        {
            var pedidos = _pedidoRepositorio.Obter(id);

            return Ok(pedidos);
        }

        public IHttpActionResult Post (Pedido pedido)
        {
            _pedidoRepositorio.Criar(pedido);
            _itemPedidoRepositorio.Criar(pedido);
            return Ok(pedido);
        }

        public IHttpActionResult Put (Pedido pedido)
        {
            _pedidoRepositorio.Alterar(pedido);
            _itemPedidoRepositorio.Alterar(pedido);
            return Ok(pedido);
        }

        public IHttpActionResult Delete (int id)
        {
            _itemPedidoRepositorio.Excluir(id);
            _pedidoRepositorio.Excluir(id);

            return Ok("Excluido com sucesso");
        }

    }
}
