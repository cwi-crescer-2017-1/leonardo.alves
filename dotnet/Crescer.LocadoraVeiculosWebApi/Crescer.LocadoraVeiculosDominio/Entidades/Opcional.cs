using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Opcional
    {
        public int Id { get; set; }

        public string Descricao { get; set; }

        public decimal Preco { get; set; }

        public int Quantidade { get; set; }

        protected Opcional() { }
    }
}
