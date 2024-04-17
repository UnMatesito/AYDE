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

    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree<Integer> a, Integer n){
        List<Integer> lista = new ArrayList<>();
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> aux;
        cola.enQueue(a);
        while(!cola.isEmpty()){
            aux = cola.deQueue();
            if (aux.getChildren().getFirst().getData() > n && aux.getChildren().getFirst().getData() % 2 != 0){
                lista.add(aux.getChildren().getFirst().getData());
            }
            if (aux.getData() > n && aux.getData() % 2 != 0){
                lista.add(aux.getData());
            }
            List<GeneralTree<Integer>> children = aux.getChildren();
            for (GeneralTree<Integer> c: children){
                List<Integer> sublist = numerosImparesMayoresQueInOrden(c, n);
                lista.addAll(sublist);
            }
        }
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
