using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class PedidoOpcional : IValidar
    {
        public int Id { get; set; }
        public Pedido Pedido { get; set; }
        public Opcional Opcional { get; private set; }

       // public 
        protected PedidoOpcional() { }
               

        public PedidoOpcional(Pedido pedido, Opcional opcional)
        {
            Pedido = pedido;
            Opcional = opcional;
        }

        public bool Validar ()
        {
            return Pedido.Validar() && Opcional.Validar();
        }
    }
}
