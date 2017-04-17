public class GoldSaint extends Saint {
    public GoldSaint(String nome, Armadura armadura) throws Exception {
        super(nome,armadura);
        this.sentidosDespertados = 7;
        if(!armadura.getCategoria().equals("Áries")
        && !armadura.getCategoria().equals("Touro")
        && !armadura.getCategoria().equals("Gêmeos")
        && !armadura.getCategoria().equals("Câncer")
        && !armadura.getCategoria().equals("Virgem")
        && !armadura.getCategoria().equals("Leão")
        && !armadura.getCategoria().equals("Libra")
        && !armadura.getCategoria().equals("Escorpião")
        && !armadura.getCategoria().equals("Sagitário")
        && !armadura.getCategoria().equals("Capricórnio")
        && !armadura.getCategoria().equals("Aquário")
        && !armadura.getCategoria().equals("Peixes")) {
            throw new Exception("Constelação inválida");
        }
    }
}