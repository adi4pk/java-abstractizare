package app.formeGeometrice;

import java.util.ArrayList;
import java.util.List;

public class Desen extends Figura {

    private List<Figura> figuri;


    public Desen(List<Figura> figuri){
        this.figuri = figuri;
    }

    @Override
    public String toString(){
        String text = "Desenul contine: \n";
        for (Figura fig : figuri){
            text += fig.toString() + "\n";
        }
        return text;
    }

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

}