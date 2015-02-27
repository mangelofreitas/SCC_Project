
import java.util.Random;

public class Ovelha extends Animal {

	public Ovelha(double energia, Celula posicao) {
            super(1,energia,posicao);
	}

        @Override
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

    @Override
    public boolean come() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


