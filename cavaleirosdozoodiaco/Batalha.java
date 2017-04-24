public class Batalha {
    private Saint saintAtacaPrimeiro, saintAtacaDepois; 

    public Batalha (Saint saint1, Saint saint2) {
        int categoria1 = saint1.getArmadura().getCategoria().getValor();
        int categoria2 = saint2.getArmadura().getCategoria().getValor(); 
        if(categoria1 >= categoria2) {
            this.saintAtacaPrimeiro = saint1;
            this.saintAtacaDepois = saint2;
        } else {
            this.saintAtacaPrimeiro = saint2;
            this.saintAtacaDepois = saint1;
        }               
    }

    private boolean saintsEstaoVivos() {
        return this.saintAtacaPrimeiro.getStatus() != Status.MORTO &&
        this.saintAtacaDepois.getStatus() != Status.MORTO;  
    }

    public void iniciar () {        
        boolean saintsEstaoVivos = saintsEstaoVivos();        
        while(saintsEstaoVivos) {     
            saintAtacaPrimeiro.getProximoMovimento().executar();
            saintsEstaoVivos = saintsEstaoVivos();

            if(saintsEstaoVivos) saintAtacaDepois.getProximoMovimento().executar();                                           
            saintsEstaoVivos = saintsEstaoVivos();  
        }                         
    }
}