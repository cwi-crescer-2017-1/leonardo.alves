using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Pacote
    {
        public int Id { get; private set; }

        public string Nome { get; private set; }

        public string Descricao { get; private set; }

        public decimal PrecoDiaria { get; private set; }

        protected Pacote() { }

        
    }
}
