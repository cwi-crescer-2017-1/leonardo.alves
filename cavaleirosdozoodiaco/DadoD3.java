import java.util.Random;
public class DadoD3 implements Sorteador{
    final private  Saint saint;
    final private Random random = new Random ();
    final private int min = 1, max = 3;
    
    public DadoD3 (Saint saint) {
        this.saint = saint;
    }
    
    public int sortear (){
        return random.nextInt(this.min - this.max + 1) + this.min;
    }
}
