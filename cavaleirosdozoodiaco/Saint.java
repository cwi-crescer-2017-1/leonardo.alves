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
    private static int qtdSaints = 0;
    private static int acumuladorQtdSaints = 0;
    private int id;
    private boolean defenderProximoAtaque;
    public Saint(String nome, Armadura armadura) throws Exception {        
        this.nome = nome;
        this.armadura = armadura;
        this.id = ++acumuladorQtdSaints;
        Saint.qtdSaints++;               
    }
    
    public static int getAcumuladorQtdSaints () {
        return Saint.acumuladorQtdSaints;
    }
    
    protected void finalize () throws Throwable  {
        Saint.qtdSaints--;
    }
    
    public int getId () {
        return this.id;
    }    

    public void vestirArmadura () {
        armaduraVestida = true;
    }
    
    public static int getQtdSaints () {
        return Saint.qtdSaints;
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
    
    public void golpear(Saint atacado) {
        this.adicionarMovimento(new Golpear(this, atacado));
    }
    
    public void atacarDuplamente(Saint atacado) {
        this.adicionarMovimento(new AtaqueDuplo(this, atacado));
    }       
    
    public void setDefenderProximoAtaque(boolean defenderProximoAtaque){
        this.defenderProximoAtaque = defenderProximoAtaque;
    }
    
    public boolean getDefenderProximoAtaque() {
        return this.defenderProximoAtaque;
    }
    
    public boolean equals(Object object) {    
        Saint outroSaint = (Saint)object;
        return this.nome.equals(outroSaint.nome) 
            && this.armadura.equals(outroSaint.armadura) 
            && this.genero.equals(outroSaint.genero)            
            && this.vida == (outroSaint.vida)
            && this.golpeAtual == (outroSaint.golpeAtual)
            && this.movimentoAtual == (outroSaint.movimentoAtual);
             
    }
    
}