public class Golpear implements Movimento {
    Golpe golpe;
    Saint atacante, atacado;

    public Golpear(Saint atacante, Saint atacado) {
        this.atacante = atacante;
        this.atacado = atacado;
        this.golpe = atacante.getProximoGolpe();
    }

    public void executar () {

        if(atacante.getArmaduraVestida() ){
            int valorArmadura = atacante.getArmadura().getCategoria().getValor();
            int novoFatorDano = golpe.getFatorDano() * (1 + valorArmadura);
            golpe.setFatorDano(novoFatorDano);
        }

        atacado.perderVida(golpe.getFatorDano());
    }
}