public class Constelacao {
    private String nome;
    private Golpe [] golpes = new Golpe [3];
    private int numeroGolpes = 0;
    public Constelacao(String nome) {
        this.nome = nome;
    }
    

    public void adicionarGolpe(Golpe golpe) {
       if(numeroGolpes <= golpes.length - 1){
           this.golpes[numeroGolpes] = golpe;
           this.numeroGolpes++;
        }        
    }
    

    public Golpe [] getGolpes () {
        return this.golpes;
    }
    
    public String getNome () {
        return this.nome;
    }
}