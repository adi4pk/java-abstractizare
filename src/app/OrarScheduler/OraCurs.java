package app.OrarScheduler;

import app.Duplicabil;

public class OraCurs extends HolderSala{

    private String materie;
//    private String sala;


    public OraCurs(int oraInceput, int durataMin, String materie, String sala){
        super(oraInceput, durataMin, sala);
        this.setMaterie(materie);
//        this.setSala(sala);
    }


    /// copy constructor()
    public OraCurs(OraCurs copieOraCurs){
            super(copieOraCurs);
            this.setMaterie(copieOraCurs.getMaterie());
            this.setSala(copieOraCurs.getSala());
    }

//    @Override
//    public String afisare(){
//        return this.getClass() + ": " + "ora " + this.getOraInceput() + this.getDurataMin() + this.getMaterie() + this.getSala();
//    }


//    @Override
//    public String afisare(){
//        return super.afisare() +", " + this.getMaterie() + ", sala: " + this.getSala();
//    }



    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    @Override
    public Interval duplicate(){
        return new OraCurs(this);
    }


    @Override
    public String getTipInterval(){
        return "CURS";
    }

    @Override
    public String detalii(){

        return ", " + this.getMaterie() + ", sala: " + this.getSala();
    }



    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){
        return new OraCurs(this);
    }
}
