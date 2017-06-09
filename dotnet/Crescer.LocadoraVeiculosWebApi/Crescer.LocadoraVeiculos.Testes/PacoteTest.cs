using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Crescer.LocadoraVeiculosDominio.Entidades;

namespace Crescer.LocadoraVeiculos.Testes
{
    [TestClass]
    public class PacoteTest
    {
        [TestMethod]
        public void PacoteEhInstanciado()
        {
            string nome = "hehe";
            string descricao = "algo";
            decimal precoDiaria = 4.45M;
            Pacote p = new Pacote(nome, descricao, precoDiaria);

            Assert.AreEqual(nome, p.Nome);
            Assert.AreEqual(descricao, p.Descricao);
            Assert.AreEqual(precoDiaria, p.PrecoDiaria);

            Assert.IsTrue(p.Validar());
        }

        [TestMethod]
        public void PacoteNomeNaoEhValido()
        {
            string nome = "";
            string descricao = "algo";
            decimal precoDiaria = 4.45M;
            Pacote p = new Pacote(nome, descricao, precoDiaria);          

            Assert.IsFalse(p.Validar());
        }

        [TestMethod]
        public void PacoteDescricaoNaoEhValido()
        {
            string nome = "kkk";
            string descricao = "";
            decimal precoDiaria = 4.45M;
            Pacote p = new Pacote(nome, descricao, precoDiaria);

            Assert.IsFalse(p.Validar());
        }

        [TestMethod]

        public void PacotePrecoNaoEhValido()
        {
            string nome = "asdasd";
            string descricao = "algo";
            decimal precoDiaria = -1M;
            Pacote p = new Pacote(nome, descricao, precoDiaria);

            Assert.IsFalse(p.Validar());
        }
    }
}
