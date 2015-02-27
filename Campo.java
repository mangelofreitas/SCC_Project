
import java.util.ArrayList;
import java.util.Random;

public class Campo {

	private Coordenada dimensao;
	private Celula[][] celulas;
	private ArrayList<Animal> animais;

	public void geraAnimais() {
            Animal aux;
            Random rd = new Random();
            for(int i=0;i<100;i++){
                int x = rd.nextInt(dimensao.getX());
                int y = rd.nextInt(dimensao.getY());
                aux = new Ovelha(rd.nextInt(7)+1,celulas[x][y]);
                animais.add(aux);
                celulas[x][y].adicionaAnimal(aux);
            }
            for(int i=0;i<30;i++){
                int x = rd.nextInt(dimensao.getX());
                int y = rd.nextInt(dimensao.getY());
                aux = new Lobo(rd.nextInt(30)+1,celulas[x][y]);
                animais.add(aux);
                celulas[x][y].adicionaAnimal(aux);
            }
        }

	public void geraRelva() {
            Random rd = new Random();
            for(int y = 0;y<dimensao.getY();y++){
                for(int x = 0;x<dimensao.getX();x++){
                    if(rd.nextDouble()<0.5){
                        celulas[x][y] = new Celula(new Coordenada(x,y),30);
                    }else{
                        celulas[x][y] = new Celula(new Coordenada(x,y),rd.nextInt(29)+1);
                    }
                }
            }
        }
       

}