using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraestrutura.Entidades;
using System.Net.Http;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio
    {
        private Contexto contexto = new Contexto();


        public void Dispose()
        {
            contexto.Dispose();
        }

        public Usuario Buscar(string email)
        {
            return contexto.Usuarios.FirstOrDefault(u => u.Email == email);
        }

        public void Alterar(Usuario usuario)
        {
            throw new NotImplementedException();
        }

        public void Cadastrar(Usuario usuario)
        {            
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();           
        }
    }
}
