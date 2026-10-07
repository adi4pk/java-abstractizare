package app.formeGeometrice;

import app.Duplicabil;

import java.util.ArrayList;
import java.util.List;

public class Desen extends Figura implements Duplicabil {

    private List<Figura> figuri;


    public Desen(List<Figura> figuri){
        this.figuri = figuri;
    }

    @Override
    public String toString(){
//        String text = "Desenul contine: \n";
        StringBuilder x = new StringBuilder();
        for (Figura fig : figuri){
            x.append(fig.toString()).append("\n");
        }
        return "Desenul contine: \n" + x;
    }

    @Override
    public void afisare(){
        System.out.println(this);
    }

    //muta tot desenul - teleport
    public void translate(int x, int y){
        for (Figura fig : figuri){
            fig.translate(x, y);
        }
    }

    public Figura duplicare(){

        List<Figura> copieFiguri = new ArrayList<>();

        for (Figura figura:figuri){
            Figura copieFigura = figura.duplicare();
            copieFiguri.add(copieFigura);
        }

        return new Desen(copieFiguri);
    }

    @Override
    public Duplicabil interfaceDuplicate(){

        List<Figura> copieFiguri = new ArrayList<>();

        for (Figura figura:figuri){
            Figura copieFigura = figura.duplicare();
            copieFiguri.add(copieFigura);
        }

        return new Desen(copieFiguri);
    }

    public double adunaAriile(){

        double arieTotala = 0;

        for (Figura figura:figuri){
            if (figura instanceof ArieFigura){
                arieTotala += ((ArieFigura) figura).calculeazaArie();
            }
        }

        return arieTotala;
    }

}