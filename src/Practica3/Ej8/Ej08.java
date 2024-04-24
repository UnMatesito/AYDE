package Practica3.Ej8;

import Practica3.GeneralTree;

import java.util.LinkedList;

public class Ej08 {
    public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(8);
        LinkedList<GeneralTree<Integer>> hijos1 = new LinkedList<>();
        hijos1.add(nodo1); hijos1.add(nodo2); hijos1.add(nodo3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(5, hijos1);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(6);
        LinkedList<GeneralTree<Integer>> hijos2 = new LinkedList<>();
        hijos2.add(nodo4); hijos2.add(nodo5); hijos2.add(nodo6); //hijos2.add(nodo7);
        GeneralTree<Integer> raiz = new GeneralTree<>(1, hijos2);
        Navidad metodo = new Navidad(raiz);
        System.out.println(metodo.esAbetoNavidenio());
    }
}
