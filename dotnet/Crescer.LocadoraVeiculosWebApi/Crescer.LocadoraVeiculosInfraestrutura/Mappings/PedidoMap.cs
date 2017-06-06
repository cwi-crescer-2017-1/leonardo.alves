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

            Property(x => x.IdCliente).IsRequired();
            Property(x => x.IdVeiculo).IsRequired();

            Property(x => x.DataPedido).IsRequired();
            Property(x => x.DataEntregaPrevista).IsRequired();

            Property(x => x.DataEntregaReal).IsOptional();

            HasRequired(x => x.Cliente)
                .WithMany()
                .HasForeignKey(x => x.IdCliente);

            HasOptional(x => x.Pacote)
                .WithMany()
                .HasForeignKey(x => x.IdPacote);

            HasRequired(x => x.Veiculo)
                .WithMany()
                .HasForeignKey(x => x.IdVeiculo);

            HasMany(x => x.Opcionais)
                .WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdPedido");
                    x.MapRightKey("IdOpcional");
                    x.ToTable("PedidoOpcional");
                });
        }

    }
}