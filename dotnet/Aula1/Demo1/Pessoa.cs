using System;

namespace Demo1
{
    public class Pessoa
    {
        public readonly double PIreadonly;


        public Pessoa()
        {
            //pode ser definido dentro do construtor, mas em métodos não.   
            PIreadonly = 3.14;
        }

        public const double PI = 3.14;


        public string Nome { get; set; }

        public int Id { get; set; }

        public DateTime Nascimento { get; set; }
    }
}
