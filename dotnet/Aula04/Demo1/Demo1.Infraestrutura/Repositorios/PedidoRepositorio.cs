using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.Entidades;
using System.Data.SqlClient;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao =
               "Server=13.65.101.67;User id=leonardo.alves;Password=123456;Database=aluno14db";
        public void Alterar(Pedido pedido)
        {
            var itens = pegarItensPedido(pedido);

            using(var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using(var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "UPDATE Pedido SET NomeCliente = @NomeCliente WHERE Id = @Id";
                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@Id", pedido.Id);

                    comando.ExecuteNonQuery();
                }

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
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                int estoque = 0;
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "INSERT INTO Pedido (NomeCliente) VALUES (@NomeCliente)"; 
                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);
                    comando.ExecuteNonQuery();
                }

                using(var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    pedido.Id = (int)(decimal)comando.ExecuteScalar();
                }

                foreach (var item in itens)
                {
                    using(var comando = conexao.CreateCommand())
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

                    using(var comando = conexao.CreateCommand())
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

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE FROM ItemPedido WHERE Id = @Id";
                    comando.Parameters.AddWithValue("@Id", id);

                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE FROM Pedido WHERE Id = @Id";
                    comando.Parameters.AddWithValue("@Id", id);

                    comando.ExecuteNonQuery();
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            List<Pedido> lista = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT pedido.Id, pedido.NomeCliente FROM Pedido";
                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {

                        lista.Add(new Pedido
                        {
                            Id = (int)dataReader["Id"],
                            NomeCliente = (string)dataReader["NomeCliente"],
                            Itens = new List<ItemPedido>()
                        });
                    }
                    dataReader.Close();
                }

                for (int i = 0; i < lista.Count; i++)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = "SELECT pedidoid, produtoid, quantidade FROM itempedido where pedidoid = @PedidoId";
                        comando.Parameters.AddWithValue("@PedidoId", lista[i].Id);
                    var dr = comando.ExecuteReader();
                        while (dr.Read())
                        {
                            var itemPedido = new ItemPedido();
                            itemPedido.Id = (int)dr["pedidoid"];
                            itemPedido.ProdutoId = (int)dr["produtoid"];
                            itemPedido.Quantidade = (int)dr["quantidade"];
                            lista[i].Itens.Add(itemPedido);
                        }
                        dr.Close();
                    }                    
                }
                

            }

            return lista;
        }

        public Pedido Obter(int id)
        {
            Pedido pedido = null;
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT Id, NomeCliente FROM Pedido WHERE Id = @Id";
                    comando.Parameters.AddWithValue("@Id", id);

                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        pedido = new Pedido();
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = new List<ItemPedido>();
                                                   
                    }
                    dataReader.Close();                   
                }

                using(var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT pedidoid, produtoid, quantidade FROM itempedido where pedidoid = @PedidoId";
                    comando.Parameters.AddWithValue("@PedidoId", pedido.Id);
                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var itemPedido = new ItemPedido();
                        itemPedido.Id = (int)dataReader["pedidoid"];
                        itemPedido.ProdutoId = (int)dataReader["produtoid"];
                        itemPedido.Quantidade = (int)dataReader["quantidade"];
                        pedido.Itens.Add(itemPedido);
                    }

                }
            }
            return pedido;
        }

        private List<ItemPedido> pegarItensPedido(Pedido pedido)
        {
            return pedido.Itens.ToList();
        }



    }  
}
