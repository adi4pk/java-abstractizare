package app.OrarScheduler;

import app.Duplicabil;

public abstract class Interval implements Duplicabil, Comparable<Interval> {

    //ora inceput, durata in min, materia, sala

    private int oraInceput;
    private int durataMin;

    // STATIC
    private static int nextId;
    private int id;
    static final int ORA_IN_MINUTE = 60;
    static final int ZI_IN_MINUTE = 1440;



    protected Interval(int oraInceput, int durataMin) {

        this.setOraInceput(oraInceput);
        this.setDurataMin(durataMin);
        nextId++;
        id += nextId;
    }


    /// copy constructor()
    protected Interval(Interval copieInterval){
        this.setOraInceput(copieInterval.getOraInceput());
        this.setDurataMin(copieInterval.getDurataMin());

        nextId++;
        id += nextId;
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Interval.nextId = nextId;
    }

    public int getOraInceput() {
        return oraInceput / ORA_IN_MINUTE;
    }

    public void setOraInceput(int oraInceput) {
        this.oraInceput = oraInceput * ORA_IN_MINUTE;      // ora x min
    }

    public int getDurataMin() {
        return durataMin;
    }

    public void setDurataMin(int durataMin) {
        this.durataMin = durataMin;
    }


    public String afisare(){
        int ora = getOraInceput();

        if(getDurataMin() >= ORA_IN_MINUTE){

            int minute = getDurataMin() % ORA_IN_MINUTE;
            int incrementareOre = getDurataMin() / ORA_IN_MINUTE;
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

        if(getDurataMin() >= ORA_IN_MINUTE){

            int minute = getDurataMin() % ORA_IN_MINUTE;
            int incrementareOre = getDurataMin() / ORA_IN_MINUTE;
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
        int decalajInMinute = (getOraInceput() * ORA_IN_MINUTE) + nrMinute;


        int oraDecalata = decalajInMinute/ORA_IN_MINUTE;
        int minDecalate = decalajInMinute % ORA_IN_MINUTE;

        if (getOraInceput() *ORA_IN_MINUTE +nrMinute > ZI_IN_MINUTE){
            oraDecalata = 0;
        }

        this.setOraInceput(oraDecalata);


        if(decalajInMinute % ORA_IN_MINUTE == 0){
            System.out.println("Orarul a fost decalat. Noua ora de incepere " + getTipInterval() + " este " + "ora " + oraDecalata + ":" +minDecalate);

        }
        if (decalajInMinute % ORA_IN_MINUTE != 0 && decalajInMinute/ORA_IN_MINUTE < 10){
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
