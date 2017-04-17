public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100;
    private int sentidosDespertados = 5;
    
    public Saint(String nome, Armadura armadura, Genero genero) {
        this.genero = genero;
        this.nome = nome;
        this.armadura = armadura;
    }
    public Saint(String nome, Armadura armadura) {
        
        this.nome = nome;
        this.armadura = armadura;
        
        if(this.armadura.getCategoria() == Categoria.PRATA)
            this.sentidosDespertados = 6;
        else if (this.armadura.getCategoria() == Categoria.OURO) 
            this.sentidosDespertados = 7;
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
    public double getVida () {
        return this.vida;
    }
    
    public Armadura getArmadura () {
        return this.armadura;
    }
    
    public int getSentidosDespertados () {
        return this.sentidosDespertados;
    }
}