using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();
        public List<Autor> ObterAutores ()
        {
           return contexto.Autores.ToList();
        }

        public Autor ObterAutor(int id)
        {            
            return contexto.Autores.FirstOrDefault(a => a.Id == id);
        }
        
        public List<Livro> ObterLivrosAutor(int id)
        {
            return contexto.Livros
                .Where(l => l.IdAutor == id).ToList();
        }
        public void Criar (Autor autor)
        {
            contexto.Autores.Add(autor);
        }

        public bool Alterar (int id, Autor autor, out List<string> mensagens)
        {
            mensagens = new List<string>();

            verificarDadosAtualizacao(id, autor, mensagens);

            if (mensagens.Count > 0) return false;

            contexto.Entry(autor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return true;
        }

        private void verificarDadosAtualizacao(int id, Autor autor, List<string> mensagens)
        {
            if (id < 1)
                mensagens.Add("Id não pode ser negativo.");

            if (!contexto.Autores.Any(a => a.Id == id))
                mensagens.Add("O id do autor não confere com o id da URL.");

            if (id != autor.Id)
                mensagens.Add("Id's não conferem.");
        }

        public bool Deletar (int id, out Autor autor)
        {
            autor = contexto.Autores.FirstOrDefault(x => x.Id == id);
            if (autor == null) return false;

            contexto.Autores.Remove(autor);
            contexto.SaveChanges();

            return true;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
