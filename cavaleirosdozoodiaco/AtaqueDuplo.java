public class AtaqueDuplo extends AcaoOfensiva implements Movimento {        
    private VerificadorSortear chanceDupla;

    public  AtaqueDuplo (Saint atacante, Saint atacado) {
        super(atacante,atacado);
        this.chanceDupla = new VerificadorSortear(new DadoD3(atacante));
    }
    
    public AtaqueDuplo (Saint atacante, Saint atacado, Sorteador sorteador) {
        super(atacante, atacado);
        this.chanceDupla = new VerificadorSortear(sorteador);
    }
    
    protected void causarDano () {        
        int danoInfligido = verificarDanoComArmadura();
        
        if(atacado.getDefenderProximoAtaque()){
            atacante.perderVida(atacante.getVida() * 0.25);
            atacado.setDefenderProximoAtaque(false);
        } else {
            danoInfligido = definirSeDuplicaDanoOuPerdeVida(danoInfligido);
        }       

        atacado.perderVida(danoInfligido);
    }
    
    private int definirSeDuplicaDanoOuPerdeVida (int danoInfligido) {
        if(chanceDupla.verificarAtaqueDuplo()) {
            danoInfligido *= 2;
        } else {
            atacante.perderVida(atacante.getVida() * 0.05);     
        }
        return danoInfligido;
    }
    
    public void executar () {
        causarDano();
    }
}