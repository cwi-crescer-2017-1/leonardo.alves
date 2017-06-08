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
    [RoutePrefix("api/clientes")]
    public class ClienteController : ControllerBasico
    {
        ClienteRepositorio _clienteRepositorio = new ClienteRepositorio();

        [Route("")]
        private Endereco GerarEndereco (ClienteModel c)
        {
            return new Endereco
            (
                c.Endereco.Numero, 
                c.Endereco.Rua, 
                c.Endereco.Cidade, 
                c.Endereco.UF,
                c.Endereco.Bairro
            );
        }
       
        [HttpGet, Autorizacao]
        public HttpResponseMessage Obter(string cpf)
        {            
           var clienteRetorno = _clienteRepositorio.Obter(cpf);
            if(clienteRetorno != null)
                return MensagemSucesso(clienteRetorno);

            return MensagemErro("Cliente não existente no sistema.");
        }

        [HttpPost]
        [Route("")]
        public HttpResponseMessage Criar(ClienteModel c)
        {
            Genero genero = (Genero) c.Genero;
            Endereco endereco = GerarEndereco(c);

            if (endereco.Validar())
            {
                Cliente cliente =
                    new Cliente(c.NomeCompleto, endereco, c.Cpf, genero, c.DataNascimento);

                if (!cliente.Validar())
                    return MensagemErro("As informações no cliente foram informadas incorretamente. Por favor cheque novamente.");

                _clienteRepositorio.Cadastrar(cliente);

                return MensagemSucesso(cliente);
            }
            else
                return MensagemErro("O endereço informado é inválido. Verifique novamente as informações.");
        }
            
    }
}
