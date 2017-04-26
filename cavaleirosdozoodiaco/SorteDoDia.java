public class SorteDoDia  {
    private Sorteador sorteador;
    
    public SorteDoDia(Sorteador sorteador) {
        this.sorteador = sorteador;
    }
    
    public boolean estouComSorte() {
        return sorteador.sortear() % 2 == 0; //50% de chance   
    }
}