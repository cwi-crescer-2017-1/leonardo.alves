public class GoldSaint extends Saint {
    public GoldSaint(String nome, Armadura armadura) throws Exception {
        super(nome,armadura);
        this.sentidosDespertados = 7;
        if(!armadura.getConstelacao().equals("Áries")
        && !armadura.getConstelacao().equals("Touro")
        && !armadura.getConstelacao().equals("Gêmeos")
        && !armadura.getConstelacao().equals("Câncer")
        && !armadura.getConstelacao().equals("Virgem")
        && !armadura.getConstelacao().equals("Leão")
        && !armadura.getConstelacao().equals("Libra")
        && !armadura.getConstelacao().equals("Escorpião")
        && !armadura.getConstelacao().equals("Sagitário")
        && !armadura.getConstelacao().equals("Capricórnio")
        && !armadura.getConstelacao().equals("Aquário")
        && !armadura.getConstelacao().equals("Peixes")) {
            throw new Exception("Constelação inválida");
        }
    }
}