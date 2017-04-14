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
    
    public void perderVida(double vidaPerdida){
        this.vida -= vidaPerdida;
        if(this.vida == 0) this.status = Status.DESACORDADO;
        if(this.vida < 0) this.status = Status.MORTO;
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
    
    public Status getStatus () {
        return this.status;
    }
    
    public void setStatus(Status status) {
       this.status = status;
    }
    
    public double getVida () {
        return this.vida;
    }
    
    public Armadura getArmadura () {
        return this.armadura;
    }
    
}