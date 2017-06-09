using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Crescer.LocadoraVeiculosDominio.Entidades;
using Crescer.LocadoraVeiculosDominio;

namespace Crescer.LocadoraVeiculos.Testes
{
    [TestClass]
    public class ClienteTest
    {
        [TestMethod]
        public void ClienteEhCriadoComSucesso()
        {
            var nome = "Adalberto";
            var cpf = "04000";
            var endereco = new Endereco(040,"air", "foo", "bar", "foobar");
            var genero = Genero.MASCULINO;
            DateTime data = DateTime.Parse("09.06.2017 07:16:58");

            Cliente c = new Cliente(nome, endereco, cpf, genero, data);

            Assert.AreEqual("Adalberto", c.NomeCompleto);
            Assert.AreEqual("04000", c.Cpf);
            Assert.AreEqual(Genero.MASCULINO, c.Genero);
            Assert.AreEqual(data, c.DataNascimento);

            Assert.AreEqual("air", c.Endereco.Rua);
            Assert.AreEqual("foo", c.Endereco.Cidade);
            Assert.AreEqual("bar", c.Endereco.UF);
            Assert.AreEqual("foobar", c.Endereco.Bairro);

            Assert.IsTrue(c.Validar());


        }
    }
}
