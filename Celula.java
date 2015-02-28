import java.util.ArrayList;
public class Celula {

	private Coordenada coordenada;
	private int estadoCrescimento;
	private ArrayList<Animal> animais;

	public Celula(Coordenada coordenada,int estadoCrescimento){
		this.coordenada = coordenada;
		this.estadoCrescimento = estadoCrescimento;
                this.animais = new ArrayList<Animal>();
	}
	public void regeneraRelva() 
        {
            if(estadoCrescimento < 30){
                estadoCrescimento++;
            }
        }
	
	public void adicionaAnimal(Animal o){
		animais.add(o);
	}
	
	public void removeAnimal(Animal o){
		animais.remove(o);
	}
	public void resetRelva(){
		estadoCrescimento=1;
	}

        public Coordenada getCoordenada() {
            return coordenada;
        }

        public int getEstadoCrescimento() {
            return estadoCrescimento;
        }

        public ArrayList<Animal> getAnimais() {
            return animais;
        }
        
        
}