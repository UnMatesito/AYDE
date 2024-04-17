package Practica3.Ej2;

import Practica3.GeneralTree;

import java.util.*;

public class Ej2 {

    public static void main(String[] args) {
        LinkedList<GeneralTree<Integer>> hijos = new LinkedList<>();
        GeneralTree<Integer> nodo1 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(5);
        hijos.add(nodo1);
        hijos.add(nodo2);
        hijos.add(nodo3);
        hijos.add(nodo4);
        GeneralTree<Integer> raiz = new GeneralTree<>(1, hijos);
        RecorridosAG metodo = new RecorridosAG();
        System.out.println(metodo.numerosImaperesMayoresQuePreOrden(raiz, 0).toString());
        System.out.println(metodo.numerosImparesMayoresQueInOrden(raiz, 0).toString());
        System.out.println(metodo.numerosImparesMayoresQuePostOrden(raiz, 0).toString());
        System.out.println(metodo.numerosImparesMayoresQuePorNiveles(raiz, 2).toString());
    }
}
