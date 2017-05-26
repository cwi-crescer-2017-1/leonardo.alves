using Aula03Exemplo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Aula03Exemplo.Controllers
{
    public class HeroisController : ApiController
    {
        private static object objLock = new object();
        private static int idHerois = 0;
        private static List<Heroi> herois = new List<Heroi>()
            {
                new Heroi() { Id = ++idHerois, Nome = "Bruce Bane", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Diana Prince", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Oliver Queen", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Ray Palmer", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Zatanna Zatara", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Zatanna Zatara", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Cindy Reynolds", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Linda Strauss", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Hugh Dawkins", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Maxima de Almerac", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Connor Hawke", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Patrick O'Brien", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Cassandra Cain", Poder = new Poder() {Nome = "Tey", Dano = 1000} },
                new Heroi() { Id = ++idHerois, Nome = "Hal Jordan", Poder = new Poder() {Nome = "Tey", Dano = 1000} }
            };
        public List<Heroi> Get(int? id = null)
        {            
            if(!id.HasValue) return herois;
            return herois.Where(h => h.Id == id).ToList();
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi.Id == 0)
            {
                lock (objLock)
                {
                    heroi.Id = ++idHerois;
                    herois.Add(heroi);
                }
                
                return Ok("Heroi adicionado com sucesso: " + heroi.Nome);
            }

            else
                return BadRequest();
        }
    }
}
