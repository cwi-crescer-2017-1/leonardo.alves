using EditoraCrescer.Api.App_Start;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
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
        public HttpResponseMessage ObterLivroPorIsbn (int isbn)
        {
            var livro = _repositorioLivro.ObterPorIsbn(isbn);
            if (livro != null)
                return Request.CreateResponse(HttpStatusCode.OK, new { data = livro });
                    
            else return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = "ISBN não encontrado nos registros." });
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

        [HttpPut, Autorizacao]
        [Route("{isbn:int}")]
        public IHttpActionResult AtualizarLivro (int isbn, Livro livro)
        {
            List<string> mensagens = new List<string>();
            
            if(_repositorioLivro.AtualizarLivro(isbn, livro, out mensagens))           
                return Ok(new { data = livro });
            else                           
                return BadRequest(string.Join("; ", mensagens.ToArray()));
        }
    
        [HttpPost, Autorizacao]
        public HttpResponseMessage InserirLivro (Livro livro)
        {
            var mensagem = new List<string>();

            if (!livro.Validar(out mensagem))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = mensagem });
                   

            _repositorioLivro.Criar(livro);  

            return Request.CreateResponse(HttpStatusCode.OK, new { dados = "Sucesso." });
        }

        [HttpDelete]
        [Route("{id:int}")]
        public HttpResponseMessage Delete(int id)
        {
            _repositorioLivro.Deletar(id);

            return Request.CreateResponse(HttpStatusCode.OK, new { dados = "deletado" });

        }


        protected override void Dispose(bool disposing)
        {
            _repositorioLivro.Dispose();
            base.Dispose(disposing);
        }
    }
}
