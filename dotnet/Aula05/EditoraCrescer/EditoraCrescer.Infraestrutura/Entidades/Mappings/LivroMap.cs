using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Mappings
{
    public class LivroMap : EntityTypeConfiguration<Livro>
    {
        public LivroMap()
        {
            ToTable("Livros");

            HasKey(x => x.Isbn);

            Property(l => l.Titulo).IsRequired().HasMaxLength(300);
            Property(l => l.Genero).IsRequired().HasMaxLength(100);
            Property(l => l.Descricao).IsRequired().HasMaxLength(500);
            Property(l => l.Capa).IsRequired().HasMaxLength(500);

            HasRequired(x => x.Autor)
                .WithMany()
                .HasForeignKey(x => x.IdAutor);

            HasOptional(x => x.Revisor)
                .WithMany()
                .HasForeignKey(x => x.IdRevisor);

        }
    }
}
