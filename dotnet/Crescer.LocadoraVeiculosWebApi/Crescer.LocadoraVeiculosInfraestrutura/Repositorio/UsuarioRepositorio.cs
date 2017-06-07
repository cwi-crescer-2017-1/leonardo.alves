using Crescer.LocadoraVeiculos;
using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;


namespace Crescer.LocadoraVeiculosInfraestrutura.Repositorio
{
    public class UsuarioRepositorio
    {
        public Contexto contexto = new Contexto();

        public Usuario Obter (string email)
        {
            var usuario = contexto.Usuarios.FirstOrDefault(u => u.Email == email);
            if (usuario == null) return null;

            var permissoes = contexto.Usuarios
                .Where(u => u.Email == email)
                .SelectMany(u => u.Permissoes)
                .Select(u => u.Nome)
                .ToArray();

            string[] papeis = permissoes;

            usuario.AtribuirPermissoes(papeis);

            return usuario;
        }

        public void Cadastrar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        public List<Permissao> pegarPermissoes()
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

        public void Dispose()
        {
            contexto.Dispose();
        }        
    }
}
