using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{

    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();
        public dynamic Obter(int pular, int pegar)
        {
            return contexto.Livros   
                .OrderByDescending(x => x.Isbn)             
                .Select(resumo)
                .Skip(pular)
                .Take(pegar)
                .ToList();
        }

        public Livro ObterPorIsbn (int isbn)
        {
            return contexto.Livros.Include(x => x.Autor).FirstOrDefault(l => l.Isbn == isbn);
        }

        public List<Livro> ObterPublicados(int pular, int pegar)
        {
            return contexto.Livros
                .Where(x => x.DataPublicacao != null)
                .Include(x => x.Autor)
                .OrderByDescending(x => x.DataPublicacao)
                .Skip(pular)
                .Take(pegar)
                .ToList();
        }

        public dynamic ObterPorGenero(string genero)
        {
            return contexto.Livros
                .Where(l => l.Genero.Contains(genero))
                .Select(resumo)
                .ToList();
        }

        public object ObterPorLancamento()
        {
            return contexto.Livros
                 .Where(l => DbFunctions.DiffDays(l.DataPublicacao, DateTime.Now) <= 7)
                 .Select(resumo)
                 .ToList();
        }

        public void Criar (Livro livro)
        {
            procurarPorAutor(livro);                        

            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        

        public bool AtualizarLivro (int isbn, Livro livro, out List<string> mensagens)
        {           
            mensagens = new List<string>();

            verificarDadosAtualizacao(isbn, livro, mensagens);

            if (mensagens.Count > 0) return false;

            procurarPorRevisor(livro);
            procurarPorAutor(livro);

            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return true;
        }        

        public void Deletar (int id)
        {
            var livro = contexto.Livros.FirstOrDefault(l => l.Isbn == id);
            contexto.Livros.Remove(livro) ;
            contexto.SaveChanges();
        }

       

        private int compararData (DateTime data)
        {
            return data.CompareTo(DateTime.MinValue);
        }

        

        private void verificarDadosAtualizacao(int isbn, Livro livro, List<string> mensagens)
        {
            if (isbn < 1)
                mensagens.Add("O isbn não pode ser negativo.");

            var procuraLivro = contexto.Livros
                .AsNoTracking()
                .FirstOrDefault(l => l.Isbn == isbn);

            if (procuraLivro == null)
                mensagens.Add("O isbn não existe no banco de dados.");            
          
            if (livro.Isbn != isbn)
                mensagens.Add("O url não é compativel com o livro que você quer alterar.");
        }

        private void procurarPorAutor(Livro livro)
        {
            if (livro.IdAutor == 0)
            {
                if (contexto.Autores.Count(a => a.Nome == livro.Autor.Nome) > 1)
                    livro.Autor = contexto.Autores.First(a => a.Nome == livro.Autor.Nome);
                else
                    contexto.Autores.Add(livro.Autor);
            }
        }
        private void procurarPorRevisor(Livro livro)
        {
            if (livro.IdRevisor == null)
            {
                if(livro.Revisor.Nome != null)               
                    adicionarRevisor(livro);                                        
            }
        }

        private void adicionarRevisor(Livro livro)
        {
            var acharUsuarioRevisor = contexto.Usuarios.Any(u => u.Email == livro.Revisor.Nome);
            if (acharUsuarioRevisor)
            {
                var revisor = contexto.Usuarios.First(u => u.Email == livro.Revisor.Nome);
                livro.Revisor = revisor;
                livro.IdRevisor = revisor.Id; 
            }
        }

        private Expression<Func<Livro, dynamic>> resumo =
            (x => new
            {
                Isbn = x.Isbn,
                Titulo = x.Titulo,
                NomeAutor = x.Autor.Nome,
                Genero = x.Genero,
                Capa = x.Capa
        });
               
        public void Dispose ()
        {
            contexto.Dispose();
        }
    }
}