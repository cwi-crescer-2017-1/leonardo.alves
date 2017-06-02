using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Web;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace EditoraCrescer.Api.App_Start
{
    public class Autorizacao : AuthorizeAttribute
    {
        private static void negarAcesso(HttpActionContext actionContext)
        {
            actionContext.Response =
                actionContext
                .Request
                .CreateResponse(HttpStatusCode.Unauthorized);
        }
        public override void OnAuthorization(HttpActionContext actionContext)
        {
            if (actionContext.Request.Headers.Authorization == null)
                negarAcesso(actionContext);
            else
            {
                //obtém o parâmetro (token de autenticação)
                string tokenAutenticacao =
                actionContext.Request.Headers.Authorization.Parameter;

                // decodifica o parâmetro, pois ele deve vir codificado em base 64
                string decodedTokenAutenticacao =
                    Encoding.Default.GetString(Convert.FromBase64String(tokenAutenticacao));

                // obtém o login e senha (usuario:senha)
                string[] userNameAndPassword = decodedTokenAutenticacao.Split(':');

                string usuario = userNameAndPassword[0];
                string senha = userNameAndPassword[1];

                if (!(usuario == "leo" && senha == "123456"))                
                    negarAcesso(actionContext);                

                //if (Roles != permissoes)
                //    negarAcesso(actionContext);
                

            }
    }
}