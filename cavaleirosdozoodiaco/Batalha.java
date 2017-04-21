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
        return this.saintAtacaPrimeiro.getStatus() == Status.VIVO &&
        this.saintAtacaDepois.getStatus() == Status.VIVO;  
    }

    public void iniciar () {        
        boolean saintsEstaoVivos = saintsEstaoVivos();
        boolean saintQueAtacaDepoisAindaEstaVivo;
        while(saintsEstaoVivos) {     
            saintAtacaPrimeiro.getProximoMovimento().executar();
            saintsEstaoVivos = saintsEstaoVivos();      

            if(saintsEstaoVivos){
                saintAtacaDepois.getProximoMovimento().executar();   
            }                                             

        }                         
    }
}