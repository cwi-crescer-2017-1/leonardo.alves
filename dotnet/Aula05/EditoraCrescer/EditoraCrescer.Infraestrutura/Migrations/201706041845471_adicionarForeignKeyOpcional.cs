namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarForeignKeyOpcional : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Livros", "IdRevisor");
            RenameColumn(table: "dbo.Livros", name: "Revisor_Id", newName: "IdRevisor");
            RenameIndex(table: "dbo.Livros", name: "IX_Revisor_Id", newName: "IX_IdRevisor");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.Livros", name: "IX_IdRevisor", newName: "IX_Revisor_Id");
            RenameColumn(table: "dbo.Livros", name: "IdRevisor", newName: "Revisor_Id");
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int());
        }
    }
}
