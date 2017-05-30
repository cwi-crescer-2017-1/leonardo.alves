using System;

namespace Exercicio03.Entidades
{
    public class Demonstrativo
    {
        public Demonstrativo(
             double salarioBase,
             double hrsConvencao,
             HorasCalculadas horasExtras,
             HorasCalculadas horasDescontadas,
             double totalProventos,
             Desconto inss,
             Desconto irrf,
             double totalDescontos,
             double totalLiquido,
             Desconto fgts)
        {
            SalarioBase = Math.Round(salarioBase,2);
            HrsConvencao = Math.Round(hrsConvencao,2);
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            TotalProventos = Math.Round(totalProventos,2);
            Inss = inss;
            Irrf = irrf;
            TotalDescontos = Math.Round(totalDescontos,2);
            TotalLiquido = Math.Round(totalLiquido,2);
            Fgts = fgts;
        }

        public double SalarioBase { get; private set; }
        public double HrsConvencao { get; private set; }
        public HorasCalculadas HorasExtras { get; private set; }
        public HorasCalculadas HorasDescontadas { get; private set; }
        public double TotalProventos { get; private set; }
        public Desconto Inss { get; private set; }
        public Desconto Irrf { get; private set; }
        public double TotalDescontos { get; private set; }
        public double TotalLiquido { get; private set; }
        public Desconto Fgts { get; private set; }
    }

}
