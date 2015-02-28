
import java.util.Random;


public class Lobo extends Animal {

	public Lobo(double energia, Celula posicao) {
            
            super(0,energia,posicao);
	}

	public Animal geraAnimal() {
            double aux;
            Random rd = new Random();
            aux = rd.nextDouble();
            if(aux <= 0.05){
                Lobo filho = new Lobo(energia/2,posicao);
                return filho;
            }
         return null;   
	}

	public void come(int num) {
            energia+=num;
	}
        
        

}