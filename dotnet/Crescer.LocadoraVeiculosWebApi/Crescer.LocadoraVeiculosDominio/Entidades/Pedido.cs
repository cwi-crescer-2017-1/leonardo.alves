using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Pedido
    {
        public Cliente Cliente { get; private set; }        
        public Pacote Pacote { get; private set;}
        public List<PedidoOpcional> Opcionais { get; private set; } //mudar
        public int Id { get; private set; }
        public Veiculo Veiculo { get; private set; }        
        public DateTime DataPedido { get; private set; }
        public DateTime DataEntregaPrevista { get; private set; }
        public DateTime? DataEntregaReal { get; private set; }

        protected Pedido () { }

        public void Devolver() {
            DataEntregaReal = DateTime.Now;
        }       

        public Pedido(Veiculo veiculo, DateTime dataPedido, 
            DateTime dataEntregaPrevista, Pacote pacote = null) {
            Pacote = pacote;
            Veiculo = veiculo;
            DataPedido = dataPedido;
            DataEntregaPrevista = dataEntregaPrevista;
            Opcionais = new List<PedidoOpcional>();
        }

    }

}