using Crescer.LocadoraVeiculos.Models;
using Crescer.LocadoraVeiculosDominio;
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
    public class ClienteController : ApiController, IMensagens
    {
        ClienteRepositorio _clienteRepositorio = new ClienteRepositorio();
        public HttpResponseMessage MensagemErro(dynamic mensagens)
        {
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = mensagens });
        }

        public HttpResponseMessage MensagemSucesso(dynamic dados)
        {
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = dados });
        }

        [HttpGet, Autorizacao]
        public HttpResponseMessage Obter(ClienteModel clienteModel)
        {            
           var clienteRetorno = _clienteRepositorio.Obter(clienteModel.Cpf);
            if(clienteRetorno != null)
                return MensagemSucesso(clienteRetorno);

            return MensagemErro("Usuário não existente no sistema.");
        }

        [HttpPost]
        public HttpResponseMessage Criar(ClienteModel c)
        {
            Endereco endereco = new Endereco(c.Endereco.Numero, c.Endereco.Rua, c.Endereco.Cidade, c.Endereco.UF, c.Endereco.Bairro);
            Genero genero = (Genero) c.Genero;
            Cliente gerarCliente = new Cliente(c.NomeCompleto, endereco, c.Cpf, genero, c.DataNascimento);

            _clienteRepositorio.Cadastrar(gerarCliente);
            return null; //todo
        }
    }
}
