namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ajusteEmCamposObrigatorios : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Permissoes", "Nome", c => c.String(nullable: false));
            AlterColumn("dbo.Usuarios", "Email", c => c.String(nullable: false));
            AlterColumn("dbo.Usuarios", "Senha", c => c.String(nullable: false));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Usuarios", "Senha", c => c.String());
            AlterColumn("dbo.Usuarios", "Email", c => c.String());
            AlterColumn("dbo.Permissoes", "Nome", c => c.String());
        }
    }
}
