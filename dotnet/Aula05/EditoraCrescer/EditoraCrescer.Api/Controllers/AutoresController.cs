﻿using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Autores")]

    public class AutoresController : ApiController
    {
        private AutorRepositorio _autorRepositorio = new AutorRepositorio();

        [HttpGet]
        public IHttpActionResult ObterAutores ()
        {
            var autores = _autorRepositorio.ObterAutores();
            return Ok(new { data = autores });
        }

        public IHttpActionResult Post(Autor autor)
        {
            var mensagens = new List<string>();

            if (!autor.Validar(out mensagens))
                return BadRequest(string.Join("; ", mensagens.ToArray()));

            _autorRepositorio.Criar(autor);
            return Ok("Autor adicionado.");
        }

        public IHttpActionResult Delete(int id)
        {
            _autorRepositorio.Deletar(id);
            return Ok("Autor deletado.");
        }

        protected override void Dispose(bool disposing)
        {
            _autorRepositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
