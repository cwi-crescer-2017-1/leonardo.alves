using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }

        public int IdVeiculo { get; set; }

        public int? IdPacote { get; set; }

        public DateTime DataPedido { get; set; }

        public DateTime DataEntregaPrevista { get; set; }

        public DateTime? DataEntregaReal { get; set; }

        protected Pedido () { }

        public Pedido (DateTime dataEntregaPrevista)
        {
            DataEntregaPrevista = dataEntregaPrevista;
        }

        public Pedido(int idVeiculo, DateTime dataPedido, DateTime dataEntregaPrevista)
        {
            IdVeiculo = idVeiculo;            
            DataPedido = dataPedido;
            DataEntregaPrevista = dataEntregaPrevista;
        }

        public Pedido(int idVeiculo, int idPacote, DateTime dataPedido, DateTime dataEntregaPrevista) {
            IdVeiculo = idVeiculo;
            IdPacote = idPacote;
            DataPedido = dataPedido;
            DataEntregaPrevista = dataEntregaPrevista;
        }

    }

}