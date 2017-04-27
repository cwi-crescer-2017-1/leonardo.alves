public abstract class AcaoOfensiva {
    Saint atacante, atacado;
    Golpe golpe;
    
    public AcaoOfensiva (Saint atacante, Saint atacado) {
        this.atacante = atacante;
        this.atacado = atacado;
        this.golpe = atacante.getProximoGolpe();
    }
    
    public int verificarDanoComArmadura () {  
        int danoInfligido = golpe.getFatorDano(); 
        if(atacante.getArmaduraVestida()) {
            int valorArmadura = atacante.getArmadura().getCategoria().getValor();
            danoInfligido = golpe.getFatorDano() * (1 + valorArmadura);            
        }
        return danoInfligido;
    }
    
    protected abstract void causarDano ();
}