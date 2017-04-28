public class ExercitoQueAtacaEmOrdemAlternada extends ExercitoDeSaints {    
    
    public Saint proximoSaint(){
        for(int i = 0; i < 3; i++){
            if(existeSaintNaCategoria()){            
                super.proximoSaint = getProximoSaintNaCategoria();
                
                removerSaintDaCategoria(proximoSaint);
                
                proximoValorCategoria ();           
                return proximoSaint;
            }          
            proximoValorCategoria();            
        }
        return null;
    }
}