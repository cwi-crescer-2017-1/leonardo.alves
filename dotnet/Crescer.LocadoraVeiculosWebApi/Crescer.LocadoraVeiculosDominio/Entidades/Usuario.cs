using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Usuario
    {
        public int Id { get; private set; }
        public List<Permissao> Permissoes { get; private set; }
        public List<string> Mensagens { get; private set; }
        public string Email { get; private set; }
        public string Senha { get; private set; }        

        protected Usuario() { }

        public Usuario(string email, string senha)
        {
            Email = email;
            if (!string.IsNullOrWhiteSpace(senha))
                Senha = CriptografarSenha(senha);
            Permissoes = new List<Permissao>();
        }

        private string CriptografarSenha(string senha)
        {
            MD5 md5 = MD5.Create();
            byte[] inputBytes = Encoding.Default.GetBytes(Email + senha);
            byte[] hash = md5.ComputeHash(inputBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
                sb.Append(hash[i].ToString("x2"));

            return sb.ToString();
        }

        public bool ValidarSenha(string senha)
        {
            return CriptografarSenha(senha) == Senha;
        }

        public void AtribuirPermissoes(params string[] nomes)
        {
            foreach (var nome in nomes)
                Permissoes.Add(new Permissao(nome));
        }


        public  bool Validar()
        {           
            if (string.IsNullOrWhiteSpace(Email))
                Mensagens.Add("Email é inválido.");

            if (string.IsNullOrWhiteSpace(Senha))
                Mensagens.Add("Senha é inválido.");

            return Mensagens.Count == 0;
        }

    }
}
