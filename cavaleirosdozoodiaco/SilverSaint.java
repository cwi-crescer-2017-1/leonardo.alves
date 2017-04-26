public class SilverSaint extends Saint {
    
    public SilverSaint(String nome, String constelacao) throws Exception {
        super(nome, new Armadura(new Constelacao(constelacao), Categoria.PRATA));        
        super.sentidosDespertados = 6;
    }    
}