using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Crescer.LocadoraVeiculos.Models
{
    public class ClienteModel
    {
        public int Id { get; set; }

        public string NomeCompleto { get; set; }
        public EnderecoModel Endereco { get; set; }

        public string Cpf { get;  set; }

        public GeneroModel Genero { get; set; }

        public DateTime DataNascimento { get; set; }

    }
}