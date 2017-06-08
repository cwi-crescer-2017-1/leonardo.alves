using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Pedido : IValidar
    {
        public Cliente Cliente { get; private set; }        
        public Pacote Pacote { get; private set;}
        public List<PedidoOpcional> Opcionais { get; private set; }
        public int Id { get; private set; }
        public Veiculo Veiculo { get; private set; }        
        public DateTime DataPedido { get; private set; }
        public DateTime DataEntregaPrevista { get; private set; }
        public DateTime? DataEntregaReal { get; private set; }

        protected Pedido () { }

        public void Devolver() {
            DataEntregaReal = DateTime.Now;
        }       

        public Pedido(Cliente cliente, Veiculo veiculo, DateTime dataPedido, 
            DateTime dataEntregaPrevista, Pacote pacote = null) {
            Cliente = cliente;
            Pacote = pacote;
            Veiculo = veiculo;
            DataPedido = dataPedido;
            DataEntregaPrevista = dataEntregaPrevista;
            Opcionais = new List<PedidoOpcional>();
        }

        private bool validarTodosOpcionais ()
        {
            foreach (var opcional in Opcionais)
            {
                if (!opcional.Opcional.Validar()) return false;
            }
            return true;
        }

        public bool Validar ()
        {
            return Veiculo.Validar() &&
                Pacote.Validar() &&
                validarTodosOpcionais() &&
                DataEntregaPrevista.Date < DateTime.Now.Date;
        }

        public bool ValidarSemPacote ()
        {
            return Veiculo.Validar() &&                
                validarTodosOpcionais() &&
                DataEntregaPrevista.Date < DateTime.Now.Date;
        }

        public void EhPossivelEssaConfiguracao ()
        {
            foreach (PedidoOpcional pedidoOpcional in Opcionais)
            {
                if (pedidoOpcional.Opcional.Id == 1 && Veiculo.Id == 1)
                    //fiat mobi não aceita reboque
                    throw new CombinacoesImpossiveisException("Não é possível acoplar reboque no Fiat Mobi");

                if (pedidoOpcional.Opcional.Id == 2 && Veiculo.Id == 3)
                    //hilux não pode ter rack
                    throw new CombinacoesImpossiveisException("Hilux não pode ter rack.");

                if (pedidoOpcional.Opcional.Id == 4 && Veiculo.Id != 4)
                    //apenas kombi aceita cabo bateria
                    throw new CombinacoesImpossiveisException("Não é possível levar cabo bateria com esse tipo de veículo, apenas com Kombi.");

                if (pedidoOpcional.Opcional.Id == 3 && Pacote.Id == 3)
                    throw new CombinacoesImpossiveisException("Não é possível adicionar seguro, pois o pacote selecionado já contém seguro.");
            }           
        }

    }

}