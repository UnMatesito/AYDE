package Practica3.Ej7;

import Practica3.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class Ej07 {
    public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
        List<GeneralTree<Integer>> hijos1 = new ArrayList<>();
        hijos1.add(nodo1);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(16);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(7);
        List<GeneralTree<Integer>> hijos2 = new ArrayList<>();
        hijos2.add(nodo2); hijos2.add(nodo3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(10);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(6, hijos1);
        List<GeneralTree<Integer>> hijos3 = new ArrayList<>();
        hijos3.add(nodo4); hijos3.add(nodo5);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(8);
        List<GeneralTree<Integer>> hijos4 = new ArrayList<>();
        hijos4.add(nodo6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(14, hijos2);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(18);
        List<GeneralTree<Integer>> hijos5 = new ArrayList<>();
        hijos5.add(nodo7); hijos5.add(nodo8);
        GeneralTree<Integer> nodo9 = new GeneralTree<>(17, hijos3);
        GeneralTree<Integer> nodo10 = new GeneralTree<>(9, hijos4);
        GeneralTree<Integer> nodo11 = new GeneralTree<>(15, hijos5);
        List<GeneralTree<Integer>> hijos6 = new ArrayList<>();
        hijos6.add(nodo9); hijos6.add(nodo10); hijos6.add(nodo11);
        GeneralTree<Integer> raiz = new GeneralTree<>(12, hijos6);
        Caminos metodo = new Caminos(raiz);
        System.out.println(metodo.caminoAHojaMasLejana().toString());
    }
}
