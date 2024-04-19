package Practica3.Ej2;

import Practica3.GeneralTree;
import java.util.*;
import Practica1.Ej8.Queue;

public class RecorridosAG {

    public List<Integer> numerosImaperesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n){
        List<Integer> lista = new ArrayList<>();
        if (a.getData() > n && a.getData() % 2 != 0){
            lista.add(a.getData());
        }
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> c: children){
            List<Integer> sublist = numerosImaperesMayoresQuePreOrden(c, n);
            lista.addAll(sublist);
        }
        return lista;
    }

    private static void numerosImparesMayoresQueInOrdenHelper(GeneralTree<Integer> a,int n, List<Integer> l) {
        if(!a.isLeaf()) {
            List<GeneralTree<Integer>> children = a.getChildren();
            numerosImparesMayoresQueInOrdenHelper(children.get(0),n,l);
            int data = a.getData();
            if(data > n && data % 2 != 0) l.add(data);
            for(int i = 1; i < children.size(); i++) {
                numerosImparesMayoresQueInOrdenHelper(children.get(i),n,l);
            }
        } else {
            int data = a.getData();
            if(data > n && data % 2 != 0){
                l.add(data);
            }
        }
    }

    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree<Integer> a, Integer n){
        List<Integer> lista = new ArrayList<>();
        numerosImparesMayoresQueInOrdenHelper(a, n, lista);
        return lista;
    }

    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> lista = new ArrayList<>();
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> c: children){
            List<Integer> sublist = numerosImparesMayoresQuePostOrden(c, n);
            lista.addAll(sublist);
        }
        if (a.getData() > n && a.getData() % 2 != 0){
            lista.add(a.getData());
        }
        return lista;
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
        List<Integer> lista = new ArrayList<>();
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enQueue(a);
        while (!cola.isEmpty()){
            aux = cola.deQueue();
            if (aux.getData() > n && aux.getData() % 2 != 0) {
                lista.add(aux.getData());
            }
            List<GeneralTree<Integer>> children = aux.getChildren();
            for (GeneralTree<Integer> c : children){
                cola.enQueue(c);
            }
        }
        return lista;
    }
}
