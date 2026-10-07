package app.OrarScheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    private List<Orar> listaOrare;

    public Scheduler(){

    }


    public List<Orar> getListaOrare(){
        return listaOrare;
    }



    public void setListaOrare(List<Orar> listaOrare) {
        this.listaOrare = listaOrare;
    }

    public void creeazaOrar(){
        Orar orar = new Orar();
    }

    public void afiseazaOrar(Orar orar){
        orar.afisare();
    }

    public Scheduler duplicate(){
        Scheduler copieScheduler = new Scheduler();

        for (Orar o : listaOrare){
            copieScheduler.getListaOrare().add(o.duplicate());
        }

        return copieScheduler;
    }


}
