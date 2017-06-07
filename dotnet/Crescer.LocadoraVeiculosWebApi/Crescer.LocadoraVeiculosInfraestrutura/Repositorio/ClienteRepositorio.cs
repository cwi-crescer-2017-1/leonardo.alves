using Crescer.LocadoraVeiculos;
using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosInfraestrutura.Repositorio
{
    public class ClienteRepositorio
    {
        Contexto contexto = new Contexto();

        public Cliente Obter(string cpf)
        {
            return contexto.Clientes.FirstOrDefault(c => c.Cpf == cpf);
        }

        public void Cadastrar(Cliente cliente)  {
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
        }

    }
}
