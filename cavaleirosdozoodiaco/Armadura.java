public class Armadura {
    
    private Constelacao constelacao;
    private Categoria categoria;
    
    public Armadura(Constelacao constelacao, Categoria categoria) {
        this.constelacao = constelacao;
        this.categoria = categoria;
    }
    
    public Categoria getCategoria () {
        return this.categoria;
    }
    
    public Constelacao getConstelacao () {
        return this.constelacao;
   }
   
   public boolean equals (Object object) {
       Armadura outraArmadura = (Armadura) object;
       
       return this.constelacao.getNome().equals(outraArmadura.constelacao.getNome())
            && this.categoria.equals(outraArmadura.categoria);
   }
}