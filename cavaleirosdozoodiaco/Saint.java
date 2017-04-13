public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    
    public Saint(String nome, Armadura armadura, Genero genero) {
        this.genero = genero;
        this.nome = nome;
        this.armadura = armadura;
    }
    public Saint(String nome, Armadura armadura) {
        
        this.nome = nome;
        this.armadura = armadura;
    }
    
     public void vestirArmadura () {
        armaduraVestida = true;
    }
    
}