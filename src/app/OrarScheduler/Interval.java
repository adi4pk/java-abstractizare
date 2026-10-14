package app.OrarScheduler;

import app.Duplicabil;

public abstract class Interval implements Duplicabil, Comparable<Interval> {

    //ora inceput, durata in min, materia, sala
//LocalDateTime
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

//        LocalDateTime x = LocalDateTime.now();
//
//        x.plusMinutes(23);


        nextId++;
        id += nextId;
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

//    public static int getOraInMinute() {
//        return ORA_IN_MINUTE;
//    }
//
//    public static int getZiInMinute(){
//        return ZI_IN_MINUTE;
//    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Interval.nextId = nextId;
    }

    public int getOraInceput() {        //returns ore
        return oraInceput / ORA_IN_MINUTE;
    }

    public void setOraInceput(int oraInceput) {
        if (oraInceput <0 || oraInceput > 24){
            throw new IllegalArgumentException(   //daca nu punem throw -> try/catch nu va prinde nimic -> programul va rula in continuare si va crea obiectul.
                    "INTERVALUL nu a fost creat. Ora nu poate fi mai mica de 0 sau mai mare de 24.");
        }
        else this.oraInceput = oraInceput * ORA_IN_MINUTE;      // ora x min

    }

    public int getDurataMin() {
        return durataMin;
    }

    public void setDurataMin(int durataMin) {
        this.durataMin = durataMin;
    }


    public String afisare(){

        return Timp.afisareInterval(this);

    }

    public String toString(){
        int ora = getOraInceput();
//        int minutePesteOra = oraInceput % ORA_IN_MINUTE;    //folosit atunci cand decalam intervalul

        if(getDurataMin() >= ORA_IN_MINUTE){

            int minuteDurata = getDurataMin() % ORA_IN_MINUTE;        //70%60 = 10 min
            int incrementareOre = getDurataMin() / ORA_IN_MINUTE;
//            ora += incrementareOre;

            if (minuteDurata ==0){
                return this.getTipInterval() + ": " + "ora " + ora + ":" + "0" + detalii();
            }
            return this.getTipInterval() + ": " + "ora " + ora + ":" + minuteDurata + detalii() ;

        } else if (getDurataMin() < 10){
            return this.getTipInterval() + ": " + "ora " + ora + ":0"+ detalii();

        }
        return this.getTipInterval() + ": " + "ora " + ora + ":" + detalii();
    }

    public void decalare(int nrMinute){

        Timp.decalare(this, nrMinute);

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
