package Practica3.Ej9a11;

import Practica1.Ej8.Queue;
import Practica3.GeneralTree;

import java.util.Iterator;

public class ParcialArboles {

    private static boolean esDeSeleccionHelper(GeneralTree<Integer> arbol) {
        boolean seleccion = true;
        int minimo = Integer.MAX_VALUE;
        if (arbol.isLeaf()){
            return true;
        }
        else {
            Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
            while (it.hasNext() && seleccion){
                GeneralTree<Integer> child = it.next();
                if (child.getData() < minimo){
                    minimo = child.getData();
                }
                seleccion = esDeSeleccionHelper(child);
            }
        }
        return (minimo == arbol.getData() && seleccion);
    }

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if (arbol.isEmpty()){
            return false;
        }
        else if (arbol.isLeaf()){
            return true;
        }
        else {
            return esDeSeleccionHelper(arbol);
        }
    }

    private static boolean arbolCreciente(GeneralTree<Integer> arbol){
        int cantNodos = 0;
        int nivel = 0;
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enQueue(arbol);
        cola.enQueue(null);
        while (!cola.isEmpty()){
            aux = cola.deQueue();
            if (aux != null){
                cantNodos++;
                for (GeneralTree<Integer> c: aux.getChildren()){
                    cola.enQueue(c);
                }
            }
            else{
                if (!cola.isEmpty()){
                    nivel++;
                    if (cantNodos != nivel){
                        return false;
                    }
                    cantNodos = 0;
                    cola.enQueue(null);
                }
            }
        }
        return true;
    }


    public static boolean resolver(GeneralTree<Integer> arbol){
        if (arbol.isEmpty()){
            return false;
        }
        else if (arbol.isLeaf()){
            return true;
        }
        else {
            return arbolCreciente(arbol);
        }
    }

}
