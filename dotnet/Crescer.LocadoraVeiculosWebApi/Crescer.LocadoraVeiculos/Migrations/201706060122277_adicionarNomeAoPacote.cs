namespace Crescer.LocadoraVeiculos.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarNomeAoPacote : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Pacote", "Nome", c => c.String(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Pacote", "Nome");
        }
    }
}
