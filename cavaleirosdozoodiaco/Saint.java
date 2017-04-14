public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100;
    
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
    
    public boolean getArmaduraVestida () {
        return armaduraVestida;
    }
    
    public Genero getGenero () {
        return genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}