package Practica3.Ej9a11;

import Practica1.Ej8.Queue;
import Practica3.GeneralTree;

import javax.imageio.stream.IIOByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public static List<Integer> resolverEJ10(GeneralTree<Integer> arbol){
        if (!arbol.isEmpty()){
            valorYLista maximo = new valorYLista();
            maximo.setValor(Integer.MIN_VALUE);
            camFiltradoMax(arbol, maximo, 0, new valorYLista());
            System.out.println(maximo.getValor());
            return maximo.getLista();
        }
        else {
            return null;
        }
    }

    private static List<Integer> camFiltradoMax(GeneralTree<Integer> arbol, valorYLista maximo, int nivel, valorYLista actual){
        if (arbol.getData() != 0){
            actual.setValor(actual.getValor() + arbol.getData() * nivel);
            actual.getLista().add(arbol.getData());
        }
        if (arbol.isLeaf()) {
            if (actual.getValor() > maximo.getValor()){
                maximo.setValor(actual.getValor());
                maximo.setLista(new ArrayList<>(actual.getLista()));
                }
            }
        else{
            for (GeneralTree<Integer> c: arbol.getChildren()){
                camFiltradoMax(c, maximo, nivel+1, actual);
                if (arbol.getData() != 0) {
                    actual.getLista().removeLast();
                }
            }
        }
        actual.setValor(actual.getValor() - arbol.getData() * nivel);
        return actual.getLista();
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
