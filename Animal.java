
import java.util.Random;

public abstract class Animal {

    protected int tipo;
    protected double energia;
    protected Celula posicao;

    Animal(int tipo, double energia, Celula posicao) {
        this.tipo = tipo;
        this.energia = energia;
        this.posicao = posicao;
    }

    public boolean movimento(Celula posicoes[][]) {
        Random random = new Random();
        int xFut=0,yFut=0,x=posicao.getCoordenada().getX(),y=posicao.getCoordenada().getY();
        energia--;
        if(energia<=0.0)
        {
            return true;
        }
        while(xFut==0 && yFut == 0)
        {
             xFut = random.nextInt(3)-1;
             yFut = random.nextInt(3)-1;
        }
        posicoes[x][y].removeAnimal(this);
        if(x+xFut<0)
        {
            posicao = posicoes[posicoes.length-1][y];
            posicoes[posicoes.length-1][y].adicionaAnimal(this);
            x=posicao.getCoordenada().getX();
        }
        else if(x+xFut>posicoes.length-1)
        {
            posicao = posicoes[0][y];
            posicoes[0][y].adicionaAnimal(this);
            x=posicao.getCoordenada().getX();
        }
        if(y+yFut<0)
        {
            posicao = posicoes[x][posicoes.length-1];
            posicoes[x][posicoes[x].length-1].adicionaAnimal(this);
        }
        else if(y+yFut>posicoes[x].length-1)
        {
            posicao = posicoes[x][0];
            posicoes[x][0].adicionaAnimal(this);
        }
        if(x+xFut>=0 && x+xFut<=posicoes.length-1 && y+yFut>=0 && y+yFut<=posicoes.length-1)
        {
            posicao = posicoes[x+xFut][y+yFut];
            posicoes[x+xFut][y+yFut].adicionaAnimal(this);
        }
        return false;
    }

    public abstract Animal geraAnimal();

    public abstract void come(int num);

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
        return "Animais{" + "tipo=" + tipo + ", energia=" + energia + ", posicao=" + posicao.getCoordenada() + '}';
    }
        
        

}