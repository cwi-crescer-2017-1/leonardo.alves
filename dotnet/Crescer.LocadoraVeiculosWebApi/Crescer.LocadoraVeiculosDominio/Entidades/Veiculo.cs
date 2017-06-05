using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Veiculo
    {
        public int Id { get; set; }

        public string Descricao { get; set; }

        public int Estoque { get; set; }

        public decimal PrecoDiaria { get; set; }

        public decimal AdicionarDiaria { get; set; }

        protected Veiculo () { }       

    }
}
