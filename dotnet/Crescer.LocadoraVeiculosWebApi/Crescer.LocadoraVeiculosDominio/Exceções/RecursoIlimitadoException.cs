using System;


namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    internal class RecursoIlimitadoException : Exception
    {
        public RecursoIlimitadoException() { }

        public RecursoIlimitadoException(string message) : base(message) { }

        public RecursoIlimitadoException(string message, Exception innerException)
            : base(message, innerException) { }
    }
}
