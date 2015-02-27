import java.util.ArrayList;
public class Celula {

	private Coordenada coordenada;
	private int estadoCrescimento;
	private ArrayList<Animal> animais;

	public Celula(Coordenada coordenada, boolean relva){
		this.coordenada = coordenada;
		this.relva = relva;
	}
	public void regeneraRelva() {
		throw new UnsupportedOperationException();
		
		if(estadoCrescimento <= 30){
			estadoCrescimento++;
		}
	
	public void adicionaAnimal(Animal o){
		animais.add(o);
	}
	
	public void removeAnimal(Animal o){
		animais.remove(o);
	}
	public void resetRelva(){
		estadoCrescimento=0;
	}
}