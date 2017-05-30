using System;

namespace Exercicio03.Entidades
{
    public class CalculoFolhaPagamento : IFolhaPagamento
    {        
        
        public Demonstrativo GerarDemonstrativo
            (int horasCategoria, double salarioBase, 
            double horasExtras,  double horasDescontadas)
        {

            var valorHora = getValorHora(salarioBase, horasCategoria);

            //HORAS CALCULADAS
            var objHorasExtras = new HorasCalculadas(horasExtras, valorHora);
            var objHorasDescontadas = new HorasCalculadas(horasDescontadas, valorHora);

            //PROVENTO
            var totalProventos = getTotalProventos(salarioBase, objHorasExtras, objHorasDescontadas);

            //% DE DESCONTO
            var porcentagemDescontoInss = getPorcentagemDescontoInss(totalProventos);
            var porcentagemDescontoIrrf = getPorcentagemDescontoIrrf(totalProventos);

            //DESCONTOS 
            var Inss = new Desconto(porcentagemDescontoInss, totalProventos);
            var Irrf = new Desconto(porcentagemDescontoIrrf, Inss.Restante);
            var Fgts = new Desconto(totalProventos, 0.11);
            var TotalDescontos = Math.Round(Inss.ValorDesconto + Irrf.ValorDesconto,2);

            //SALARIO LIQUIDO
            var SalarioLiquido = getTotalLiquido(totalProventos, TotalDescontos);

            return new Demonstrativo
                (salarioBase, horasCategoria, objHorasExtras, 
                objHorasDescontadas, totalProventos, Inss, Irrf, TotalDescontos, SalarioLiquido, Fgts);
        }

        private double getValorHora(double salarioBase, double horasCategoria) 
        {
            return Math.Round(salarioBase / horasCategoria,2);
        }

        private double getTotalProventos
            (double salarioBase, HorasCalculadas horasExtras, HorasCalculadas horasDescontadas)
        {
            var valorHoraExtra = horasExtras.CalcularValor;
            var valorHoraDescontada = horasDescontadas.CalcularValor;

            return salarioBase + valorHoraExtra - valorHoraDescontada;
        }

        private double getPorcentagemDescontoInss (double proventos)
        {
            if (proventos <= 1000)
            {
                return 0.08;
            } 
            else if (proventos <= 1500)
            {
                return 0.09;
            } else
            {
                return 0.1;
            }
        }

        private double getPorcentagemDescontoIrrf (double proventos)
        {
            if(proventos <= 1710.78)
            {
                return 0;
            }
            else if (proventos <= 2563.91 )
            {
                return 0.075;
            } else if (proventos <= 3418.59)
            {
                return 0.15;
            } else if (proventos <= 4271.59)
            {
                return 0.225;
            } else
            {
                return 0.275;
            }
        }
        

        private double getTotalLiquido (double valorProventos, double valorDescontos)
        {
            return valorProventos - valorDescontos;
        }

    }
}
