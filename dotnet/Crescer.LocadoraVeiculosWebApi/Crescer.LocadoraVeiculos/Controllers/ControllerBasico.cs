

using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Crescer.LocadoraVeiculos.Controllers
{
    public class ControllerBasico  : ApiController
    {
        public HttpResponseMessage MensagemErro(dynamic mensagens)
        {
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = mensagens });
        }

        public HttpResponseMessage MensagemSucesso(dynamic dados)
        {
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = dados });
        }
    }
}