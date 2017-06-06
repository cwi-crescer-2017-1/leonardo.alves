using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Cliente : IValidar
    {
        public int Id { get; private set; }

        public string NomeCompleto { get; private set; }        
        public Endereco Endereco { get; private set; }

        public string Cpf { get; private set; }

        public Genero Genero { get; private set; }

        public DateTime DataNascimento { get; private set; }

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

        public bool Validar ()
        {
            return !(string.IsNullOrWhiteSpace(NomeCompleto) &&
                    string.IsNullOrWhiteSpace(Cpf) &&
                    Endereco == null &&                    
                    DataNascimento == null);
        }

    }
}
