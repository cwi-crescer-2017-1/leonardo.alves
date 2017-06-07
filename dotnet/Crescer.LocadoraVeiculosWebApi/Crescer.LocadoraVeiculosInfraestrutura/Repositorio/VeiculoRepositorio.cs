using Crescer.LocadoraVeiculos;
using Crescer.LocadoraVeiculosDominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosInfraestrutura.Repositorio
{
    public class VeiculoRepositorio
    {
        Contexto contexto = new Contexto();

        public List<Veiculo> ObterTodos()
        {
            return contexto.Veiculos.ToList();
        }
    }
}
