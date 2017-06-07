using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Permissao : IValidar
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        protected Permissao() { }
        public Permissao(string nome) {
            Nome = nome;
        }


        public bool Validar ()
        {
            return !(string.IsNullOrWhiteSpace(Nome));
        }
    }
}
