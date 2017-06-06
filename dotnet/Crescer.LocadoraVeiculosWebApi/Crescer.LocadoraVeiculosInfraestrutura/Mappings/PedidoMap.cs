using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace Crescer.LocadoraVeiculos.Mappings
{
    public class PedidoMap : EntityTypeConfiguration<Pedido>
    {
        public PedidoMap()
        {
            ToTable("Pedido");

            HasKey(x => x.Id);           

            Property(x => x.DataPedido).IsRequired();
            Property(x => x.DataEntregaPrevista).IsRequired();

            Property(x => x.DataEntregaReal).IsOptional();

            HasRequired(x => x.Cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));

            HasOptional(x => x.Pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"));

            HasRequired(x => x.Veiculo)
                .WithMany()
                .Map(x => x.MapKey("IdVeiculo"));

           
        }

    }
}