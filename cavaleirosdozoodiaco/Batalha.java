public class Batalha {
    private Saint saint1, saint2;  
    private final double dano = 10;
    public Batalha (Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;        
    }
    
    public void iniciar () {
        int categoria1 = saint1.getArmadura().getCategoria().getValor();
        int categoria2 = saint2.getArmadura().getCategoria().getValor();
        
        if (categoria1 >= categoria2)
           saint2.perderVida(dano);
        else if (categoria1 < categoria2) 
           saint1.perderVida(dano);
                      
    }
}