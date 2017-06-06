namespace Crescer.LocadoraVeiculos.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ajustarNomeDoPrecoEmPacote : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Pacote", "PrecoDiaria", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            DropColumn("dbo.Pacote", "Preco");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Pacote", "Preco", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            DropColumn("dbo.Pacote", "PrecoDiaria");
        }
    }
}
