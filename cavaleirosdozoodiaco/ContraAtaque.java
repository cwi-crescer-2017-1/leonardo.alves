public class ContraAtaque implements Movimento {
    private Saint atacante, atacado;
    Golpe golpeAtacante, golpeAtacado;
    VerificadorSortear chanceContraAtaque;
    
    public ContraAtaque (Saint atacante, Saint atacado) {
        this.atacante = atacante;
        this.atacado = atacado;        
        this.chanceContraAtaque = new VerificadorSortear(new DadoD3(atacado));
    }
    
    public ContraAtaque (Saint atacante, Saint atacado, Sorteador sorteador) {
        this.atacante = atacante;
        this.atacado = atacado;        
        this.chanceContraAtaque = new VerificadorSortear(sorteador);
    }
    
    public void executar (){        
    }
}