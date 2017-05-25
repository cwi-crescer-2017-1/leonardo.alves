using System;

namespace Exercicio03.Entidades
{
    public class HorasCalculadas
    { 
        public HorasCalculadas(double qtdHoras, double valorTotalHoras)
        {

            QtdHoras = qtdHoras;
            ValorTotalHoras = valorTotalHoras;
            CalcularValor = Math.Round(QtdHoras * ValorTotalHoras,2);
        }
        public double QtdHoras { get; private set; }
        public double ValorTotalHoras { get; private set; }
        public double CalcularValor { get; private set; }



    }
}
