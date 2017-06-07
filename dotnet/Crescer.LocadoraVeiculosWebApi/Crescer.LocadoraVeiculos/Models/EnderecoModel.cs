using System;
using System.Collections.Generic;
using System.Linq;
namespace Crescer.LocadoraVeiculos.Models
{
    public class EnderecoModel
    {
        public int Id { get; set; }
        public int Numero { get; set; }

        public string Rua { get; set; }

        public string Cidade { get; set; }

        public string UF { get; set; }

        public string Bairro { get;  set; }
      
    }
}