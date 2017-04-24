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
    private int movimentoAtual = 0;
    private ArrayList<Movimento> movimentos = new ArrayList <> ();
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

    public void adicionarMovimento(Movimento movimento) {
        this.movimentos.add(movimento);
    }

    public Movimento getProximoMovimento() {       
        Movimento movAtual =  getProximoItem(movimentos, movimentoAtual, Movimento.class);
        movimentoAtual++;
        return movAtual;
    }

    private final <T extends Object> T getProximoItem
    (ArrayList <? extends Object>  obj, int acaoAtual, Class<T> type) {
        int posicao = acaoAtual % obj.size();
        return type.cast(obj.get(posicao));
    }

    public String getCSV () {
        StringBuilder csv = new StringBuilder(512);       
        csv.append(this.getNome());
        csv.append(",");
        csv.append(this.getVida());
        csv.append(",");
        csv.append(this.getConstelacao().getNome());
        csv.append(",");
        csv.append(this.getArmadura().getCategoria());
        csv.append(",");
        csv.append(this.getStatus());
        csv.append(",");
        csv.append(this.getGenero());
        csv.append(",");
        csv.append(this.getArmaduraVestida());                    
        return csv.toString();
    }
}