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
            var pedido = contexto.Pedidos
                .AsNoTracking()                
                .Include(p => p.Opcionais.Select(o => o.Opcional))
                .Include(p => p.Pacote)
                .Include(p => p.Veiculo)
                .Where(p => p.Cliente.Cpf == cpf && p.DataEntregaReal == null)
                .OrderByDescending(p => p.DataPedido)
                .FirstOrDefault();

            if (pedido != null) pedido.anularReferenciaCircular();

            return pedido;
            
        }

        public List<Pedido> ObterPedidosMensais (DateTime data)
        {          
            var pedidos = contexto.Pedidos  
                .Include(p => p.Opcionais.Select(o => o.Opcional))
                .Include(p => p.Pacote)
                .Include(p => p.Veiculo)              
                .Where(p => DbFunctions.DiffDays(data, p.DataEntregaReal) <= 30 && 
                        p.DataEntregaReal != null)
                .ToList();

            pedidos.ForEach(p => p.anularReferenciaCircular());

            return pedidos;
        }

        public List<Pedido> ObterPedidosAtrasados()
        {
            //retorna os pedidos que nao foram entregados e que já passaram da data de entrega prevista
            var pedidos = contexto.Pedidos
                .Include(p => p.Cliente)
                .Where(p => DbFunctions.DiffDays(p.DataEntregaPrevista, DateTime.Now) > 0 &&
                        p.DataEntregaReal == null)
                .OrderByDescending(p => DbFunctions.DiffDays(DateTime.Now, p.DataEntregaPrevista))
                .ToList();            

            return pedidos;
        }

        public void Devolver(int id)
        {
            var pedido = contexto.Pedidos
                .Include(p => p.Veiculo)
                .Include(p => p.Opcionais.Select(o => o.Opcional))
                .FirstOrDefault(x => x.Id == id);
            
            pedido.Veiculo.aumentarEstoque();
            pedido.Opcionais.ForEach(o => o.Opcional.aumentarEstoque());
            pedido.Devolver();

            contexto.SaveChanges();
        }

        public void GerarPedido(string cpf, int idVeiculo, int? idPacote, int [] idOpcional, DateTime dataEntrega)
        {
            Pacote pacote = null;
            var opcionais = new List<PedidoOpcional>();
            //pega cliente e veiculo pelo id
            var cliente = contexto.Clientes.FirstOrDefault(c => c.Cpf == cpf);
            var veiculo = contexto.Veiculos.FirstOrDefault(v => v.Id == idVeiculo);

            if(idPacote != null)
                pacote = contexto.Pacotes.FirstOrDefault(p => p.Id == idPacote);

            //cria o pedido
            var pedido = new Pedido(cliente, veiculo, DateTime.Now, dataEntrega, pacote);

            foreach (var id in idOpcional)
            {
                var opcional = contexto.Opcionais.FirstOrDefault(o => o.Id == id);
                opcional.diminuirEstoque();
                pedido.Opcionais.Add(new PedidoOpcional(pedido, opcional));

            }

            veiculo.diminuirEstoque();

            pedido.EhPossivelEssaConfiguracao();

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
