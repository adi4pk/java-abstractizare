package app;

import app.OrarScheduler.*;
import app.formeGeometrice.*;
import app.staticExercitii.Pauza1;
import app.staticExercitii.Pauza2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {


    public static void main(String[] args){

//        exFiguriGeometrice();
//        exOrar();
//        crossEx();
//        exInterface();

//        sortareEx();
        staticEx();

    }


    public static void exFiguriGeometrice(){

        Figura punct1 = new Punct(20, 50);
        Figura punct2 = new Punct(30, 0);
        Figura punct3 = new Punct(25, 50);

        Figura triunghi1 = new Triunghi((Punct) punct1, (Punct) punct2, (Punct) punct3);
        Figura dreptunghi1 = new Dreptunghi((Punct) punct1, (Punct) punct2);


        Figura cerc1 = new Cerc((Punct)punct1, 100);

        List<Figura> figuri = new ArrayList<>();
        figuri.addAll(Arrays.asList(dreptunghi1, triunghi1));

        Figura desenCasa = new Desen(figuri);

        List<Figura> arrDesenMare = new ArrayList<>();
        arrDesenMare.addAll(Arrays.asList(desenCasa, cerc1));

        Figura desenMare = new Desen(arrDesenMare);
        desenMare.afisare();

        Figura copieDesen = desenMare.duplicare();
        copieDesen.translate(100, 100);
//        desenMare.afisare();
//        copieDesen.afisare();




//        desen1.afisare();
//        desen1.translate(10, 5);
//        desen1.afisare();

    }


    public static void exOrar(){

        Interval curs1 = new OraCurs(10, 60, "Cryptography", "402B");
        Interval pauza1 = new Pauza(11, 10);
        Interval activitate1 = new ActivitateLibera(12, 60, "Gimnastica", "Sala Sport");
        Interval examen1 = new Examen(13, 50, "Germana", "256A", 10);

        Interval consultatii1 = new Consultatii(14, 30, "Popescu", "137A");

        Orar orar1 = new Orar();

        List<Interval> arrIntervale = new ArrayList<>();
        arrIntervale.addAll(Arrays.asList(curs1, pauza1, activitate1, examen1, consultatii1));

        for (Interval interval:arrIntervale){
            orar1.adaugaInterval(interval);
        }


        orar1.afisare();


    }




    public static void crossEx(){

        //figuri
        Figura punct1 = new Punct(20, 50);
        Figura punct2 = new Punct(30, 0);
        Figura punct3 = new Punct(25, 50);
        Figura triunghi1 = new Triunghi((Punct) punct1, (Punct) punct2, (Punct) punct3);


        //Intervale
        Interval pauza1 = new Pauza(11, 10);
        Interval activitate1 = new ActivitateLibera(12, 60, "Gimnastica", "Sala Sport");

        Figura cerc1 = new Cerc((Punct)punct1, 100);
        Interval curs1 = new OraCurs(10, 60, "Cryptography", "402B");
        Orar orar1 = new Orar();

        List<Interval> arrIntervale = new ArrayList<>();
        arrIntervale.addAll(Arrays.asList(pauza1, activitate1));

        for (Interval interval:arrIntervale){
            orar1.adaugaInterval(interval);
        }

        orar1.afisare();

        List<Duplicabil> arrDuplicate = new ArrayList<>();
        arrDuplicate.addAll(Arrays.asList(cerc1, curs1, orar1));    //???

        CrossClass cross = new CrossClass();
        cross.genereazaCopii(arrDuplicate);



    }

    public static void exInterface(){

        Figura punct1 = new Punct(20, 50);
        Cerc cerc1 = new Cerc((Punct)punct1, 100);


        Duplicabil cercDuplicat = duplicateFunc(cerc1);
        ArieFigura cercArie = arieFunc(cerc1);
        duplicateFunc(punct1);     //corect - Punct implementeaza Duplicabil
//        arieFunc(punct1); X - Punct nu implementeaza interfata ArieFigura

    }

    public static Duplicabil duplicateFunc(Duplicabil obiect){

        System.out.println(obiect);
        return obiect;
        }


        public static ArieFigura arieFunc(ArieFigura object){
            System.out.println(object);
            return object;
    }


    public static void sortareEx(){
        Interval consultatii1 = new Consultatii(14, 30, "Popescu", "137A");
        Interval activitate1 = new ActivitateLibera(12, 60, "Gimnastica", "Sala Sport");
        Interval examen1 = new Examen(13, 50, "Germana", "256A", 10);
        Interval curs1 = new OraCurs(10, 60, "Cryptography", "402B");
        Interval pauza1 = new Pauza(11, 10);

        List <Interval> arrIntervale = new ArrayList<>();
        arrIntervale.addAll(Arrays.asList(consultatii1, activitate1, examen1, curs1, pauza1));

        Orar orar = new Orar(arrIntervale);

        orar.sorteazaIntervale();

        orar.afisare();

    }


    public static void staticEx(){

        Pauza1 pauza1 = new Pauza1();
        Pauza2 pauzaStatic = new Pauza2();
        Pauza2 pauzaStatic2 = new Pauza2();
        Pauza2 pauzaStatic3 = new Pauza2();

//        System.out.println(pauza1.create);      //acceseaza prin obiect
//        System.out.println(Pauza2.create);      //acceseaza prin clasa


        Interval inter1 = new ActivitateLibera(10, 60, "sport", "teren-fotbal");
        Interval inter2 = new Pauza(11, 20);
        Interval inter3 = new OraCurs(15, 90, "Germana", "402");
        Interval inter4 = new ActivitateLibera(10, 60, "ciclism", "pista");
        Interval inter5 = inter4.duplicate();

        System.out.println(inter4.getId());
        System.out.println(Interval.getNextId());




    }

    }
