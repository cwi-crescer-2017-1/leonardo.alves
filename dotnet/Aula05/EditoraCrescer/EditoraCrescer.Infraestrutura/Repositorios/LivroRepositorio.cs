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
    }
}