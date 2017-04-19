import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
        return this.listaSaints.stream()
        .filter(s -> s.getNome().equals(nome))
        .findFirst()
        .orElse(null);
    }
    
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria)  {        
        return (ArrayList<Saint>) this.listaSaints.stream()
        .filter(s -> s.getArmadura().getCategoria().getValor() == categoria.getValor())
        .collect(Collectors.toList());       
    }   
    
    public ArrayList<Saint> buscarPorStatus(Status status) {
        return (ArrayList<Saint>) this.listaSaints.stream()
        .filter(s -> s.getStatus() == status)
        .collect(Collectors.toList());
    }
    
    public Saint getSaintMaiorVida () {
        if(this.listaSaints.isEmpty()) return null;
        
        Saint saintMaiorVida = listaSaints.get(0);
        for(int i=1; i < listaSaints.size(); i++){
            if(listaSaints.get(i).getVida() > saintMaiorVida.getVida()) {
                saintMaiorVida = listaSaints.get(i);                              
            }            
        }
        return saintMaiorVida;       
    }
    
    public Saint getSaintMenorVida () {
        if(this.listaSaints.isEmpty()) return null;
        
        Saint saintMenorVida = listaSaints.get(0);
        for(int i=1; i < listaSaints.size(); i++){
            if(listaSaints.get(i).getVida() < saintMenorVida.getVida()) {
                saintMenorVida = listaSaints.get(i);                              
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