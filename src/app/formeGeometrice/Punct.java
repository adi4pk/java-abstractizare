package app.formeGeometrice;

import app.Duplicabil;

public class Punct extends Figura implements Duplicabil{

    //proprietati - coordonate
    private int x;
    private int y;

    public Punct(int x, int y){
        this.setX(x);
        this.setY(y);
    }




    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


//suprascriem toString equals

    @Override
    public String toString(){
        return "X:" + x + "," + "Y:" +y;
    }



    @Override
    public boolean equals(Object o) {

        if (o == null){     //Guard pentru null
            return false;
        }

        if (!(o instanceof Punct)){     //Guard pentru alt tip obiect.
            return false;
        }

        Punct punctDeComparat = (Punct) o;   // --> downcast to Punct
        return x == punctDeComparat.x && y == punctDeComparat.y;
    }

    @Override
    public void afisare(){
        System.out.println(this);
    }

    @Override
    public void translate(int x,int y){

        this.setX(x);
        this.setY(y);
    }

    @Override
    public Figura duplicare(){
        return new Punct(x,y);
    }


    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){
        return new Punct(x,y);
    }

}
