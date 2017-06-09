using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Crescer.LocadoraVeiculosDominio.Entidades;

namespace Crescer.LocadoraVeiculos.Testes
{
    [TestClass]
    public class PedidoTest
    {
        [TestMethod]
        public void PedidoEhInstanciado()
        {
            Endereco en = new Endereco(0, "e", "d", "e2", "ds");
            Cliente c = new Cliente("kk", en, "040", LocadoraVeiculosDominio.Genero.MASCULINO, DateTime.Parse("19/10/2000"));
            Veiculo v = new Veiculo("x", 3, 12M, 13M);
            DateTime dtp = DateTime.Parse("11/02/2000");
            DateTime dtpv = DateTime.Parse("11/02/2011");
            Pacote pkg = new Pacote("sad", "asd", 11M);
            Pedido p = new Pedido(c, v, dtp, dtpv, pkg);

            Assert.AreEqual(c, p.Cliente);
            Assert.AreEqual(v, p.Veiculo);
            Assert.AreEqual(dtp, p.DataPedido);
            Assert.AreEqual(dtpv, p.DataEntregaPrevista);
            Assert.AreEqual(pkg, p.Pacote);

            Assert.IsTrue(p.Validar());
        }

        [TestMethod]
        public void PedidoDevolverAdicionaData()
        {
            Endereco en = new Endereco(0, "e", "d", "e2", "ds");
            Cliente c = new Cliente("kk", en, "040", LocadoraVeiculosDominio.Genero.MASCULINO, DateTime.Parse("19/10/2000"));
            Veiculo v = new Veiculo("x", 3, 12M, 13M);
            DateTime dtp = DateTime.Parse("11/02/2000");
            DateTime dtpv = DateTime.Parse("11/02/2011");
            Pacote pkg = new Pacote("sad", "asd", 11M);
            Pedido p = new Pedido(c, v, dtp, dtpv, pkg);

            
            p.Devolver();

            Assert.IsNotNull(p.DataEntregaReal);
        }
    }
}
