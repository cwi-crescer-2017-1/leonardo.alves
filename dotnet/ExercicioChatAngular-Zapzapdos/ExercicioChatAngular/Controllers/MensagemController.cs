using ExercicioChatAngular.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExercicioChatAngular.Controllers
{    
    public class MensagemController : ApiController
    {
        private static object objLock = new object();

        private static int idMensagem = 0;
        private static List<Mensagem> allMessages = new List<Mensagem>();

        public List<Mensagem> Get ()
        {            
            return allMessages;            
        }


        public IHttpActionResult Post (Mensagem mensagem)
        {
            if (mensagem.Id == 0)
            {
                lock (objLock)
                {
                    mensagem.Id = ++idMensagem;
                    allMessages.Add(mensagem);
                }
                return Ok("Mensagem enviada.");
            } 
            else
            {
                return BadRequest("Você não deve definir um id para a mensagem.");
            }
        }
    }
}
