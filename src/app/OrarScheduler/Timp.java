package app.OrarScheduler;

public class Timp {

    private static final int ORA_IN_MINUTE = 60;
    private static final int ZI_IN_MINUTE = 1440;


    public Timp(){

    }

    public static String afisareInterval(Interval interval){

        int ora = interval.getOraInceput();
//        int ORA_IN_MINUTE = Interval.getOraInMinute();

        if (interval.getDurataMin() > ORA_IN_MINUTE){

            int minute = interval.getDurataMin() % ORA_IN_MINUTE;
            int incrementareOre = interval.getDurataMin() / ORA_IN_MINUTE;
            ora += incrementareOre;

            if (minute ==0){
                return interval.getTipInterval() + ": " + "ora " + ora + ":" + minute +"0" + interval.detalii();
            }
            return interval.getTipInterval() + ": " + "ora " + ora + ":" + minute + interval.detalii();

        } else if (interval.getDurataMin() < 10){
            return interval.getTipInterval() + ": " + "ora " + ora + ":0" + interval.getDurataMin() + interval.detalii();

        }
        return interval.getTipInterval() + ": " + "ora " + ora + ":" + interval.getDurataMin() + interval.detalii();

    }


    public static void decalare(Interval interval, int nrMinute){

        int decalajInMinute = (interval.getOraInceput() * ORA_IN_MINUTE) + nrMinute;
                            // e.g.     10          *       60          + 120

        int oraDecalata = decalajInMinute/ORA_IN_MINUTE;   //720 / 60 = 12
        int minDecalate = decalajInMinute % ORA_IN_MINUTE;  //720 % 60  = 0

//        if (interval.getOraInceput() *ORA_IN_MINUTE +nrMinute > ZI_IN_MINUTE){
//            oraDecalata = 0;
//        }


        if(minDecalate < 10 && decalajInMinute % ORA_IN_MINUTE !=0 || decalajInMinute % ORA_IN_MINUTE ==0){
            System.out.println("Orarul a fost decalat. Noua ora de incepere " + interval.getTipInterval() + " este " + "ora " + oraDecalata + ":" + "0" +minDecalate  + "  TEST123");

        }
        if (minDecalate >= 10){
            System.out.println("Orarul a fost decalat. Noua ora de incepere " + interval.getTipInterval() + " este " + "ora " + oraDecalata + ":" +minDecalate + "  0test");

        }
//        else{
//            System.out.println("Orarul a fost decalat. Noua ora de incepere " + interval.getTipInterval() + " este " + "ora31232 " + oraDecalata + ":" +minDecalate);
//        }

        interval.setOraInceput(oraDecalata);
        // daca ora nu e exacta, MINUTELE NU vor fi setate

    }


}
