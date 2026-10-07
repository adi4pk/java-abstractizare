package app.formeGeometrice;

import app.Duplicabil;

public class Dreptunghi extends Figura implements Duplicabil, ArieFigura{

    //proprietati
    Punct punctA;
    Punct punctB;


    public Dreptunghi(Punct p1, Punct p2){
        this.setPunctA(p1);
        this.setPunctB(p2);

    }


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

    @Override
    public String toString(){
        return "Dreptunghi cu punctele: " + "A - " + punctA.toString() + " si B - " + punctB.toString();
    }


    @Override
    public void afisare(){
        System.out.println(this);
    }

    @Override
    public void translate(int x, int y){
        this.punctA.translate(x, y);
        this.punctB.translate(x, y);
    }

    @Override
    public Figura duplicare(){
        return new Dreptunghi((Punct) punctA.duplicare(), (Punct) punctB.duplicare());
    }

    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){
        return new Dreptunghi((Punct) punctA.duplicare(), (Punct) punctB.duplicare());
    }


    @Override
    public double calculeazaArie(){
        double x = Math.abs(punctA.getX() - punctB.getX());     //latime
        double y = Math.abs(punctA.getY() - punctB.getY());     //inaltime

        double arie = Math.abs(x*y);

        return arie;
    }


}
