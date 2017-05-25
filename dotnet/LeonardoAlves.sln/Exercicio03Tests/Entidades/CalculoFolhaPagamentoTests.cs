using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Exercicio03.Entidades.Tests
{
    [TestClass()]
    public class CalculoFolhaPagamentoTests
    {

        [TestMethod()]
        public void GerarDemonstrativoTest_Industria_5000()
        {
            //arrange
            int horasCategoria = 200;
            double salarioBase = 5000;
            double horasExtras = 50;
            double horasDescontadas = 10;
            //act
            var calculo = new CalculoFolhaPagamento();
            var demonstrativo = calculo.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            //assert
            Assert.AreEqual(1250.00, demonstrativo.HorasExtras.CalcularValor);
            Assert.AreEqual(250.00, demonstrativo.HorasDescontadas.CalcularValor);
            Assert.AreEqual(6000.00, demonstrativo.TotalProventos);
            Assert.AreEqual(600.00, demonstrativo.Inss.ValorDesconto);
            Assert.AreEqual(1485.00, demonstrativo.Irrf.ValorDesconto);
            Assert.AreEqual(2085.00, demonstrativo.TotalDescontos);
            Assert.AreEqual(3915.00, demonstrativo.TotalLiquido);
            Assert.AreEqual(660.00, demonstrativo.Fgts.ValorDesconto);
            /* 
                -Salário Mensalista(200hrs)                  5000,00
                - Horas Extras(50hrs)                        1250,00
                - Horas Descontadas(10hrs)                   250,00
                - Total de Proventos                         6000,00
                - INSS(10 %)                                 600,00
                - IRRF(27, 5 %)                              1485,00
                - Total de Descontos                         2085,00
                - Total Líquido                              3915,00
                - FGTS(11 %)                                 660,00
             */


        }

        [TestMethod()]
        public void GerarDemonstrativoTest_Industria_900()
        {
            //arrange
            int horasCategoria = 200;
            double salarioBase = 900;
            double horasExtras = 50;
            double horasDescontadas = 10;
            //act
            var calculo = new CalculoFolhaPagamento();
            var demonstrativo = calculo.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            //assert
            Assert.AreEqual(225.00, demonstrativo.HorasExtras.CalcularValor);
            Assert.AreEqual(45.00, demonstrativo.HorasDescontadas.CalcularValor);
            Assert.AreEqual(1080.00, demonstrativo.TotalProventos);
            Assert.AreEqual(97.2, demonstrativo.Inss.ValorDesconto);
            Assert.AreEqual(0.00, demonstrativo.Irrf.ValorDesconto);
            Assert.AreEqual(97.2, demonstrativo.TotalDescontos);
            Assert.AreEqual(982.8, demonstrativo.TotalLiquido);
            Assert.AreEqual(118.8, demonstrativo.Fgts.ValorDesconto);
            /* 
                -Salário Mensalista(200hrs)                  900,00
                - Horas Extras(50hrs)                        225,00
                - Horas Descontadas(10hrs)                   45,00
                - Total de Proventos                         1080
                - INSS(9 %)                                  97,2
                - IRRF(isento)                               0   
                - Total de Descontos                         97,2
                - Total Líquido                              982,8
                - FGTS(11 %)                                 118,8
             */


        }


        [TestMethod()]
        public void GerarDemonstrativoTest_Industria_1284964()
        {
            //arrange
            int horasCategoria = 200;
            double salarioBase = 1284964;
            double horasExtras = 26;
            double horasDescontadas = 19;
            //act
            var calculo = new CalculoFolhaPagamento();
            var demonstrativo = calculo.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            //assert
            Assert.AreEqual(167045.32, demonstrativo.HorasExtras.CalcularValor);
            Assert.AreEqual(122071.58, demonstrativo.HorasDescontadas.CalcularValor);
            Assert.AreEqual(1329937.74, demonstrativo.TotalProventos);
            Assert.AreEqual(132993.77, demonstrativo.Inss.ValorDesconto);
            Assert.AreEqual(329159.59, demonstrativo.Irrf.ValorDesconto);
            Assert.AreEqual(462153.36, demonstrativo.TotalDescontos);
            Assert.AreEqual(867784.38, demonstrativo.TotalLiquido);
            Assert.AreEqual(146293.15, demonstrativo.Fgts.ValorDesconto);


            /* 
                -Salário Mensalista(200hrs)                  1284964
                - Horas Extras(26hrs)                        167045,32
                - Horas Descontadas(19hrs)                   122071,58
                - Total de Proventos                         1329937,74
                - INSS(10 %)                                 132993,77
                - IRRF(27,5 %)                               329159,59
                - Total de Descontos                         462153,36
                - Total Líquido                              867784,38
                - FGTS(11 %)                                 146293,15
             */
        }

        [TestMethod()]
        public void GerarDemonstrativoTest_Comercio_2000()
        {
            //arrange
            int horasCategoria = 170;
            double salarioBase = 2000;
            double horasExtras = 30;
            double horasDescontadas = 0;
            //act
            var calculo = new CalculoFolhaPagamento();
            var demonstrativo = calculo.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            //assert
            Assert.AreEqual(352.8, demonstrativo.HorasExtras.CalcularValor);
            Assert.AreEqual(0.00, demonstrativo.HorasDescontadas.CalcularValor);
            Assert.AreEqual(2352.8, demonstrativo.TotalProventos);
            Assert.AreEqual(235.28, demonstrativo.Inss.ValorDesconto);
            Assert.AreEqual(158.81, demonstrativo.Irrf.ValorDesconto);
            Assert.AreEqual(1958.71, demonstrativo.TotalLiquido);
            Assert.AreEqual(394.09, demonstrativo.TotalDescontos);
            Assert.AreEqual(258.81, demonstrativo.Fgts.ValorDesconto);
            /* 
                -Salário Mensalista(170hrs)                  2000,00
                - Horas Extras(30hrs)                        352,8
                - Horas Descontadas(0hrs)                    0,00
                - Total de Proventos                         2352,8
                - INSS(10 %)                                 235,28
                - IRRF(7,5 %)                                158,81
                - Total de Descontos                         394,09
                - Total Líquido                              1958.71
                - FGTS(11 %)                                 258,81
            */
        }

        [TestMethod()]
        public void GerarDemonstrativoTest_Comercio_900()
        {
            //arrange
            int horasCategoria = 170;
            double salarioBase = 900;
            double horasExtras = 20;
            double horasDescontadas = 10;
            //act
            var calculo = new CalculoFolhaPagamento();
            var demonstrativo = calculo.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            //assert
            Assert.AreEqual(105.8, demonstrativo.HorasExtras.CalcularValor);
            Assert.AreEqual(52.9, demonstrativo.HorasDescontadas.CalcularValor);
            Assert.AreEqual(952.90, demonstrativo.TotalProventos);
            Assert.AreEqual(76.23, demonstrativo.Inss.ValorDesconto);
            Assert.AreEqual(0, demonstrativo.Irrf.ValorDesconto);
            Assert.AreEqual(876.67, demonstrativo.TotalLiquido);
            Assert.AreEqual(76.23, demonstrativo.TotalDescontos);
            Assert.AreEqual(104.82, demonstrativo.Fgts.ValorDesconto);
            /* 
                -Salário Mensalista(170hrs)                  900,00
                - Horas Extras(20hrs)                        105.8
                - Horas Descontadas(10hrs)                   52.9
                - Total de Proventos                         952,9
                - INSS(8 %)                                  76,23
                - IRRF(isento)                               0
                - Total de Descontos                         76.16
                - Total Líquido                              876.67
                - FGTS(11 %)                                 104.82
            */
        }

        [TestMethod()]
        public void GerarDemonstrativoTest_Comercio_35903()
        {
            //arrange
            int horasCategoria = 170;
            double salarioBase = 35903;
            double horasExtras = 0;
            double horasDescontadas = 30;
            //act
            var calculo = new CalculoFolhaPagamento();
            var demonstrativo = calculo.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            //assert
            Assert.AreEqual(0, demonstrativo.HorasExtras.CalcularValor);
            Assert.AreEqual(6335.7, demonstrativo.HorasDescontadas.CalcularValor);
            Assert.AreEqual(29567.3, demonstrativo.TotalProventos);
            Assert.AreEqual(2956.73, demonstrativo.Inss.ValorDesconto);
            Assert.AreEqual(7317.91, demonstrativo.Irrf.ValorDesconto);
            Assert.AreEqual(19292.66, demonstrativo.TotalLiquido);
            Assert.AreEqual(10274.64, demonstrativo.TotalDescontos);
            Assert.AreEqual(3252.40, demonstrativo.Fgts.ValorDesconto);
            /* 
                -Salário Mensalista(170hrs)                  35903
                - Horas Extras(0)                            0
                - Horas Descontadas(30hrs)                   6335.7
                - Total de Proventos                         29567,3
                - INSS(10 %)                                 2956,73
                - IRRF(27.5%)                                7317.91
                - Total de Descontos                         10274,64
                - Total Líquido                              19292,66
                - FGTS(11 %)                                 3252,40
            */
        }
    }
}