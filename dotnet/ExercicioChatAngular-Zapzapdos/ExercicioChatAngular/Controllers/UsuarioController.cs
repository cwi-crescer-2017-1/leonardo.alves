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
            if (user.Id == 0)
            {
                lock (objLock)
                {
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
