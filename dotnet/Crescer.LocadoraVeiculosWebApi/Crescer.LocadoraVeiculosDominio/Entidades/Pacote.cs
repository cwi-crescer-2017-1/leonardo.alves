using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Pacote
    {
        public int Id { get; set; }

        public string Descricao { get; set; }

        public decimal Preco { get; set; }


        protected Pacote() { }

        
    }
}
