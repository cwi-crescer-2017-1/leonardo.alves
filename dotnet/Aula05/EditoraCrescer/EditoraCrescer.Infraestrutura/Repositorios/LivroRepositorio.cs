using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Contexto;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{

    public class LivroRepositorio
    {
        private Contexto.Contexto contexto = new Contexto.Contexto();
        private List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }
    }
}