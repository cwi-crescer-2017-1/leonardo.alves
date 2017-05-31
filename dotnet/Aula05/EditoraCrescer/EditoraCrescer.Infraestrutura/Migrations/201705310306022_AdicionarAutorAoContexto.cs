namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarAutorAoContexto : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Autors", newName: "Autores");
        }
        
        public override void Down()
        {
            RenameTable(name: "dbo.Autores", newName: "Autors");
        }
    }
}
