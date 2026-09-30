package app.formeGeometrice;

public class Dreptunghi extends Figura{

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
}
