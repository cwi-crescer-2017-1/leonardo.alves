public class Golpear extends AcaoOfensiva implements Movimento {
    
    public Golpear(Saint atacante, Saint atacado) {
        super(atacante, atacado);
    }

    public void executar () {        
        causarDano();
    }
    
    protected void causarDano () {
         if(atacado.getDefenderProximoAtaque()){
            atacante.perderVida(atacante.getVida() * 0.25);
            atacado.setDefenderProximoAtaque(false);
        } else {
           atacado.perderVida(verificarDanoComArmadura());
        }    
    }
    
    public boolean equals (Object obj) {
        Golpear outroGolpear = (Golpear) obj;
        return this.atacante.equals(outroGolpear.atacante)
            && this.atacado.equals(outroGolpear.atacado);   
    }
}