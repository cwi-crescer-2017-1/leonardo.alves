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

            string[] papeis = usuario.Permissoes.Select(papel => papel.Nome).ToArray();

            usuario.AtribuirPermissoes(papeis);

            return usuario;
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

        public object Alterar()
        {
            throw new NotImplementedException();
        }

        public void Cadastrar(Usuario usuario)
        {
            throw new NotImplementedException();
        }
    }
}
