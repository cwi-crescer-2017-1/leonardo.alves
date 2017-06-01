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

        [HttpGet]
        public HttpResponseMessage ObterRevisor(int id)
        {
            var revisor = _revisorRepositorio.ObterRevisor(id);
            if (revisor == null)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { message = "Id inválido." });

            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }

        [HttpPost]
        public HttpResponseMessage AdicionarRevisor (Revisor revisor)
        {
            var mensagens = new List<string>();

            if (!revisor.Validar(out mensagens))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { message = mensagens });                    

            _revisorRepositorio.Criar(revisor);

            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });                
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
