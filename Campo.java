
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Campo {

	static private Coordenada dimensao;
	static private Celula[][] celulas;
	static private ArrayList<Animal> animais;
        
        public static void main(String args[])
        {
            int x, y, periodo,counterOvelhas,counterLobos;
            boolean morto;
            Animal aux;
            ArrayList<Animal> crias = new ArrayList<Animal>();
            Scanner input = new Scanner(System.in);
            animais = new ArrayList<Animal>();
            System.out.println("Dimensões do campo");
            System.out.print("Dimensão do x: ");
            x = input.nextInt();
            System.out.print("Dimensão do y: ");
            y = input.nextInt();
            dimensao = new Coordenada(x,y);
            celulas = new Celula[x][y];
            geraRelva();
            geraAnimais();
            System.out.print("Período que terá a duração da simulação :");
            periodo = input.nextInt();
            for(int i=0;i<periodo;i++)
            {
                veAnimais();
                
                for(x=0;x<celulas.length;x++)
                {
                    for(y=0;y<celulas[x].length;y++)
                    {
                        counterOvelhas=0;
                        counterLobos=0;
                        for(int n=0;n<celulas[x][y].getAnimais().size();n++)
                        {
                            
                            if(celulas[x][y].getAnimais().get(n).tipo==0)
                            {
                                counterLobos++;
                            }
                            else
                            {
                                counterOvelhas++;
                            }
                        }
                        boolean verificaRelva=false;
                        for(int n=0;n<celulas[x][y].getAnimais().size();n++)
                        {
                            if(counterLobos==0 && counterOvelhas>0 && celulas[x][y].getEstadoCrescimento()==30)
                            {
                                celulas[x][y].getAnimais().get(n).come(4/counterOvelhas);
                                verificaRelva=true;
                            }
                            else if(counterLobos>0 && counterOvelhas>0)
                            {
                                if(celulas[x][y].getAnimais().get(n).tipo==0 )
                                {
                                    celulas[x][y].getAnimais().get(n).come(20*counterOvelhas/counterLobos);
                                }
                                else
                                {
                                    animais.remove(celulas[x][y].getAnimais().get(n));
                                    celulas[x][y].getAnimais().remove(n);
                                }
                            }
                        }
                        if(verificaRelva==true)
                        {
                            celulas[x][y].resetRelva();
                        }
                        else
                        {
                            celulas[x][y].regeneraRelva();
                        }
                    }
                }
                crias.clear();
                for(int j=0;j<animais.size();j++)
                {
                    aux = animais.get(j).geraAnimal();
                    if(aux!=null)
                    {
                        crias.add(aux);
                    }
                    morto = animais.get(j).movimento(celulas);
                    if(morto==true)
                    {
                        animais.get(j).posicao.removeAnimal(animais.get(j));
                        animais.remove(j);
                    }
                }
                for(int n=0;n<crias.size();n++)
                {
                    animais.add(crias.get(n));
                    celulas[crias.get(n).posicao.getCoordenada().getX()][crias.get(n).posicao.getCoordenada().getY()].adicionaAnimal(crias.get(n));
                }
            }
        }

	public static void geraAnimais() {
            Animal aux;
            Random rd = new Random();
            for(int i=0;i<100;i++){
                int x = rd.nextInt(dimensao.getX());
                int y = rd.nextInt(dimensao.getY());
                aux = new Ovelha(rd.nextInt(7)+1,celulas[x][y]);
                celulas[x][y].adicionaAnimal(aux);
                animais.add(aux);
            }
            for(int i=0;i<30;i++){
                int x = rd.nextInt(dimensao.getX());
                int y = rd.nextInt(dimensao.getY());
                aux = new Lobo(rd.nextInt(30)+1,celulas[x][y]);
                celulas[x][y].adicionaAnimal(aux);
                animais.add(aux);
            }
        }

	public static void geraRelva() {
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
        
        public static void veAnimais()
        {
            int nOvelhas=0,nLobos=0;
            for(int i=0;i<animais.size();i++)
            {
                if(animais.get(i).tipo==0)
                {
                    nLobos++;
                }
                else
                {
                    nOvelhas++;
                }
            }
            System.out.println("Lobos: "+nLobos+" Ovelhas: "+nOvelhas);
        }
       

}