package Practica3.Ej6;

import Practica3.GeneralTree;

import java.util.LinkedList;

public class Ej06 {
    public static void main(String[] args) {
        GeneralTree<Character> nodo1 = new GeneralTree<>('M');
        GeneralTree<Character> nodo2 = new GeneralTree<>('N');
        LinkedList<GeneralTree<Character>> hijos1 = new LinkedList<>();
        hijos1.add(nodo1); hijos1.add(nodo2);
        GeneralTree<Character> nodo3 = new GeneralTree<>('L');
        LinkedList<GeneralTree<Character>> hijos2 = new LinkedList<>();
        hijos2.add(nodo3);
        GeneralTree<Character> nodo4 = new GeneralTree<>('H');
        GeneralTree<Character> nodo5 = new GeneralTree<>('I');
        GeneralTree<Character> nodo6 = new GeneralTree<>('J', hijos1);
        GeneralTree<Character> nodo7 = new GeneralTree<>('K');
        GeneralTree<Character> nodo8 = new GeneralTree<>('P');
        LinkedList<GeneralTree<Character>> hijos3 = new LinkedList<>();
        hijos3.add(nodo4); hijos3.add(nodo5); hijos3.add(nodo6); hijos3.add(nodo7); hijos3.add(nodo8);
        GeneralTree<Character> nodo9 = new GeneralTree<>('F');
        GeneralTree<Character> nodo10 = new GeneralTree<>('G', hijos2);
        LinkedList<GeneralTree<Character>> hijos4 = new LinkedList<>();
        hijos4.add(nodo9); hijos4.add(nodo10);
        GeneralTree<Character> nodo11 = new GeneralTree<>('B');
        GeneralTree<Character> nodo12 = new GeneralTree<>('C', hijos4);
        GeneralTree<Character> nodo13 = new GeneralTree<>('D', hijos3);
        GeneralTree<Character> nodo14 = new GeneralTree<>('E');
        LinkedList<GeneralTree<Character>> hijos5 = new LinkedList<>();
        hijos5.add(nodo11); hijos5.add(nodo12); hijos5.add(nodo13); hijos5.add(nodo14);
        GeneralTree<Character> raiz = new GeneralTree<>('A', hijos5);
        RedDeAguaPotable metodo = new RedDeAguaPotable(raiz);
        System.out.println(metodo.minimoCaudal(1000));
    }
}
