using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio _revisorRepositorio = new RevisorRepositorio();

        public IHttpActionResult Get ()
        {
            return Ok(_revisorRepositorio.Obter());
        }

        public IHttpActionResult Post (Revisor revisor)
        {
            _revisorRepositorio.Adicionar(revisor);
            return Ok("Revisor adicionado");
        }

        public IHttpActionResult Delete (int id)
        {
            _revisorRepositorio.Deletar(id);
            return Ok("Revisor deletado");
        }
    }
}
