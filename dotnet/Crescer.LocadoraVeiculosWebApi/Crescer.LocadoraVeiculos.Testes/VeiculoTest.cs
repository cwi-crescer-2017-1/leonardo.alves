using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Crescer.LocadoraVeiculosDominio.Entidades;

namespace Crescer.LocadoraVeiculos.Testes
{
    [TestClass]
    public class VeiculoTest
    {
        [TestMethod]
        public void VeiculoEhInstanciado()
        {
            string descricao = "oie";
            int estoque = 33;
            decimal precoDiaria = 4M;
            decimal adicionalDiaria = 2M;
            Veiculo v = new Veiculo(descricao, estoque, precoDiaria, adicionalDiaria);

            Assert.AreEqual(descricao, v.Descricao);
            Assert.AreEqual(estoque, v.Estoque);
            Assert.AreEqual(precoDiaria, v.PrecoDiaria);
            Assert.AreEqual(adicionalDiaria, v.AdicionalDiaria);

            Assert.IsTrue(v.Validar());
        }

        [TestMethod]
        public void VeiculoNaoValidaSemDescricao()
        {
            string descricao = "";
            int estoque = 33;
            decimal precoDiaria = 4M;
            decimal adicionalDiaria = 2M;
            Veiculo v = new Veiculo(descricao, estoque, precoDiaria, adicionalDiaria);


            Assert.IsFalse(v.Validar());
        }


        [TestMethod]
        public void VeiculoNaoValidaSemEstoque()
        {
            string descricao = "asds";
            int estoque =0 ;
            decimal precoDiaria = 4M;
            decimal adicionalDiaria = 2M;
            Veiculo v = new Veiculo(descricao, estoque, precoDiaria, adicionalDiaria);


            Assert.IsFalse(v.Validar());
        }

        [TestMethod]
        public void VeiculoNaoValidaSemPreco()
        {
            string descricao = "asds";
            int estoque = 99;
            decimal precoDiaria = 0;
            decimal adicionalDiaria = 2M;
            Veiculo v = new Veiculo(descricao, estoque, precoDiaria, adicionalDiaria);


            Assert.IsFalse(v.Validar());
        }

        [TestMethod]
        public void VeiculoNaoValidaSemAdicional()
        {
            string descricao = "asds";
            int estoque = 99;
            decimal precoDiaria = 90;
            decimal adicionalDiaria = 0;
            Veiculo v = new Veiculo(descricao, estoque, precoDiaria, adicionalDiaria);


            Assert.IsFalse(v.Validar());
        }

        [TestMethod]
        [ExpectedException(typeof(ForaDeEstoqueException))]
        public void VeiculoNaoFicaNegativo()
        {
            string descricao = "asds";
            int estoque = 0;
            decimal precoDiaria = 90;
            decimal adicionalDiaria = 0;
            Veiculo v = new Veiculo(descricao, estoque, precoDiaria, adicionalDiaria);

            v.diminuirEstoque();
        }
    }
}
