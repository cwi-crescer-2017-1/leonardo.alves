namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarlimiteAsPropriedadesDoLivro : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Livros", "Titulo", c => c.String(nullable: false, maxLength: 300));
            AlterColumn("dbo.Livros", "Descricao", c => c.String(nullable: false, maxLength: 500));
            AlterColumn("dbo.Livros", "Genero", c => c.String(nullable: false, maxLength: 100));
            AlterColumn("dbo.Livros", "Capa", c => c.String(nullable: false, maxLength: 500));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Livros", "Capa", c => c.String(nullable: false));
            AlterColumn("dbo.Livros", "Genero", c => c.String(nullable: false));
            AlterColumn("dbo.Livros", "Descricao", c => c.String(nullable: false));
            AlterColumn("dbo.Livros", "Titulo", c => c.String(nullable: false));
        }
    }
}
