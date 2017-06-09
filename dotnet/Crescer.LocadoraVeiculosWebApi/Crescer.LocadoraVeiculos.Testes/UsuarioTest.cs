using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Crescer.LocadoraVeiculosDominio.Entidades;

namespace Crescer.LocadoraVeiculos.Testes
{
    [TestClass]
    public class UsuarioTest
    {
        [TestMethod]
        public void UsuarioValidaSenha()
        {
            string email = "kkk";
            string senha = "123";
            Usuario u = new Usuario(email, senha);

            Assert.IsTrue(u.ValidarSenha(senha));
        }

        [TestMethod]
        public void UsuarioEhInstanciado()
        {
            string email = "kkk";
            string senha = "123";
            Usuario u = new Usuario(email, senha);

            Assert.AreEqual(email, u.Email);
            
        }

        [TestMethod]
        public void UsuarioSemEmailNaoValidaEmail()
        {
            string email = "";
            string senha = "123";
            Usuario u = new Usuario(email, senha);

            Assert.IsFalse(u.Validar());
        }
    }
}
