using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Veiculo
    {
        public int Id { get; private set; }

        public string Descricao { get; private set; }

        public int Estoque { get; private set; }

        public decimal PrecoDiaria { get; private set; }

        public decimal AdicionalDiaria { get; private set; }

        protected Veiculo () { }       


        public void diminuirEstoque ()
        {
            if (Estoque > 0) Estoque--;

            else
                throw new ForaDeEstoqueException("O veículo está fora do estoque!");

        }

        public void aumentarEstoque ()
        {
            Estoque++;
        }
    }
}
