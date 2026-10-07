package app.OrarScheduler;

import app.Duplicabil;

public class Pauza extends Interval implements Duplicabil {


    public Pauza(int oraInceput, int durataMin){
        super(oraInceput, durataMin);

    }


    /// copy constructor()
    public Pauza(Pauza copiePauza){
        super(copiePauza);
    }




//    @Override
//    public String afisare(){
//        return super.afisare();
//    }

    @Override
    public Interval duplicate(){
        return new Pauza(this);
    }


    @Override
    public String getTipInterval(){
        return "PAUZA";
    }

    @Override
    public String detalii(){
        return "";
    }

    //interface methods
    @Override
    public Duplicabil interfaceDuplicate(){
        return new Pauza(this);
    }

}
