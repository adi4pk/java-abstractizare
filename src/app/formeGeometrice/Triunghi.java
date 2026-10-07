package app.formeGeometrice;

import app.Duplicabil;

public class Triunghi extends Figura implements Duplicabil, ArieFigura {

    private Punct punctA;
    private Punct punctB;
    private Punct punctC;


    public Triunghi(Punct punctA, Punct punctB, Punct punctC){
        setPunctA(punctA);
        setPunctB(punctB);
        setPunctC(punctC);
    }


    //getters, setters
    public Punct getPunctA() {
        return punctA;
    }

    public void setPunctA(Punct punctA) {
        this.punctA = punctA;
    }

    public Punct getPunctB() {
        return punctB;
    }

    public void setPunctB(Punct punctB) {
        this.punctB = punctB;
    }

    public Punct getPunctC() {
        return punctC;
    }

    public void setPunctC(Punct punctC) {
        this.punctC = punctC;
    }



    //metode

    @Override
    public String toString(){
        return "Triunghi cu punctele: " + "A - " + punctA.toString() + "; B - " + punctB.toString() + "; si C - " + punctC.toString();
    }

    @Override
    public void afisare(){

    }

    @Override
    public void translate(int x, int y){
        this.punctA.translate(x, y);
        this.punctB.translate(x, y);
        this.punctC.translate(x, y);

    }

    @Override
    public Figura duplicare(){

        return new Triunghi((Punct) getPunctA().duplicare(), (Punct) getPunctB().duplicare(), (Punct) getPunctC().duplicare());
    }


    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){

        return new Triunghi((Punct) getPunctA().duplicare(), (Punct) getPunctB().duplicare(), (Punct) getPunctC().duplicare());
    }

    @Override
    public double calculeazaArie(){
        // ARIA = Math.abs(x1(y2-y3) + x2(y3-y1) + x3(y1-y2)) / 2.0
        double A = punctA.getX()*(punctB.getY()-punctC.getY());
        double B = punctB.getX()*(punctC.getY() - punctA.getY());
        double C = punctC.getX()*(punctA.getY() - punctB.getY());

        double arie = Math.abs(A + B + C)/2.0;
        return arie;

    }

}
