using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Cliente
    {
        public int Id { get; set; }

        public string NomeCompleto { get; set; }

        public Endereco Endereco { get; set; }

        public string Cpf { get; set; }

        public Genero Genero { get; set; }

        public DateTime DataNascimento { get; set; }

        protected Cliente () { }

        public Cliente (string nomeCompleto, Endereco endereco, 
            string cpf, Genero genero, DateTime dataNascimento)
        {
            NomeCompleto = nomeCompleto;
            Endereco = endereco;
            Cpf = cpf;
            Genero = genero;
            DataNascimento = dataNascimento;
        }
    }
}
