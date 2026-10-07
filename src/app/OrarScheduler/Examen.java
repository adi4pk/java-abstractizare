package app.OrarScheduler;

import app.Duplicabil;

public class Examen extends HolderSala implements Duplicabil {

    private String materie;
    private int notaMaxima;

    public Examen(int oraInceput, int durataMin, String materie, String sala, int notaMaxima){
        super(oraInceput, durataMin, sala);
        this.materie = materie;
        this.notaMaxima = notaMaxima;


    }

    public Examen(Examen copieExamen){
        super(copieExamen);
        this.setMaterie(copieExamen.getMaterie());
        this.setNotaMaxima(copieExamen.getNotaMaxima());
    }


    //getters, setters


    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    public int getNotaMaxima() {
        return notaMaxima;
    }

    public void setNotaMaxima(int notaMaxima) {
        this.notaMaxima = notaMaxima;
    }


//    @Override
//    public String afisare(){
//        return super.afisare() + " " + this.getMaterie() + ", " + this.getSala() + ", " + "nota maxima: " + this.getNotaMaxima();
//    }


    @Override
    public Interval duplicate(){
        return new Examen(this);
    }

    @Override
    public String getTipInterval(){
        return "EXAMEN";
    }

    @Override
    public String detalii(){

        return ", " + this.getMaterie() + ", " + this.getSala() + ", " + "nota maxima: " + this.getNotaMaxima();
    }


    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){
        return new Examen(this);
    }

}
