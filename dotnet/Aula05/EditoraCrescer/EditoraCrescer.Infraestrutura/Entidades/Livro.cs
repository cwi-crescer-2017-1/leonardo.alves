using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Entidades
{
    public class Livro
    {
        public int Isbn { get; set; }
        public string Titulo { get; set; }
        public string Descricao { get; set; }
        public string Genero { get; set; }
        public DateTime DataPublicacao { get; set; }
        public int IdAutor { get; set; }
        public Autor Autor { get; set; }

        public int IdRevisor { get; set; }

        public Revisor Revisor { get; set; }

        public DateTime DataRevisao { get; set; }

        public string Capa { get; set; }

        public bool Validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (string.IsNullOrWhiteSpace(Titulo))
                mensagens.Add("O título não pode ser vazio.");

            if (string.IsNullOrWhiteSpace(Descricao))
                mensagens.Add("A descrição não pode ser vazia.");

            if (string.IsNullOrWhiteSpace(Genero))
                mensagens.Add("O gênero não pode ser vazio.");

            return mensagens.Count == 0;
        }

    }
}
