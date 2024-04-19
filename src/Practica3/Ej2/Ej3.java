package Practica3.Ej2;

import Practica3.GeneralTree;

import java.util.ArrayList;

public class Ej3 {
    public static void main(String[] args) {
        GeneralTree<Integer> nodo = new GeneralTree<>(5);
        ArrayList<GeneralTree<Integer>> hijos1 = new ArrayList<>();
        hijos1.add(nodo);
        ArrayList<GeneralTree<Integer>> hijos2 = new ArrayList<>();
        GeneralTree<Integer> nodo1 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(10, hijos1);
        hijos2.add(nodo1);
        hijos2.add(nodo2);
        ArrayList<GeneralTree<Integer>> hijos4 = new ArrayList<>();
        GeneralTree<Integer> nodo3 = new GeneralTree<>(8);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(4, hijos2);
        hijos4.add(nodo3);
        hijos4.add(nodo4);
        hijos4.add(nodo5);
        GeneralTree<Integer> raiz = new GeneralTree<>(20, hijos4);
        System.out.println(raiz.altura());
        System.out.println(raiz.nivel(5));
        System.out.println(raiz.ancho());
    }
}
