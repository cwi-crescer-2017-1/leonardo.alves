using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;

namespace Crescer.LocadoraVeiculos.Controllers
{
    internal interface IMensagens 
    {

        HttpResponseMessage MensagemErro(dynamic mensagens);
        HttpResponseMessage MensagemSucesso(dynamic dados);      

    }
}