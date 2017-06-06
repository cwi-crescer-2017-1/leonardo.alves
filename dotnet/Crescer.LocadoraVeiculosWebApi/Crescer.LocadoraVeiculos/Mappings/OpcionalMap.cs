using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace Crescer.LocadoraVeiculos.Mappings
{
    public class OpcionalMap : EntityTypeConfiguration<Opcional>
    {
        public OpcionalMap()
        {
            ToTable("Opcional");

            HasKey(x => x.Id);
                       
            Property(x => x.Preco).IsRequired();
            Property(x => x.Quantidade).IsRequired();
            Property(x => x.Descricao).IsRequired().HasMaxLength(400);

        }
    }
}