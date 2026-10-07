package app.OrarScheduler;

import app.Duplicabil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Orar implements Duplicabil {

    //Intervale
    List<Interval> arrIntervale = new ArrayList<>();

    public Orar() {
        setArrIntervale(arrIntervale);

    }

    public Orar(Orar orar) {
        orar.setArrIntervale(arrIntervale);
    }

    public Orar(List <Interval> arr){
        this.setArrIntervale(arr);
    }

    public void setArrIntervale(List<Interval> arrIntervale) {
        this.arrIntervale = arrIntervale;
    }

    public void adaugaInterval(Interval interval) {

        arrIntervale.add(interval);

    }


    public List<Interval> getArrIntervale() {
        List<Interval> copyIntervale = new ArrayList<>(arrIntervale);
        return copyIntervale;
    }

    public String toString(){
        if (!arrIntervale.isEmpty()) {
            for (Interval interval : arrIntervale) {
                return interval.afisare();
            }
        } else {
            return "nu exista niciun interval setat.";

        }
        return "null";
    }


    public void afisare() {
        if (arrIntervale.size() > 0) {
            for (Interval interval : arrIntervale) {
                System.out.println(interval.afisare());
            }
        } else {
            System.out.println("nu exista niciun interval setat.");

        }
    }

    public String decalareOrar(int nrMinute) {

        for (Interval interval : arrIntervale) {
            interval.decalare(nrMinute);
        }

        return "Orarul a fost decalat cu " + nrMinute + " minute.";
    }


    public Orar duplicate() {

        Orar copie = new Orar();

        //GRESIT - this.arrIntervale = other.arrIntervale; -- 2 referinte, acelasi obiect.

        for (Interval interval : arrIntervale) {
            copie.getArrIntervale().add(interval.duplicate());
//                        copie.adaugaInterval(interval.duplicate());
        }


        return copie;
    }

    //interface methods
    @Override
    public Duplicabil interfaceDuplicate() {

        Orar copie = new Orar();
        //GRESIT - this.arrIntervale = other.arrIntervale; -- 2 referinte, acelasi obiect.

        for (Interval interval : arrIntervale) {
            copie.adaugaInterval(interval.duplicate());
        }

        return copie;
    }

    public void sorteazaIntervale(){

        Collections.sort(this.arrIntervale);
        System.out.println(getArrIntervale());
        System.out.println("test");

    }
}
