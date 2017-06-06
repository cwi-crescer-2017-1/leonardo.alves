namespace Crescer.LocadoraVeiculos.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarTabelasIniciais : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NomeCompleto = c.String(nullable: false, maxLength: 100),
                        IdEndereco = c.Int(nullable: false),
                        Cpf = c.String(nullable: false, maxLength: 11),
                        Genero = c.Int(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Endereco", t => t.IdEndereco, cascadeDelete: true)
                .Index(t => t.IdEndereco);
            
            CreateTable(
                "dbo.Endereco",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Numero = c.Int(nullable: false),
                        Rua = c.String(nullable: false, maxLength: 100),
                        Cidade = c.String(nullable: false, maxLength: 100),
                        UF = c.String(nullable: false),
                        Bairro = c.String(nullable: false, maxLength: 100),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Opcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(nullable: false, maxLength: 400),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(nullable: false),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedido",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdCliente = c.Int(nullable: false),
                        IdPacote = c.Int(),
                        IdVeiculo = c.Int(nullable: false),
                        DataPedido = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaReal = c.DateTime(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdPacote)
                .ForeignKey("dbo.Veiculo", t => t.IdVeiculo, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacote)
                .Index(t => t.IdVeiculo);
            
            CreateTable(
                "dbo.Veiculo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(nullable: false, maxLength: 500),
                        Estoque = c.Int(nullable: false),
                        PrecoDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                        AdicionarDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Email = c.String(nullable: false, maxLength: 130),
                        Senha = c.String(nullable: false, maxLength: 130),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 50),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PedidoOpcional",
                c => new
                    {
                        IdPedido = c.Int(nullable: false),
                        IdOpcional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPedido, t.IdOpcional })
                .ForeignKey("dbo.Pedido", t => t.IdPedido, cascadeDelete: true)
                .ForeignKey("dbo.Opcional", t => t.IdOpcional, cascadeDelete: true)
                .Index(t => t.IdPedido)
                .Index(t => t.IdOpcional);
            
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Pedido", "IdVeiculo", "dbo.Veiculo");
            DropForeignKey("dbo.Pedido", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.PedidoOpcional", "IdOpcional", "dbo.Opcional");
            DropForeignKey("dbo.PedidoOpcional", "IdPedido", "dbo.Pedido");
            DropForeignKey("dbo.Pedido", "IdCliente", "dbo.Cliente");
            DropForeignKey("dbo.Cliente", "IdEndereco", "dbo.Endereco");
            DropIndex("dbo.UsuarioPermissao", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IdUsuario" });
            DropIndex("dbo.PedidoOpcional", new[] { "IdOpcional" });
            DropIndex("dbo.PedidoOpcional", new[] { "IdPedido" });
            DropIndex("dbo.Pedido", new[] { "IdVeiculo" });
            DropIndex("dbo.Pedido", new[] { "IdPacote" });
            DropIndex("dbo.Pedido", new[] { "IdCliente" });
            DropIndex("dbo.Cliente", new[] { "IdEndereco" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.PedidoOpcional");
            DropTable("dbo.Permissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Veiculo");
            DropTable("dbo.Pedido");
            DropTable("dbo.Pacote");
            DropTable("dbo.Opcional");
            DropTable("dbo.Endereco");
            DropTable("dbo.Cliente");
        }
    }
}
