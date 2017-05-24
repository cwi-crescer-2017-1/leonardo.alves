using System;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {            

            Console.WriteLine("Informe sua altura: ");
            var alturaEntrada = Console.ReadLine();

            Console.WriteLine("Informe seu peso: ");
            var pesoEntrada = Console.ReadLine();

            var peso = 0D;
            var altura = double.Parse(alturaEntrada);

            if (!double.TryParse(pesoEntrada, out peso))
                Console.WriteLine("Entrada Inválida");
            else
            {
                var imc = new CalculoIMC(altura, peso);
                Console.WriteLine($"Seu IMC: {imc.CalcularIMC()}");

            }
            Console.ReadKey();
            /* 
            var pessoa = new Pessoa();
            Console.WriteLine("Informe seu nome: ");
            var nome = Console.ReadLine();
            pessoa.Id = 1;
            pessoa.Nascimento = new DateTime(1982, 10, 29);            
            pessoa.Nome = $"Leonardo Alves {pessoa.Id}"
            Console.WriteLine(pessoa.Nome);
            Console.ReadKey();
            */

        }
    }
}
