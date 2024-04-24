package Practica3.Ej6;

import Practica1.Ej8.Queue;
import Practica3.GeneralTree;

import java.util.List;

public class RedDeAguaPotable {
    private GeneralTree<Character> arbol;

    public RedDeAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }

    private double minimoCaudalHelper(GeneralTree<Character> a, double caudal) {
        double minCaudal = caudal;
        if (!a.hasChildren()) {
            return minCaudal;
        }
        else {
            caudal = caudal/a.getChildren().size();
            for (GeneralTree<Character> c: a.getChildren()){
                double minimo = minimoCaudalHelper(c, caudal);
                if (minimo < minCaudal){
                    minCaudal = minimo;
                }
            }
        }
        return minCaudal;
    }

    public double minimoCaudal(double caudal){
        if (arbol.isEmpty()){
            return 0;
        }
        else if(arbol.isLeaf()){
            return caudal;
        }
        else {
            return minimoCaudalHelper(arbol, caudal);
        }
    }
}
