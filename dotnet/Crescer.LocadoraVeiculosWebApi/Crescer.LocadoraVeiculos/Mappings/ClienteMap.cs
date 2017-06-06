using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace Crescer.LocadoraVeiculos.Mappings
{
    public class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");

            HasKey(x => x.Id);

            Property(c => c.Cpf).IsRequired().HasMaxLength(11);
            Property(c => c.NomeCompleto).IsRequired().HasMaxLength(100);
            Property(c => c.Genero).IsRequired();


            HasRequired(x => x.Endereco)
                .WithMany()
                .HasForeignKey(x => x.IdEndereco);

        }
    }
}