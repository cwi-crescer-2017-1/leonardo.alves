using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosInfraestrutura.Mappings
{
    public class PedidoOpcionalMap : EntityTypeConfiguration<PedidoOpcional>
    {
        public PedidoOpcionalMap()
        {
            ToTable("PedidoOpcional");

            HasKey(x => x.Id);  
        }
    }
}
