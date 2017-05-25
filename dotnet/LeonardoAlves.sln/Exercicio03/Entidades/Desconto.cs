using System;

namespace Exercicio03.Entidades
{
    public class Desconto
    {
        
        public Desconto(double aliquota, double valor)
        {
            Aliquota = aliquota;
            Valor = valor;
            ValorDesconto = Math.Round(Aliquota * Valor,2);
            Restante = Math.Round(Valor - ValorDesconto,2);
        }

        public double Aliquota { get; private set; }
        public double Valor { get; private set; }

        public double ValorDesconto { get; private set; }

        public double Restante { get; private set; }
    }
}
