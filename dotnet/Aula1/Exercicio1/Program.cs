using System;

namespace Exercicio1
{
    class Program
    {
        static void Main(string[] args)
        {
            var entradas = new int[] { };

            while (true)
            {
                Console.WriteLine("Digite um valor:");
                var tamanho = entradas.Length;

                var entrada = Console.ReadLine();

                if (entrada == "exit") break;
                var entradaAux = new int[tamanho + 1];

                for (int i = 0; i < tamanho; i++)
                {
                    entradaAux[i] = entradas[i];
                }

                entradaAux[tamanho] = int.Parse(entrada);

                entradas = entradaAux;
            }

            foreach (var entrada in entradas)
            {
                Console.WriteLine(entrada);
            }

            Console.ReadKey();
        }
    }
}
