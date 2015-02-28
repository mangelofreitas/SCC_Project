
import java.util.Random;

public class Ovelha extends Animal {

	public Ovelha(double energia, Celula posicao) {
            super(1,energia,posicao);
	}

        public Animal geraAnimal() {
            double aux;
            Random rd = new Random();
            aux = rd.nextDouble();
            if(aux <= 0.04){
                Ovelha filho = new Ovelha(energia/2,posicao);
                return filho;
            }
         return null;   
	}

        public void come(int num) {
            energia+=num;
        }
}


