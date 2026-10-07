package app.OrarScheduler;

import app.Duplicabil;

public abstract class HolderSala extends Interval{


    private String sala;

    public HolderSala(int oraIncepere, int durataMin, String sala){

        super(oraIncepere, durataMin);
        this.setSala(sala);
    }

    //copy constructor
    public HolderSala(HolderSala copySala){
        super(copySala);
        this.setSala(copySala.getSala());
    }


    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public abstract Interval duplicate();
    public abstract String getTipInterval();
    public abstract String detalii();



    public abstract Duplicabil interfaceDuplicate();
    //mai punem duplicate si aici?


}
