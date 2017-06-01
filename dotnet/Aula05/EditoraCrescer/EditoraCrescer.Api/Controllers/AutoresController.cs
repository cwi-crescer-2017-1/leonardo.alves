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
    [RoutePrefix("api/Autores")]

    public class AutoresController : ApiController
    {
        private AutorRepositorio _autorRepositorio = new AutorRepositorio();

        [HttpGet]
        public IHttpActionResult ObterAutores ()
        {
            var autores = _autorRepositorio.ObterAutores();
            return Ok(new { data = autores });
        }

        [HttpGet]        
        public HttpResponseMessage ObterAutor(int id)
        {
            var autor = _autorRepositorio.ObterAutor(id);

            if (autor == null)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { message = "O id informado é inválido" });

            return Request.CreateResponse(HttpStatusCode.OK, new { data = autor });
        }

        [HttpGet]
        [Route("{id}/livros")]
        public HttpResponseMessage ObterLivrosAutor(int id)
        {
            var livros = _autorRepositorio.ObterLivrosAutor(id);

            if (livros.Count < 1)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { message = "O id informado é inválido" });

            return Request.CreateResponse(HttpStatusCode.OK, new { data = livros });
        }

        [HttpPost]
        public HttpResponseMessage InserirAutor(Autor autor)
        {
            var mensagens = new List<string>();

            if (!autor.Validar(out mensagens))
                return 
                    Request.CreateResponse(HttpStatusCode.BadRequest, new { message = mensagens });
                    

            _autorRepositorio.Criar(autor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = autor });
                
        }

        public IHttpActionResult Delete(int id)
        {
            _autorRepositorio.Deletar(id);
            return Ok("Autor deletado.");
        }

        protected override void Dispose(bool disposing)
        {
            _autorRepositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
