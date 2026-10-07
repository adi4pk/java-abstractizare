package app.formeGeometrice;

import app.Duplicabil;

public class Cerc extends Figura implements Duplicabil, ArieFigura{

    //proprietati
    private Punct punct;
    private int raza;


    public Cerc(Punct punct, int raza){
        this.setPunct(punct);
        this.setRaza(raza);
    }


    public Punct getPunct() {
        return punct;
    }

    public int getRaza() {
        return raza;
    }

    public void setPunct(Punct punct) {
        this.punct = punct;
    }

    public void setRaza(int raza) {
        this.raza = raza;
    }




    @Override
    public String toString(){
        return "Cerc cu punctul: " + punct.toString() + ", " + "raza: " + this.getRaza();
    }

    @Override
    public void afisare(){
        System.out.println(this);
    }

    @Override
    public void translate(int x, int y){
        this.punct.translate(x,y);
    }

    @Override
    public Figura duplicare(){
        return new Cerc((Punct) punct.duplicare(), raza);
    }

    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){
        return new Cerc((Punct) punct.duplicare(), raza);
    }

    @Override
    public double calculeazaArie(){

        double arie = Math.PI * raza * raza;
//        double arie = Math.PI * Math.pow(raza, 2);

        return arie;
    }
}
