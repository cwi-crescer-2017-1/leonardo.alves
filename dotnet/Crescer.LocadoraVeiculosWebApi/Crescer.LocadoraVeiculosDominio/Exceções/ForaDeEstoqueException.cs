using System;


namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class ForaDeEstoqueException : Exception
    {
        public ForaDeEstoqueException() { }

        public ForaDeEstoqueException(string message) : base(message) { }

        public ForaDeEstoqueException(string message, Exception innerException)
            : base(message, innerException) { }
    }
}
