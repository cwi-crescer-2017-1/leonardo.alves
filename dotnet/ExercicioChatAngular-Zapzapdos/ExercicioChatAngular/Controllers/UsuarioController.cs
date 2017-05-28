using ExercicioChatAngular.Models;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace ExercicioChatAngular.Controllers
{
    public class UsuarioController : ApiController
    {
        private static object objLock = new object();

        public static int idUser = 0;
        private static List<Usuario> allUsers = new List<Usuario>();

        public List<Usuario> Get (int? id = null)
        {
            if (id.HasValue)
                return allUsers.Where(user => user.Id == id).ToList();
            else
                return allUsers;
        }

        public IHttpActionResult Post(Usuario user)
        {
            var comparacao = System.StringComparison.OrdinalIgnoreCase;
            
            if (user.Id == 0)
            {
                lock (objLock)
                {
                    var nome = user.Nome;
                    if (string.Equals("andre nunes", nome, comparacao)||
                        string.Equals("andré nunes", nome, comparacao)||
                        string.Equals("andré nune$", nome, comparacao)||
                        string.Equals("andre nune$", nome, comparacao)) 
                            user.Nome = "$$$$$ $$$$$";

                    user.Id = ++idUser;
                    allUsers.Add(user);
                }
                return Ok(user);
            }

            else
                return BadRequest("Algo inesperado aconteceu.");

        }

    }
}
