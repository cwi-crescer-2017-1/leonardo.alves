using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class ItemPedidoRepositorio
    {
        string stringConexao =
             "Server=13.65.101.67;User id=leonardo.alves;Password=123456;Database=aluno14db";
        public void Alterar(Pedido pedido)
        {
            var itens = pegarItensPedido(pedido);
            using (var conexao = new SqlConnection(stringConexao))
            {
                for (var i = 0; i < itens.Count; i++)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                            "UPDATE ItemPedido SET ProdutoId = @ProdutoId, Quantidade = @Quantidade WHERE pedidoid = @PedidoId";
                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@ProdutoId", itens[i].ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", itens[i].Quantidade);

                        comando.ExecuteNonQuery();
                    }
                }
            }
           
        }



        public void Criar(Pedido pedido)
        {
            var itens = pegarItensPedido(pedido);
            int estoque = 0;
            using (var conexao = new SqlConnection(stringConexao))
            {

                foreach (var item in itens)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                            "SELECT Estoque FROM Protudo WHERE Id =  @Id";
                        comando.Parameters.AddWithValue("@Id", item.ProdutoId);
                        var dataReader = comando.ExecuteReader();
                        while (dataReader.Read())
                        {
                            estoque = (int)dataReader["Estoque"];
                            if (estoque < item.Quantidade)
                                return;
                        }
                    }

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                            @"INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) 
                                    VALUES (@PedidoId, @ProdutoId, @Quantidade)";

                        comando.Parameters.AddWithValue("@ProdutoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", item.Quantidade);
                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);

                        comando.ExecuteNonQuery();
                    }

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                            @"UPDATE Produto SET Estoque = @NovoEstoque WHERE Id = @Id";
                        comando.Parameters.AddWithValue("@Id", item.ProdutoId);
                        comando.Parameters.AddWithValue("@NovoEstoque", estoque - item.Quantidade);
                    }

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = "SELECT @@IDENTITY";

                        item.Id = (int)(decimal)comando.ExecuteScalar();
                    }
                }
            }
        }

        public void Excluir(int id)
        {
            using(var conexao = new SqlConnection(stringConexao))
            {
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE FROM ItemPedido WHERE Id = @Id";
                    comando.Parameters.AddWithValue("@Id", id);

                    comando.ExecuteNonQuery();
                }
            }
        }

        private List<ItemPedido> pegarItensPedido(Pedido pedido)
        {
            return pedido.Itens.ToList();
        }

    }
}
