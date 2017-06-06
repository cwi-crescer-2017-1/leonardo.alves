
using Crescer.LocadoraVeiculos.Mappings;
using Crescer.LocadoraVeiculosDominio.Entidades;
using System.Data.Entity;

namespace Crescer.LocadoraVeiculos
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=LocadoraCrescer") { }

        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Endereco> Enderecos { get; set; }       
        public DbSet<Opcional> Opcionais { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }
        public DbSet<Pedido> Pedidos { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Veiculo> Veiculos { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {            
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new EnderecoMap());
            modelBuilder.Configurations.Add(new OpcionalMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new PedidoMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new VeiculoMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
        }

    }
}