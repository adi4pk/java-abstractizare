package app.formeGeometrice;

import app.Duplicabil;

//todo: cuvantul cheie interface
// toate metodele sunt by default public abstract
// toate  clasele ce implementeaza o interfata sunt obligate
// sa suprascrie metodele interfetei
// Obs! O clasa poate extide doar o singura clasa
// dar poate implementa mai multe interfete
public abstract class Figura implements Duplicabil {

   public abstract void afisare();
    //(mutare) pe orizontală și/sau verticală a desenului geometric
    // — modificarea x-ului / y-ului tuturorelementelor cu o valoare dată;

    public abstract void translate(int x, int y);

    public abstract Figura duplicare();
}
