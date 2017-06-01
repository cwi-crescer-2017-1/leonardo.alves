﻿using EditoraCrescer.Infraestrutura.Entidades;
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
        public dynamic Obter()
        {
            return contexto.Livros.Select(l => new
            {
                Isbn = l.Isbn,
                Titulo = l.Titulo,
                Capa = l.Capa,
                NomeAutor = l.Autor.Nome,
                Genero = l.Genero
            }).ToList();
        }

        public Livro ObterPorIsbn (int isbn)
        {
            return contexto.Livros.FirstOrDefault(l => l.Isbn == isbn);
        }
        public List<Livro> ObterPorGenero(string genero)
        public object ObterPorLancamento()
        {
            return contexto.Livros
                 .Where(l => (DateTime.Today - l.DataPublicacao).TotalDays <= 7)
                 .Select(l => gerarResumo(l))
                 .ToList();
        }

        public void Criar (Livro livro)
        {
            procurarPorAutor(livro);

            procurarPorRevisor(livro);

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
            return data.CompareTo(DateTime.MinValue);
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

        private void procurarPorAutor(Livro livro)
        {
            if (livro.IdAutor == 0)
            {
                if (contexto.Autores.Any(a => a.Nome == livro.Autor.Nome))
                    livro.Autor = contexto.Autores.First(a => a.Nome == livro.Autor.Nome);
                else
                    contexto.Revisores.Add(livro.Revisor);
            }
        }
        private void procurarPorRevisor(Livro livro)
        {
            if (livro.IdRevisor == 0)
            {
                if (contexto.Revisores.Any(r => r.Nome == livro.Revisor.Nome))
                    livro.Revisor = contexto.Revisores.First(r => r.Nome == livro.Revisor.Nome);
                else
                    contexto.Revisores.Add(livro.Revisor);
            }
        }

        private dynamic gerarResumo(Livro livro)
        {
            return new
            {
                Isbn = livro.Isbn,
                Titulo = livro.Titulo,
                Capa = livro.Capa,
                NomeAutor = livro.Autor.Nome,
                Genero = livro.Genero
            };
        }

        public void Dispose ()
        {
            contexto.Dispose();
        }
    }
}