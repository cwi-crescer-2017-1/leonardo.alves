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

            Property(l => l.Titulo).IsRequired();
            Property(l => l.Genero).IsRequired();
            Property(l => l.Descricao).IsRequired();
            Property(l => l.Capa).IsRequired();

            HasRequired(x => x.Autor)
                .WithMany()
                .HasForeignKey(x => x.IdAutor);
            HasOptional(x => x.Revisor)
                .WithMany()
                .HasForeignKey(x => x.IdRevisor);
        }
    }
}
