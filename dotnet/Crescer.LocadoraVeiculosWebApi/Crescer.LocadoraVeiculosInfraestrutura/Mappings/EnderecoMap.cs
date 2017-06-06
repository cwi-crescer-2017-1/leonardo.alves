using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace Crescer.LocadoraVeiculos.Mappings
{
    public class EnderecoMap : EntityTypeConfiguration<Endereco>
    {
        public EnderecoMap()
        {
            ToTable("Endereco");

            HasKey(x => x.Id);

            Property(c => c.Bairro).IsRequired().HasMaxLength(100);
            Property(c => c.Cidade).IsRequired().HasMaxLength(100);
            Property(c => c.Numero).IsRequired();                          
            Property(c => c.Rua).IsRequired().HasMaxLength(100);                          
            Property(c => c.UF).IsRequired();                          
            
        }
    }
}