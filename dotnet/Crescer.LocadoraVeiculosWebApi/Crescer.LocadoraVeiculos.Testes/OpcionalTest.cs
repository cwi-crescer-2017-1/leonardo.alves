using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Crescer.LocadoraVeiculosDominio.Entidades;

namespace Crescer.LocadoraVeiculos.Testes
{
    [TestClass]
    public class OpcionalTest
    {
        [TestMethod]
        public void OpcionalEhInstanciadoComSucesso()
        {
            int id = 843;
            string descricao = "sou legal";
            decimal preco = 4.44M;
            int? quantidade = 88;

            Opcional o = new Opcional(id, descricao, preco, quantidade);

            Assert.AreEqual(id, o.Id);
            Assert.AreEqual(descricao, o.Descricao);
            Assert.AreEqual(preco, o.Preco);
            Assert.AreEqual(quantidade, o.Quantidade);

            Assert.IsTrue(o.Validar());
        }

        [TestMethod]
        [ExpectedException(typeof(ForaDeEstoqueException))]
        public void OpcionalForaDoEstoque()
        {
            int id = 843;
            string descricao = "sou legal";
            decimal preco = 4.44M;
            int? quantidade = 0;

            Opcional o = new Opcional(id, descricao, preco, quantidade);
            o.diminuirEstoque();
           
        }

        [TestMethod]
        [ExpectedException(typeof(RecursoIlimitadoException))]
        public void OpcionalDiminuirComRecursoIlimitado()
        {
            int id = 843;
            string descricao = "sou legal";
            decimal preco = 4.44M;
            int? quantidade = null;

            Opcional o = new Opcional(id, descricao, preco, quantidade);
            o.diminuirEstoque();

        }

        [TestMethod]
        [ExpectedException(typeof(RecursoIlimitadoException))]
        public void OpcionalAumentarComRecursoIlimitado()
        {
            int id = 843;
            string descricao = "sou legal";
            decimal preco = 4.44M;
            int? quantidade = null;

            Opcional o = new Opcional(id, descricao, preco, quantidade);
            o.aumentarEstoque();

        }
    }
}
