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
    
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();
        public IHttpActionResult Get ()
        {
            var autores = repositorio.Obter();
            return Ok(autores);
        }

        public IHttpActionResult Post(Autor autor)
        {
            var mensagens = new List<string>();

            if (!autor.Validar(out mensagens))
                return BadRequest(string.Join("; ", mensagens.ToArray()));

            repositorio.Criar(autor);
            return Ok("Autor adicionado.");
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok("Autor deletado.");
        }
    }
}
