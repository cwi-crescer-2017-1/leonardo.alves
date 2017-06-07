using Crescer.LocadoraVeiculos;
using Crescer.LocadoraVeiculosDominio.Entidades;
using Crescer.LocadoraVeiculosDominio.Exceções;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosInfraestrutura.Repositorio
{
    public class PedidoRepositorio
    {
        Contexto contexto = new Contexto();



        public Pedido ObterPedido (string cpf)
        {
            //Pega o ultimo pedido ja feito pelo cliente.            
            return contexto.Pedidos
                .Where(p => p.Cliente.Cpf == cpf && p.DataEntregaReal == null)
                .OrderByDescending(p => p.DataPedido)
                .FirstOrDefault();
        }

        public List<Pedido> ObterPedidosMensais (DateTime data)
        {          
            return contexto.Pedidos                
                .Where(p => DbFunctions.DiffDays(data, p.DataEntregaReal) <= 30 && 
                        p.DataEntregaReal != null)
                .ToList();
        }

        public List<Pedido> ObterPedidosAtrasados()
        {
            //retorna os pedidos que nao foram entregados e que já passaram da data de entrega prevista
            return contexto.Pedidos
                .Where(p => DbFunctions.DiffDays(DateTime.Now, p.DataEntregaPrevista) > 0 &&
                        p.DataEntregaReal == null)
                .OrderByDescending(p => DbFunctions.DiffDays(DateTime.Now, p.DataEntregaPrevista))
                .ToList();                
        }

        public void GerarPedido(int idCliente, int idVeiculo, int? idPacote, int [] idOpcional, DateTime dataEntrega)
        {
            Pacote pacote = null;
            var opcionais = new List<PedidoOpcional>();
            //pega cliente e veiculo pelo id
            var cliente = contexto.Clientes.FirstOrDefault(c => c.Id == idCliente);
            var veiculo = contexto.Veiculos.FirstOrDefault(v => v.Id == idVeiculo);

            if(idPacote != null)
                pacote = contexto.Pacotes.FirstOrDefault(p => p.Id == idPacote);

            //cria o pedido
            var pedido = new Pedido(cliente, veiculo, DateTime.Now, dataEntrega, pacote);

            foreach (var id in idOpcional)
            {
                var opcional = contexto.Opcionais.AsNoTracking().FirstOrDefault(o => o.Id == id);
                pedido.Opcionais.Add(new PedidoOpcional(pedido, opcional));
            }

            contexto.Pedidos.Add(pedido);

            if (pacote != null)
            {
                if(pacote.Validar())
                    contexto.SaveChanges();
            }
            else if (pedido.ValidarSemPacote())
            {
                contexto.SaveChanges();
            }
            else throw new PedidoInvalidoException(                
            @"Verifique se os dados no veículo, nos opcionais e no pacote estão corretos.
            Talvez esse erro ocorra caso a data prevista inserida seja anterior ao dia de hoje.");         
        }
    }
}
