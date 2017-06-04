using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraestrutura.Entidades;
using System.Net.Http;
using System.Threading;

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
            var usuario = contexto.Usuarios.FirstOrDefault(u => u.Email == email);
            if (usuario == null) return null;
            var permissoes = contexto.Usuarios
                .Where(u => u.Email == email)
                .SelectMany(u => u.Permissoes)
                .ToList();
                

            if(permissoes != null)
                usuario.Permissoes = permissoes;       

            return usuario;
        }

        public List<Permissao> pegarPermissoes ()
        {
            List<Permissao> permissoes = new List<Permissao>();
            foreach (var permissao in contexto.Usuarios.SelectMany(u => u.Permissoes).ToList())
            {
                if (Thread.CurrentPrincipal.IsInRole(permissao.Nome))
                {
                    permissoes.Add(permissao);
                }

            }
            return permissoes;

        }

        public void Alterar(Usuario usuario)
        {
            throw new NotImplementedException();
        }

        public void Cadastrar(Usuario usuario)
        {            
            contexto.Usuarios.Add(usuario);
            //Aqui vai o serviço de email!
            contexto.SaveChanges();           
        }
    }
}
