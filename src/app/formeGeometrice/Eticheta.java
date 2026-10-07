package app.formeGeometrice;

import app.Duplicabil;

public class Eticheta extends Dreptunghi implements Duplicabil {

    //proprietati - 2 puncte ce definesc un Dreptunghi  + textul dintre ele

    private Dreptunghi dreptunghi;
    private String text;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Dreptunghi getDreptunghi() {
        return dreptunghi;
    }

    public void setDreptunghi(Dreptunghi dreptunghi) {
        this.dreptunghi = dreptunghi;
    }

    public Eticheta(Dreptunghi dreptunghi, String text){
        super(dreptunghi.getPunctA(), dreptunghi.getPunctB());
        //avem nevoie de super() pentru ca Eticheta mosteneste Dreptunghi si trebuie initializata partea mostenita.
        //daca clasa din care mostenim nu are un constructor definit, NU este nevoie de super() -- e.g. Figura

        this.setDreptunghi(dreptunghi);
        this.setText(text);
    }

    public Eticheta(Punct punct1, String text, Punct punct2){
        super(punct1, punct2);

        this.setText(text);

        Dreptunghi dreptunghi = new Dreptunghi(punct1, punct2);
        setDreptunghi(dreptunghi);
    }

    @Override
    public String toString(){
        return "Eticheta: " + dreptunghi.toString() + text;
    }

    @Override
    public void afisare(){
        System.out.println(this);
    }

    @Override
    public void translate(int x, int y){
        dreptunghi.translate(x,y);
    }


    @Override
    public Dreptunghi duplicare(){
        return new Eticheta((Dreptunghi) dreptunghi.duplicare(), text);
    }


    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){
        return new Eticheta((Dreptunghi) dreptunghi.duplicare(), text);
    }


}
