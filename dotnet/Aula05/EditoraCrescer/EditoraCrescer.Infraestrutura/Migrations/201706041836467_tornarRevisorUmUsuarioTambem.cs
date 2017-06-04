namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class tornarRevisorUmUsuarioTambem : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            AddColumn("dbo.Livros", "Revisor_Id", c => c.Int());
            CreateIndex("dbo.Livros", "Revisor_Id");
            AddForeignKey("dbo.Livros", "Revisor_Id", "dbo.Usuarios", "Id");
            DropTable("dbo.Revisores");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.Revisores",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            DropForeignKey("dbo.Livros", "Revisor_Id", "dbo.Usuarios");
            DropIndex("dbo.Livros", new[] { "Revisor_Id" });
            DropColumn("dbo.Livros", "Revisor_Id");
            CreateIndex("dbo.Livros", "IdRevisor");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores", "Id");
        }
    }
}
