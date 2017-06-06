using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Pedido
    {
        public int IdCliente { get; set; }
        public Cliente Cliente { get; set; }
        public int? IdPacote { get; set; }
        public Pacote Pacote { get; set;}
        public List<Opcional> Opcionais { get; set; }
        public int Id { get; set; }
        public Veiculo Veiculo { get; set; }
        public int IdVeiculo { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaReal { get; set; }

        protected Pedido () { }

        public Pedido (DateTime dataEntregaReal)
        {
            //Construtor para setar a entrega do veículo
            DataEntregaReal = dataEntregaReal;
        }

        public Pedido(int idVeiculo, DateTime dataPedido, DateTime dataEntregaPrevista)
        {
            //Construtor caso não haja pacote
            IdVeiculo = idVeiculo;            
            DataPedido = dataPedido;
            DataEntregaPrevista = dataEntregaPrevista;
            Opcionais = new List<Opcional>();
        }

        public Pedido(int idVeiculo, int idPacote, DateTime dataPedido, DateTime dataEntregaPrevista) {
            //Construtor caso haja pacote
            IdVeiculo = idVeiculo;
            IdPacote = idPacote;
            DataPedido = dataPedido;
            DataEntregaPrevista = dataEntregaPrevista;
            Opcionais = new List<Opcional>();
        }

    }

}