using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Exceções
{
    public class PedidoInvalidoException : Exception
    {
        public PedidoInvalidoException() { }

        public PedidoInvalidoException(string message) : base(message) { }

        public PedidoInvalidoException(string message, Exception innerException)
            : base(message, innerException) { }
    }
}
