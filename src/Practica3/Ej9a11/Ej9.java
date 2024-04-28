package Practica3.Ej9a11;

import Practica3.GeneralTree;

import java.util.*;

public class Ej9 {
    public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(35);
        LinkedList<GeneralTree<Integer>> hijos1 = new LinkedList<>();
        hijos1.add(nodo1);

        GeneralTree<Integer> nodo2 = new GeneralTree<>(35);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(83);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(90);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(33);
        LinkedList<GeneralTree<Integer>> hijos2 = new LinkedList<>();
        hijos2.add(nodo2); hijos2.add(nodo3); hijos2.add(nodo4); hijos2.add(nodo5);

        GeneralTree<Integer> nodo6 = new GeneralTree<>(35, hijos1);
        LinkedList<GeneralTree<Integer>> hijos3 = new LinkedList<>();
        hijos3.add(nodo6);

        GeneralTree<Integer> nodo7 = new GeneralTree<>(14);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(12);
        GeneralTree<Integer> nodo9 = new GeneralTree<>(33, hijos2);
        LinkedList<GeneralTree<Integer>> hijos4 = new LinkedList<>();
        hijos4.add(nodo7); hijos4.add(nodo8); hijos4.add(nodo9);

        GeneralTree<Integer> nodo10 = new GeneralTree<>(35, hijos3);
        GeneralTree<Integer> nodo11 = new GeneralTree<>(12, hijos4);
        LinkedList<GeneralTree<Integer>> hijos5 = new LinkedList<>();
        hijos5.add(nodo10); hijos5.add(nodo11);

        GeneralTree<Integer> nodo12 = new GeneralTree<>(25);
        LinkedList<GeneralTree<Integer>> hijos6 = new LinkedList<>();
        hijos6.add(nodo12);

        GeneralTree<Integer> nodo13 = new GeneralTree<>(12, hijos5);
        GeneralTree<Integer> nodo14 = new GeneralTree<>(25, hijos6);
        LinkedList<GeneralTree<Integer>> hijos7 = new LinkedList<>();
        hijos7.add(nodo13); hijos7.add(nodo14);

        GeneralTree<Integer> raiz = new GeneralTree<>(12, hijos7);

        System.out.println(ParcialArboles.esDeSeleccion(raiz));
    }
}
