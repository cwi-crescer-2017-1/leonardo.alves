
namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Veiculo : IValidar
    {
        public int Id { get; private set; }

        public string Descricao { get; private set; }

        public int Estoque { get; private set; }

        public decimal PrecoDiaria { get; private set; }

        public decimal AdicionalDiaria { get; private set; }

        protected Veiculo () { }

        public Veiculo(string Descricao, int Estoque, decimal PrecoDiaria, decimal AdicionalDiaria) { }



        public void diminuirEstoque ()
        {
            if (Estoque > 0) Estoque--;

            else
                throw new ForaDeEstoqueException("O veículo está fora do estoque!");

        }

        public void aumentarEstoque ()
        {
            Estoque++;
        }

        public bool Validar()
        {
            return !string.IsNullOrWhiteSpace(Descricao) &&
                Estoque > 0 && PrecoDiaria > 0 && AdicionalDiaria > 0;
        }
    }
}
