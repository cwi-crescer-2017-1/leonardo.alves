using System;

namespace Demo1
{
    class CalculoIMC
    {
        public double Altura { get; set; }

        public double Peso { get; set; }

        public CalculoIMC(double altura, double peso)
        {
            Altura = altura;
            Peso = peso;
        }

        public double CalcularIMC ()
        {
            return Peso / Math.Pow(Altura,2);
        }

    }
}
