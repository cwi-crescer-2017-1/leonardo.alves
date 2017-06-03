namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarCampoNomeAoUsuario : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Usuarios", "Nome", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Usuarios", "Nome");
        }
    }
}
