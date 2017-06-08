using System;


namespace Crescer.LocadoraVeiculos.Models
{
    public class CriarPedidoModel
    {
        public string Cpf { get; set; }
        public int IdVeiculo { get; set; }
        public int? IdPacote { get; set; }
        public int [] IdOpcional { get; set; }
        public DateTime  DataEntrega { get; set; }   
    }
}