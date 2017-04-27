public class VerificadorSortear  {
    private Sorteador sorteador;

    public VerificadorSortear (Sorteador sorteador){
        this.sorteador = sorteador;
    }
    
    public boolean verificarAtaqueDuplo () {
        return sorteador.sortear() % 2 == 0;
    }
    
    public boolean verificarContraAtaque () {
        return sorteador.sortear() % 3 != 0;
    }
}