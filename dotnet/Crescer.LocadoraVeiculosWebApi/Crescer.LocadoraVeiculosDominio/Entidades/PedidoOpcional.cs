using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class PedidoOpcional
    {
        public int Id { get; set; }
        public Pedido Pedido { get; private set; }
        public Opcional Opcional { get; private set; }

        protected PedidoOpcional() { }
    }
}
