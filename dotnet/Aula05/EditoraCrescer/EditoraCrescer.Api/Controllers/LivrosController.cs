using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Collections.Generic;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();
            return Ok(livros);
        }       
    
        public IHttpActionResult Post (Livro livro)
        {
            var mensagens = new List<string>();

            if (!livro.Validar(out mensagens))
                return BadRequest(string.Join("; ", mensagens.ToArray()));

            repositorio.Criar(livro);  
            return Ok("Livro adicionado.");
        }

        public IHttpActionResult Delete (int id)
        {
            repositorio.Deletar(id);
            return Ok("Livro deletado.");
        }
    }
}
