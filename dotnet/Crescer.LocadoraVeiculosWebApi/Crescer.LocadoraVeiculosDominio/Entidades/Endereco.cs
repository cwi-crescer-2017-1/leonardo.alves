using System;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Endereco : IValidar
    {
        public int Id { get; private set; }
        public int Numero { get; private set; }

        public string Rua { get;private set; }

        public string Cidade { get;private set; }

        public string UF { get;private set; }

        public string  Bairro { get;private set; }        
        
        protected Endereco() { }

        public Endereco(int numero, string rua, string cidade, string uf, string bairro )
        {
            Numero = numero;
            Rua = rua;
            Cidade = cidade;
            UF = uf;
            Bairro = bairro;
        }

        public bool Validar()
        {
            return !(string.IsNullOrWhiteSpace(Rua) ||
                string.IsNullOrWhiteSpace(Cidade) ||
                string.IsNullOrWhiteSpace(UF) ||
                string.IsNullOrWhiteSpace(Bairro));
        }
    }
}