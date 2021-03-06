﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Crescer.LocadoraVeiculosDominio.Entidades
{
    public class Opcional : IValidar
    {
        public int Id { get; private set; }

        public string Descricao { get; private set; }

        public decimal Preco { get; private set; }

        public int? Quantidade { get; private set; }

        protected Opcional() { }
        
        public Opcional (int id, string descricao, decimal preco, int? quantidade)
        {
            Id = id;
            Descricao = descricao;
            Preco = preco;
            Quantidade = quantidade;
        }        

        public void diminuirEstoque()
        {
            if (Quantidade > 0 && Id != 3) Quantidade--;           

            else
                throw new ForaDeEstoqueException("Não há estoque para esse opcional!");
        }

        public void aumentarEstoque ()
        {
            if (Quantidade >= 0) Quantidade++;          
                
        }

        public bool Validar ()
        {
            return !string.IsNullOrWhiteSpace(Descricao) &&
                Preco > 0;
        }


    }
}
