namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ajustarCamposObrigatoriosEmLivro : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Livros", "Titulo", c => c.String(nullable: false));
            AlterColumn("dbo.Livros", "Descricao", c => c.String(nullable: false));
            AlterColumn("dbo.Livros", "Genero", c => c.String(nullable: false));
            AlterColumn("dbo.Livros", "Capa", c => c.String(nullable: false));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Livros", "Capa", c => c.String());
            AlterColumn("dbo.Livros", "Genero", c => c.String());
            AlterColumn("dbo.Livros", "Descricao", c => c.String());
            AlterColumn("dbo.Livros", "Titulo", c => c.String());
        }
    }
}
