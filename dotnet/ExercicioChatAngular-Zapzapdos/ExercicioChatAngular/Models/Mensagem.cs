using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExercicioChatAngular.Models
{
    public class Mensagem
    {
        public string Texto { get; set; }

        public int Id { get; set; }

        public DateTime HoraMensagem { get; set; } 

        public Usuario Usuario { get; set; }
    }
}