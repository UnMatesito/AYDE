package Practica3.Ej9a11;

import Practica3.GeneralTree;

import java.util.LinkedList;

public class Ej10 {
    public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
        LinkedList<GeneralTree<Integer>> hijos1 = new LinkedList<>();
        hijos1.add(nodo1);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(0);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(0);
        LinkedList<GeneralTree<Integer>> hijos2 = new LinkedList<>();
        hijos2.add(nodo2); hijos2.add(nodo3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(1);
        LinkedList<GeneralTree<Integer>> hijos3 = new LinkedList<>();
        hijos3.add(nodo4); hijos3.add(nodo5); hijos3.add(nodo6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(0, hijos1);
        LinkedList<GeneralTree<Integer>> hijos4 = new LinkedList<>();
        hijos4.add(nodo7);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(0, hijos2);
        LinkedList<GeneralTree<Integer>> hijos5 = new LinkedList<>();
        hijos5.add(nodo8);
        GeneralTree<Integer> nodo9 = new GeneralTree<>(1, hijos3);
        GeneralTree<Integer> nodo10 = new GeneralTree<>(1);
        LinkedList<GeneralTree<Integer>> hijos6 = new LinkedList<>();
        hijos6.add(nodo9); hijos6.add(nodo10);
        GeneralTree<Integer> nodo11 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo12 = new GeneralTree<>(0, hijos4);
        LinkedList<GeneralTree<Integer>> hijos7 = new LinkedList<>();
        hijos7.add(nodo11); hijos7.add(nodo12);
        GeneralTree<Integer> nodo13 = new GeneralTree<>(0, hijos4);
        LinkedList<GeneralTree<Integer>> hijos8 = new LinkedList<>();
        hijos8.add(nodo13);
        GeneralTree<Integer> nodo14 = new GeneralTree<>(0, hijos6);
        GeneralTree<Integer> nodo15 = new GeneralTree<>(1, hijos7);
        GeneralTree<Integer> nodo16 = new GeneralTree<>(1, hijos8);
        LinkedList<GeneralTree<Integer>> hijos9 = new LinkedList<>();
        hijos9.add(nodo14); hijos9.add(nodo15); hijos9.add(nodo16);
        GeneralTree<Integer> arbol = new GeneralTree<>(1, hijos9);

        System.out.println(ParcialArboles.resolverEJ10(arbol));
    }
}
