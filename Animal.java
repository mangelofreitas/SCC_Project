public abstract class Animal {

    protected int tipo;
    protected double energia;
    protected Celula posicao;

    public Animal(int tipo, double energia, Celula posicao) {
        this.tipo = tipo;
        this.energia = energia;
        this.posicao = posicao;
    }

    public void movimento() {
            
    }

    public abstract Animal geraAnimal();

    public abstract boolean come();

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public Celula getPosicao() {
        return posicao;
    }

    public void setPosicao(Celula posicao) {
        this.posicao = posicao;
    }
    
    

    @Override
    public String toString() {
        return "Animais{" + "tipo=" + tipo + ", energia=" + energia + ", posicao=" + posicao + '}';
    }
        
        

}