using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Entidades
{
    public class Revisor
    {
        public int Id { get; set; }

        public string Nome { get; set; }

        public bool Validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (string.IsNullOrWhiteSpace(Nome))
                mensagens.Add("O nome não pode ser inválido.");

            return mensagens.Count == 0;
        }

    }
}
