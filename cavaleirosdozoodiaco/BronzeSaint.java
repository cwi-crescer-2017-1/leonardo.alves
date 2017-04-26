public class BronzeSaint extends Saint {    

    public BronzeSaint(String nome, String constelacao) throws Exception {
        super(nome, new Armadura(new Constelacao(constelacao), Categoria.BRONZE));
        super.sentidosDespertados = 5;
    }
}	