using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Permissao
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        protected Permissao() { }
        public Permissao(string nome) { }
    }
}
