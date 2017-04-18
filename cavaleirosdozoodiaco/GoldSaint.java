public class GoldSaint extends Saint {
    public GoldSaint(String nome, Armadura armadura) throws Exception {
        super(nome,armadura);
        this.sentidosDespertados = 7;
        if(!armadura.getConstelacao().getNome().equals("Áries")
        && !armadura.getConstelacao().getNome().equals("Touro")
        && !armadura.getConstelacao().getNome().equals("Gêmeos")
        && !armadura.getConstelacao().getNome().equals("Câncer")
        && !armadura.getConstelacao().getNome().equals("Virgem")
        && !armadura.getConstelacao().getNome().equals("Leão")
        && !armadura.getConstelacao().getNome().equals("Libra")
        && !armadura.getConstelacao().getNome().equals("Escorpião")
        && !armadura.getConstelacao().getNome().equals("Sagitário")
        && !armadura.getConstelacao().getNome().equals("Capricórnio")
        && !armadura.getConstelacao().getNome().equals("Aquário")
        && !armadura.getConstelacao().getNome().equals("Peixes")) {
            throw new Exception("Constelação inválida");
        }
    }
}