namespace Crescer.LocadoraVeiculos.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarTabelaPedidoOpcionalPersonalizada : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.PedidoOpcional", "IdPedido", "dbo.Pedido");
            DropForeignKey("dbo.PedidoOpcional", "IdOpcional", "dbo.Opcional");
            DropIndex("dbo.PedidoOpcional", new[] { "IdPedido" });
            DropIndex("dbo.PedidoOpcional", new[] { "IdOpcional" });
            DropTable("dbo.PedidoOpcional");

            CreateTable(
                "dbo.PedidoOpcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Opcional_Id = c.Int(nullable: false),
                        Pedido_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Opcional", t => t.Opcional_Id)
                .ForeignKey("dbo.Pedido", t => t.Pedido_Id)
                .Index(t => t.Opcional_Id)
                .Index(t => t.Pedido_Id);
            
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.PedidoOpcional",
                c => new
                    {
                        IdPedido = c.Int(nullable: false),
                        IdOpcional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPedido, t.IdOpcional });
            
            DropForeignKey("dbo.PedidoOpcional", "Pedido_Id", "dbo.Pedido");
            DropForeignKey("dbo.PedidoOpcional", "Opcional_Id", "dbo.Opcional");
            DropIndex("dbo.PedidoOpcional", new[] { "Pedido_Id" });
            DropIndex("dbo.PedidoOpcional", new[] { "Opcional_Id" });
            DropTable("dbo.PedidoOpcional");
            CreateIndex("dbo.PedidoOpcional", "IdOpcional");
            CreateIndex("dbo.PedidoOpcional", "IdPedido");
            AddForeignKey("dbo.PedidoOpcional", "IdOpcional", "dbo.Opcional", "Id", cascadeDelete: true);
            AddForeignKey("dbo.PedidoOpcional", "IdPedido", "dbo.Pedido", "Id", cascadeDelete: true);
        }
    }
}
