using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Collections.Generic;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Livros")]

    public class LivrosController : ApiController
    {
        private LivroRepositorio _repositorioLivro = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult ObterLivros(int pular, int pegar)
        {
            var livros = _repositorioLivro.Obter(pular, pegar);
            return Ok(new { data = livros });
        }

        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult ObterLivroPorIsbn (int isbn)
        {
            var livro = _repositorioLivro.ObterPorIsbn(isbn);
            return Ok(new { data = livro });
        }

        [HttpGet]
        [Route("{genero}")]
        public IHttpActionResult ObterLivrosPorGenero (string genero)
        {
            var livros = _repositorioLivro.ObterPorGenero(genero);
            return Ok(new { data = livros });
        }

        [HttpGet]
        [Route("lancamentos")]
        public IHttpActionResult ObterLivrosPorLancamento()
        {
            var livros = _repositorioLivro.ObterPorLancamento();
            return Ok(new { data = livros });
        }

        [HttpPut]
        [Route("{isbn:int}")]
        public IHttpActionResult AtualizarLivro (int isbn, Livro livro)
        {
            List<string> mensagens = new List<string>();
            
            if(_repositorioLivro.AtualizarLivro(isbn, livro, out mensagens))           
                return Ok(new { data = livro });
            else                           
                return BadRequest(string.Join("; ", mensagens.ToArray()));
        }
    
        [HttpPost]
        public IHttpActionResult InserirLivro (Livro livro)
        {
            var mensagens = new List<string>();

            if (!livro.Validar(out mensagens))
                return BadRequest(string.Join("; ", mensagens.ToArray()));

            _repositorioLivro.Criar(livro);  

            return Ok(new { data = livro });
        }

        [HttpDelete]
        public IHttpActionResult DeletarLivro (int id)
        {
            _repositorioLivro.Deletar(id);
            return Ok("Deletado");
        }


        protected override void Dispose(bool disposing)
        {
            _repositorioLivro.Dispose();
            base.Dispose(disposing);
        }
    }
}
