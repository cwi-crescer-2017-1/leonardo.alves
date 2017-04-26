public class Golpear implements Movimento {
    Golpe golpe;
    Saint atacante, atacado;

    public Golpear(Saint atacante, Saint atacado) {
        this.atacante = atacante;
        this.atacado = atacado;
        this.golpe = atacante.getProximoGolpe();
    }

    public void executar () {
        int danoInfligido = golpe.getFatorDano();
        if(atacante.getArmaduraVestida()) {
            int valorArmadura = atacante.getArmadura().getCategoria().getValor();
            danoInfligido = golpe.getFatorDano() * (1 + valorArmadura);            
        }

        atacado.perderVida(danoInfligido);
    }
    
    public boolean equals (Object obj) {
        Golpear outroGolpear = (Golpear) obj;
        return this.atacante.equals(outroGolpear.atacante)
            && this.atacado.equals(outroGolpear.atacado);   
    }
}