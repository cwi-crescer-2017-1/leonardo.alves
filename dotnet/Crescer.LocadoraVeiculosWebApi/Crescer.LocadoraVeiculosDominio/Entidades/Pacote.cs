using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Pacote : IValidar
    {
        public int Id { get; private set; }

        public string Nome { get; private set; }

        public string Descricao { get; private set; }

        public decimal PrecoDiaria { get; private set; }

        public Pacote(string nome, string descricao, decimal precoDiaria) {
            Nome = nome;
            Descricao = descricao;
            PrecoDiaria = precoDiaria;
        }

        protected Pacote() { }

        public bool Validar()
        {
            
            return !string.IsNullOrWhiteSpace(Nome) &&
                !string.IsNullOrWhiteSpace(Descricao) &&
                PrecoDiaria > 0;
        }
    }
}
