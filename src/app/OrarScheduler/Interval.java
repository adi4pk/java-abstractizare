package app.OrarScheduler;

import app.Duplicabil;

public abstract class Interval implements Duplicabil, Comparable<Interval> {

    //ora inceput, durata in min, materia, sala

    private int oraInceput;
    private int durataMin;

    protected Interval(int oraInceput, int durataMin) {

        this.setOraInceput(oraInceput);
        this.setDurataMin(durataMin);
    }

    /// copy constructor()
    protected Interval(Interval copieInterval){
        this.setOraInceput(copieInterval.getOraInceput());
        this.setDurataMin(copieInterval.getDurataMin());
    }

    public int getOraInceput() {
        return oraInceput / 60;
    }

    public void setOraInceput(int oraInceput) {
        this.oraInceput = oraInceput * 60;      // ora x min
    }

    public int getDurataMin() {
        return durataMin;
    }

    public void setDurataMin(int durataMin) {
        this.durataMin = durataMin;
    }


    public String afisare(){
        int ora = getOraInceput();

        if(getDurataMin() >= 60){

            int minute = getDurataMin() % 60;
            int incrementareOre = getDurataMin() / 60;
            ora += incrementareOre;

            if (minute ==0){
                return this.getTipInterval() + ": " + "ora " + ora + ":" + minute +"0" + detalii();
            }
            return this.getTipInterval() + ": " + "ora " + ora + ":" + minute + detalii();

        } else if (getDurataMin() < 10){
            return this.getTipInterval() + ": " + "ora " + ora + ":0" + this.getDurataMin() + detalii();

        }
        return this.getTipInterval() + ": " + "ora " + ora + ":" + this.getDurataMin() + detalii();
    }

    public String toString(){
        int ora = getOraInceput();

        if(getDurataMin() >= 60){

            int minute = getDurataMin() % 60;
            int incrementareOre = getDurataMin() / 60;
            ora += incrementareOre;

            if (minute ==0){
                return this.getTipInterval() + ": " + "ora " + ora + ":" + minute +"0" + detalii();
            }
            return this.getTipInterval() + ": " + "ora " + ora + ":" + minute + detalii();

        } else if (getDurataMin() < 10){
            return this.getTipInterval() + ": " + "ora " + ora + ":0" + this.getDurataMin() + detalii();

        }
        return this.getTipInterval() + ": " + "ora " + ora + ":" + this.getDurataMin() + detalii();
    }

    public void decalare(int nrMinute){
        int decalajInMinute = (getOraInceput() * 60) + nrMinute;


        int oraDecalata = decalajInMinute/60;
        int minDecalate = decalajInMinute % 60;

        if (getOraInceput() *60 +nrMinute > 1440){
            oraDecalata = 0;
        }

        this.setOraInceput(oraDecalata);


        if(decalajInMinute % 60 == 0){
            System.out.println("Orarul a fost decalat. Noua ora de incepere " + getTipInterval() + " este " + "ora " + oraDecalata + ":" +minDecalate);

        }
        if (decalajInMinute % 60 != 0 && decalajInMinute/60 < 10){
            System.out.println("Orarul a fost decalat. Noua ora de incepere " + getTipInterval() + " este " + "ora " + oraDecalata + ":" +minDecalate + "0test");

        }
        else {
            System.out.println("Orarul a fost decalat. Noua ora de incepere " + getTipInterval() + " este " + "ora " + oraDecalata + ":" +"0" +minDecalate);
        }

    }

    public abstract Interval duplicate();



    public abstract String getTipInterval();
    public  abstract String detalii();

    public abstract Duplicabil interfaceDuplicate();

    //interface methods


    @Override
    public int compareTo(Interval interval) {
        System.out.println(this.getOraInceput() + " vs " + interval.getOraInceput());
        return Integer.compare(this.getOraInceput(), interval.getOraInceput());
    }
}
