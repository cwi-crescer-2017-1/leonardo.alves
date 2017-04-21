public class GoldSaint extends Saint {
    
    public GoldSaint(String nome, String constelacao) throws Exception {
        super(nome, new Armadura(new Constelacao(constelacao), Categoria.OURO));
        super.sentidosDespertados = 7;
        if(!getArmadura().getConstelacao().getNome().equals("Áries")
        && !getArmadura().getConstelacao().getNome().equals("Touro")
        && !getArmadura().getConstelacao().getNome().equals("Gêmeos")
        && !getArmadura().getConstelacao().getNome().equals("Câncer")
        && !getArmadura().getConstelacao().getNome().equals("Virgem")
        && !getArmadura().getConstelacao().getNome().equals("Leão")
        && !getArmadura().getConstelacao().getNome().equals("Libra")
        && !getArmadura().getConstelacao().getNome().equals("Escorpião")
        && !getArmadura().getConstelacao().getNome().equals("Sagitário")
        && !getArmadura().getConstelacao().getNome().equals("Capricórnio")
        && !getArmadura().getConstelacao().getNome().equals("Aquário")
        && !getArmadura().getConstelacao().getNome().equals("Peixes")) {
            throw new Exception("Constelação inválida");
        }        
    }
    
    public String getNome () {
        return super.getNome() + "!!!";
    }
}