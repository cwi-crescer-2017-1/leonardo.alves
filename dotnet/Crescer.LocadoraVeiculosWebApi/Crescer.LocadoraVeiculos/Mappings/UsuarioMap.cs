using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace Crescer.LocadoraVeiculos.Mappings
{
    public class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(x => x.Id);

            Property(x => x.Email).IsRequired().HasMaxLength(130);
            Property(x => x.Senha).IsRequired().HasMaxLength(130);

            HasMany(x => x.Permissoes)
                .WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdUsuario");
                    x.MapRightKey("IdPermissao");
                    x.ToTable("UsuarioPermissao");
                });
        }
    }
}