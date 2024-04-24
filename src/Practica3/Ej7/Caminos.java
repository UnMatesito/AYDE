package Practica3.Ej7;

import Practica3.GeneralTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Caminos {
    private GeneralTree<Integer> arbol;

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    private void armarLista(GeneralTree<Integer> a, List<Integer> caminoAct, List<Integer> caminoMax){
        caminoAct.add(a.getData());
        if (!a.isLeaf()){
            for (GeneralTree<Integer> c: a.getChildren()){
                armarLista(c, caminoAct, caminoMax);
            }
        }
        else if (caminoAct.size() > caminoMax.size()){
            caminoMax.removeAll(caminoMax);
            caminoMax.addAll(caminoAct);
        }
        caminoAct.remove(caminoAct.size()-1);
    }

    public List<Integer> caminoAHojaMasLejana(){
        List<Integer> caminoMax = new LinkedList<>();
        List<Integer> caminoAct = new LinkedList<>();
        if (!arbol.isEmpty()){
            armarLista(arbol, caminoAct, caminoMax);
        }
        return caminoMax;
    }
}
