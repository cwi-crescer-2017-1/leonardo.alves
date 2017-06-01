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
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio _revisorRepositorio = new RevisorRepositorio();

        [HttpGet]
        public IHttpActionResult ObterRevisores ()
        {
            return Ok(_revisorRepositorio.ObterRevisores());
        }

        public IHttpActionResult Post (Revisor revisor)
        [HttpGet]
        public HttpResponseMessage ObterRevisor(int id)
        {
            var revisor = _revisorRepositorio.ObterRevisor(id);
            if (revisor == null)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { message = "Id inválido." });

            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }
            var mensagens = new List<string>();

            if (!revisor.Validar(out mensagens))
                return BadRequest(string.Join("; ", mensagens.ToArray()));

            _revisorRepositorio.Criar(revisor);
            return Ok("Revisor adicionado");
        }

        [HttpDelete]
        public HttpResponseMessage DeletarRevisor (int id)
        {
            var revisor = _revisorRepositorio.Deletar(id);
            if(revisor == null)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { message = "Id inválido" });

            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }

        protected override void Dispose(bool disposing)
        {
            _revisorRepositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
