public class AtaqueDuplo implements Movimento {    
	private Saint atacante, atacado;	
	private Golpe golpe;
    private SorteDoDia chanceDupla = new SorteDoDia(new ChanceDeAtaqueDuplo(atacante));

    public  AtaqueDuplo (Saint atacante, Saint atacado) {
        this.atacante = atacante;
		this.atacado = atacado;
		this.golpe = atacante.getProximoGolpe();
    }
    
    public void executar () {
        int danoInfligido = golpe.getFatorDano();

		if(chanceDupla.estouComSorte()) {
			danoInfligido *= 2;
		} else {
			atacante.perderVida(atacante.getVida() * 0.05);		
		}

        if(atacante.getArmaduraVestida()) {
            int valorArmadura = atacante.getArmadura().getCategoria().getValor();
            danoInfligido = golpe.getFatorDano() * (1 + valorArmadura);            
        }

        atacado.perderVida(danoInfligido);
    }
}