using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
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
