public class ExercitoQueAtacaEmOrdemHierarquica extends ExercitoDeSaints {        
    
    public Saint proximoSaint () {     
        
        for(int i = 0; i < 3; i++){      
            
            if(existeSaintNaCategoria()) {
                super.proximoSaint = getProximoSaintNaCategoria();
                removerSaintDaCategoria(proximoSaint);
                
                return proximoSaint;
            } else 
                proximoValorCategoria();
        }
        return null;
    }
}