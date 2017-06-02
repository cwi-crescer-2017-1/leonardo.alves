using EditoraCrescer.Api.App_Start;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [Autorizacao(Roles = "Publicador")]
    public class AutController : ApiController
    {
        public HttpResponseMessage Get ()
        {
            return Request.CreateResponse(System.Net.HttpStatusCode.OK);
        }
    }
}