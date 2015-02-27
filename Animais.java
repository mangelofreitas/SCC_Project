public abstract class Animais {

	protected int tipo;
	protected double energia;
	protected Celula posicao;

	public Animais() {
		// TODO - implement Animais.Animais
		throw new UnsupportedOperationException();
	}

	public void movimento() {
		// TODO - implement Animais.movimento
		throw new UnsupportedOperationException();
	}

	public abstract Animal geraAnimal();

	public abstract boolean come();

}