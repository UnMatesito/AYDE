package Practica3.Ej8;

import Practica3.GeneralTree;

public class Navidad {
    private GeneralTree<Integer> abeto;

    public Navidad(GeneralTree<Integer> abeto) {
        this.abeto = abeto;
    }

    private boolean esAbetoHelper(GeneralTree<Integer> a){
        int cantHojas = 0;
        for (GeneralTree<Integer> c: a.getChildren()){
            if (c.isLeaf()){
                cantHojas++;
            }
            else if (!esAbetoHelper(c)){
                return false;
            }
        }
        return cantHojas >= 3;
    }

    public String esAbetoNavidenio(){
        boolean res = esAbetoHelper(abeto);
        if (res){
            return "Yes";
        }
        else {
            return "No";
        }
    }
}
