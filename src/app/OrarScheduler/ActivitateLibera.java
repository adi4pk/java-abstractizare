package app.OrarScheduler;

import app.Duplicabil;

public class ActivitateLibera extends Interval implements Duplicabil {

    //denumirea, locul de desfășurare

    String denumire;
    String locDesfasurare;


    public ActivitateLibera(int oraInceput, int durataMin, String denumire, String locDesfasurare){

        super(oraInceput, durataMin);
        this.setDenumire(denumire);
        this.setLocDesfasurare(locDesfasurare);
    }

    /// copy constructor()
    public ActivitateLibera(ActivitateLibera copieActivitateLibera){
        super(copieActivitateLibera);
        this.setDenumire(copieActivitateLibera.getDenumire());
        this.setLocDesfasurare(copieActivitateLibera.getLocDesfasurare());
    }




    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getLocDesfasurare() {
        return locDesfasurare;
    }

    public void setLocDesfasurare(String locDesfasurare) {
        this.locDesfasurare = locDesfasurare;
    }


//    @Override
//    public String afisare(){
//        return super.afisare() + ", " + this.getDenumire() + ", " + this.getLocDesfasurare();
//
//    }

    @Override
    public Interval duplicate(){
        return new ActivitateLibera(this);
    }

    @Override
    public String getTipInterval(){
        return "ACTIVITATE";
    }

    @Override
    public String detalii(){
        return ", " + this.getDenumire() + ", " + this.getLocDesfasurare();
    }

    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){
        return new ActivitateLibera(this);
    }
    


}
