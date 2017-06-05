using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Usuario
    {
        public int Id { get; set; }

        public int IdPermissao { get; set; }

        public string Nome { get; set; }

        protected Usuario() { }

        public Usuario(int idPermissao, string nome)
        {
            IdPermissao = idPermissao;
            Nome = nome;
        }

    }
}
