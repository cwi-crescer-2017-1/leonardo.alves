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
        ordenar(TipoOrdenacao.ASCENDENTE);
    }
    
    public void ordenar(TipoOrdenacao ordenacao) {        
        ListaSaints listaAuxiliar = new ListaSaints();  
        ListaSaints saintsOrdenados = new ListaSaints();
        ArrayList<Saint> auxiliar = this.listaSaints;
        int tamanho = auxiliar.size();  
        
        for(Saint saintAuxiliar : auxiliar) listaAuxiliar.adicionar(saintAuxiliar);
        
        for(int i = 0; i < tamanho; i++) {
            Saint saint = null;            
            boolean isAscendente = ordenacao == TipoOrdenacao.ASCENDENTE;
            
            if (isAscendente)                
                saint = listaAuxiliar.getSaintMenorVida();            
            else 
                saint = listaAuxiliar.getSaintMaiorVida();
            
            saintsOrdenados.adicionar(saint);            
            listaAuxiliar.remover(saint);           
        }        
        this.listaSaints = saintsOrdenados.todos();
    }
    
    public ListaSaints unir (ListaSaints listaSaints) {
        boolean listaSaintsRecebidaVazia = listaSaints.todos().isEmpty();
        boolean essaListaEstaVaziaEaOutraNao =
            this.listaSaints.isEmpty() && !listaSaints.todos().isEmpty();
            
        if(listaSaintsRecebidaVazia)  return this;
        else if(essaListaEstaVaziaEaOutraNao) return listaSaints;
        
        ListaSaints newListaSaints = new ListaSaints();
        for(Saint saint : this.listaSaints) newListaSaints.adicionar(saint);
        for(Saint saint : listaSaints.todos()) newListaSaints.adicionar(saint);
        
        return newListaSaints;
    }
    
    public ListaSaints diff (ListaSaints listaSaints) {
        ListaSaints newListaSaints = new ListaSaints();
        for(Saint saint : this.listaSaints) newListaSaints.adicionar(saint);
        int tamanho = newListaSaints.todos().size();
        
        for(int i = 0; i < tamanho; i++){
            for(Saint saint : listaSaints.todos()) {
                if(saint.equals(this.listaSaints.get(i))){
                    newListaSaints.remover(saint);
                }
            }
        }
        
        return newListaSaints;
    }
    
    
    public ListaSaints intersec(ListaSaints listaSaints) {
        ListaSaints newListaSaints = new ListaSaints();
        int tamanho = this.listaSaints.size();
        
        for(int i = 0; i < tamanho; i++) {
            for(Saint saint : listaSaints.todos()){
                if(saint.equals(this.listaSaints.get(i))) {
                    newListaSaints.adicionar(saint);
                }  
            }
        }
        return newListaSaints;
    }
    

    public String getCSV () {      
        StringBuilder builder = new StringBuilder(1024);
        
        for(Saint saint : listaSaints) {
            builder.append(saint.getCSV()); 
            builder.append("\n");  
        }       
        if(builder.length() != 0) builder.delete(builder.length() - 2 , builder.length());
        return builder.toString();
    }
}