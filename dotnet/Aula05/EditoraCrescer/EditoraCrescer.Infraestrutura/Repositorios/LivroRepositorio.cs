using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{

    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();
        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public Livro ObterPorIsbn (int isbn)
        {
            return contexto.Livros.FirstOrDefault(l => l.Isbn == isbn);
        }
        public List<Livro> ObterPorGenero(string genero)
        {
            return contexto.Livros
                .Where(l => l.Genero.Contains(genero)).ToList();
        }

        public void Criar (Livro livro)
        {
            if (livro.IdAutor == 0)
                contexto.Autores.Add(livro.Autor);


            if (livro.IdRevisor == 0)
                contexto.Revisores.Add(livro.Revisor);

            adicionarDataSeNaoExiste(livro);

            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public bool AtualizarLivro (int isbn, Livro livro, out List<string> mensagens)
        {           
            mensagens = new List<string>();

            verificarDadosAtualizacao(isbn, livro, mensagens);

            if (mensagens.Count > 0) return false;

            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return true;
        }        

        public void Deletar (int id)
        {
            var livro = contexto.Livros.FirstOrDefault(l => l.Isbn == id);
            contexto.Livros.Remove(livro) ;
        }

       

        private int compararData (DateTime data)
        {
            return DateTime.MinValue.CompareTo(data);
        }

        private void adicionarDataSeNaoExiste (Livro livro)
        {
            if (compararData(livro.DataPublicacao) < 1)
                livro.DataPublicacao = DateTime.Now;

            if (compararData(livro.DataRevisao) < 1)
                livro.DataRevisao = DateTime.Now;
        }

        private void verificarDadosAtualizacao(int isbn, Livro livro, List<string> mensagens)
        {
            if (isbn < 1)
                mensagens.Add("O isbn não pode ser negativo.");

            if (contexto.Livros.Count(l => l.Isbn == isbn) > 0)
                mensagens.Add("O isbn não existe no banco de dados.");

            if (livro.Isbn != isbn)
                mensagens.Add("O url não é compativel com o livro que você quer alterar.");
        }

        public void Dispose ()
        {
            contexto.Dispose();
        }
    }
}