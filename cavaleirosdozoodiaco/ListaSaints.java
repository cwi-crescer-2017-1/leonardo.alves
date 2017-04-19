import java.util.ArrayList;
public class ListaSaints {
    private ArrayList<Saint> listaSaints = new ArrayList <> ();
    
    public void adicionar(Saint saint) {
        listaSaints.add(saint);
    }
    
    public Saint get(int indice){
        return listaSaints.get(indice);
    }
    
    public ArrayList<Saint> todos () {
        return listaSaints;
    }
    
    public void remover(Saint saint) {
        listaSaints.remove(saint);
    }
    
    public Saint buscarPorNome(String nome) {
        Saint saintRetornado;
        for(Saint saint : listaSaints){
            if(saint.getNome().equals(nome)){
                saintRetornado = saint;
                return saintRetornado;
            }
        }
        return null;
    }
    
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria)  {
        ArrayList<Saint> saints = new ArrayList <> ();
         for(Saint saint : listaSaints){
            if(saint.getArmadura().getCategoria().getValor() == categoria.getValor()){
                saints.add(saint);
            }
        }
        return saints;
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status) {
        ArrayList<Saint> saints = new ArrayList <> ();
        for(Saint saint : listaSaints) {
            if(saint.getStatus() == status) {
                saints.add(saint);
            }
        }
        return saints;
    }
    
    public Saint getSaintMaiorVida () {
        double maiorVida = -1;
        Saint saintMaiorVida = null;
        for(Saint saint : listaSaints){
            if(saint.getVida() > maiorVida) {
                maiorVida = saint.getVida();
                saintMaiorVida = saint;                
            }
            
        }
        return saintMaiorVida;
    }
    
    public Saint getSaintMenorVida () {
        double menorVida = 101;
        Saint saintMenorVida = null;
        for(Saint saint : listaSaints){
            if(saint.getVida() < menorVida) {
                menorVida = saint.getVida();
                saintMenorVida = saint;                
            }
            
        }
        return saintMenorVida;
    }
    
    public void ordenar() {              
        ListaSaints listaAuxiliar = new ListaSaints();  
        ListaSaints saintsOrdenados = new ListaSaints();
        ArrayList<Saint> auxiliar = this.listaSaints;
        int tamanho = auxiliar.size();
        
        for(Saint saintAuxiliar : auxiliar) {            
            listaAuxiliar.adicionar(saintAuxiliar);
        }               
        
        for(int i = 0; i < tamanho; i++){
            Saint saintMenorVida;            
            saintMenorVida = listaAuxiliar.getSaintMenorVida();            
            saintsOrdenados.adicionar(saintMenorVida);            
            listaAuxiliar.remover(saintMenorVida);
        }
        
        this.listaSaints = saintsOrdenados.todos();
    }
    
    
}