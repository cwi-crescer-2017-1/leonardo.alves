import java.util.ArrayList;
public class ListaSaints {
    ArrayList<Saint> listaSaints = new ArrayList <> ();
    
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
        if(listaSaints.contains(saint)) {
            int indice = listaSaints.indexOf(saint);
            listaSaints.remove(indice);
        }
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
        
         for(Saint saint : listaSaints){
            if(saint.getArmadura().getCategoria().getValor() == categoria.getValor()){
                
            }
        }
        return null;
    }
}