package app;

import java.util.ArrayList;
import java.util.List;
import app.Duplicabil;

public class CrossClass {

    public CrossClass(){


    }

    public List<Duplicabil> genereazaCopii (List<Duplicabil> arrDuplicabil){

        List <Duplicabil> arrCopii = new ArrayList<>();

        for (Duplicabil obiect: arrDuplicabil){
            Duplicabil copie = obiect.interfaceDuplicate(); //copiaza obiect
            arrCopii.add(copie);        //adauga in listaCopii
        }

        System.out.println("Lista originale: " + arrDuplicabil);
        System.out.println("Lista copii: " + arrCopii);


        return arrCopii;
    }
}
