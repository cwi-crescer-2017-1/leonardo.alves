namespace Crescer.LocadoraVeiculos.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ajustarNomeNaTabelaVeiculoSobreAdicional : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Veiculo", "AdicionalDiaria", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            DropColumn("dbo.Veiculo", "AdicionarDiaria");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Veiculo", "AdicionarDiaria", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            DropColumn("dbo.Veiculo", "AdicionalDiaria");
        }
    }
}
