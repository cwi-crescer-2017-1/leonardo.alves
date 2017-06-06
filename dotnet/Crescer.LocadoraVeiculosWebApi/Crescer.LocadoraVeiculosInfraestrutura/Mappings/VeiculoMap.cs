using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace Crescer.LocadoraVeiculos.Mappings
{
    public class VeiculoMap : EntityTypeConfiguration<Veiculo>
    {
        public VeiculoMap()
        {
            ToTable("Veiculo");

            HasKey(x => x.Id);

            Property(x => x.Descricao).IsRequired().HasMaxLength(500);
            Property(x => x.PrecoDiaria).IsRequired();
            Property(x => x.AdicionalDiaria).IsRequired();

        }
    }
}