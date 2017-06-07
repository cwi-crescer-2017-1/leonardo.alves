using System;


namespace Crescer.LocadoraVeiculos.Models
{
    public class CriarPedidoModel
    {
        public int IdCliente { get; set; }
        public int IdVeiculo { get; set; }
        public int? IdPacote { get; set; }
        public int [] IdOpcional { get; set; }
        public DateTime  DataEntrega { get; set; }   
    }
}