using System;


namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class CombinacoesImpossiveisException : Exception
    {
        public CombinacoesImpossiveisException() { }

        public CombinacoesImpossiveisException(string message) : base(message) { }

        public CombinacoesImpossiveisException(string message, Exception innerException)
            : base(message, innerException) { }
    }
}
