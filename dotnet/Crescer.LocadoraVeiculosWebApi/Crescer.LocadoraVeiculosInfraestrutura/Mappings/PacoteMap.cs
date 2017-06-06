using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace Crescer.LocadoraVeiculos.Mappings
{
    public class PacoteMap : EntityTypeConfiguration<Pacote>
    {
        public PacoteMap()
        {
            ToTable("Pacote");
            HasKey(x => x.Id);

            Property(x => x.Descricao).IsRequired();
            Property(x => x.PrecoDiaria).IsRequired();
            Property(x => x.Nome).IsRequired();

        }
    }
}