﻿using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();
        
        public List<Revisor> ObterRevisores ()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor ObterRevisor (int id)
        {
            return contexto.Revisores.FirstOrDefault(r => r.Id == id);
        }

        public void Criar (Revisor revisor)
        {
            contexto.Revisores.Add(revisor);            
            contexto.SaveChanges();          
        }

        public void Deletar (int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Remove(revisor);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
