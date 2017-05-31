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
            /*TODO: adicionar verificação para o argumento IdRevisor e IdAutor
                    caso um desses faltem, ele verificará se o Revisor/Autor 
                    foi adicionado, se sim, adicionará o autor/revisor, 
                    junto com o livro, senão retornar badRequest.
            */
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
