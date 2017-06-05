namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Endereco
    {
        public int Numero { get; set; }

        public string Rua { get; set; }

        public string Cidade { get; set; }

        public string UF { get; set; }

        public string  Bairro { get; set; }        
        
        protected Endereco() { }

        public Endereco(int numero, string rua, string cidade, string uf, string bairro )
        {
            Numero = numero;
            Rua = rua;
            Cidade = cidade;
            UF = uf;
            Bairro = bairro;
        }
    }
}