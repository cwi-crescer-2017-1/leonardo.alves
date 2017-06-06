using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Crescer.LocadoraVeiculos.Models
{
    public class UsuarioModel
    {
        public int Id { get; set; }
        public List<PermissaoModel> Permissoes { get; set; }
        public List<string> Mensagens { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }

    }
}