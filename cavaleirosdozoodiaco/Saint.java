import java.security.InvalidParameterException;
import java.util.ArrayList;
public abstract class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100;
    private int golpeAtual = 0;
    protected int sentidosDespertados;  

    public Saint(String nome, Armadura armadura) throws Exception {        
        this.nome = nome;
        this.armadura = armadura;
    }
    
     public void vestirArmadura () {
        armaduraVestida = true;
    }
    
    public void perderVida(double vidaPerdida) throws InvalidParameterException{
        if(vidaPerdida < 0) throw new InvalidParameterException("o dano não pode ser negativo");
        if(this.vida - vidaPerdida < 1) {
            this.status = Status.MORTO;
            this.vida = 0;            
        } else this.vida -= vidaPerdida;
        
               
    }
    
    public boolean getArmaduraVestida () {
        return armaduraVestida;
    }
    
    public Genero getGenero () {
        return genero;
    }

    public String getNome () {
        return this.nome;
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
    
    private Constelacao getConstelacao() {
        return this.armadura.getConstelacao();
    }
    
    public ArrayList<Golpe> getGolpes() {
        return getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe){
        getConstelacao().adicionarGolpe(golpe);
    }
    public Golpe getProximoGolpe () {               
        ArrayList<Golpe> golpes = getConstelacao().getGolpes();       
        Golpe golpe = getProximoItem(golpes, golpeAtual, Golpe.class); 
        golpeAtual++;
        return golpe;      
    }
    
    private final <T extends Object> T getProximoItem
        (ArrayList <? extends Object>  obj, int acaoAtual, Class<T> type) {
        int posicao = acaoAtual % obj.size();
        return type.cast(obj.get(posicao));
    }
    
    public String getCSV () {
        String csv =
        this.getNome() + "," +
                this.getVida() + "," +
                this.getConstelacao().getNome() + "," +
                this.getArmadura().getCategoria().toString() + "," +
                this.getStatus().toString() + "," +
                this.getGenero().toString() + "," +
                this.getArmaduraVestida();  
        return csv;
    }
}