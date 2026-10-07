package app.OrarScheduler;

import app.Duplicabil;

public class Consultatii extends HolderSala implements Duplicabil{

    private String profesorul;



    public Consultatii(int oraInceput, int durataMin, String profesorul, String sala){
        super(oraInceput, durataMin, sala);
        this.setProfesorul(profesorul);
    }

    //copy-constructor
    public Consultatii(Consultatii copieConsultatii){
        super(copieConsultatii);
        this.setProfesorul(copieConsultatii.getProfesorul());
        this.setSala(copieConsultatii.getSala());
    }


    public String getProfesorul() {
        return profesorul;
    }

    public void setProfesorul(String profesorul) {
        this.profesorul = profesorul;
    }


    @Override
    public Interval duplicate(){
        return new Consultatii(this);
    }

    @Override
    public String getTipInterval(){
        return "CONSULTATII";
    }

    @Override
    public String detalii(){
        return ", " + "Profesorul: " + this.getProfesorul() + ", sala: " + this.getSala();
    }



    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){
        return new Consultatii(this);
    }
}
