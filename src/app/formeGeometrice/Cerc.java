package app.formeGeometrice;

public class Cerc extends Figura{

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
        return "Punct: " + punct.toString() + ", " + "raza: " + this.getRaza();
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
}
