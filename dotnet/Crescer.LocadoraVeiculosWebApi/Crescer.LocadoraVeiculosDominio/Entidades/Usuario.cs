using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;


namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Usuario : IValidar
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

        public void AtribuirPermissoes(string[] nomes)
        {
            Permissoes = new List<Permissao>();
            foreach (var nome in nomes)
                Permissoes.Add(new Permissao(nome));
        }


        public  bool Validar()
        {
            return !string.IsNullOrWhiteSpace(Email) &&
                !string.IsNullOrWhiteSpace(Senha);        
          
        }

    }
}
