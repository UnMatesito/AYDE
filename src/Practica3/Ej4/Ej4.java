package Practica3.Ej4;

import Practica3.GeneralTree;

import java.util.LinkedList;

public class Ej4 {
    public static void main(String[] args) {
        AreaEmpresa aeN1 = new AreaEmpresa("A", 4);
        AreaEmpresa aeN2 = new AreaEmpresa("B", 7);
        AreaEmpresa aeN3 = new AreaEmpresa("C", 5);
        AreaEmpresa aeN4 = new AreaEmpresa("D", 6);
        AreaEmpresa aeN5 = new AreaEmpresa("E", 10);
        AreaEmpresa aeN6 = new AreaEmpresa("F", 18);
        AreaEmpresa aeN7 = new AreaEmpresa("G", 9);
        AreaEmpresa aeN8 = new AreaEmpresa("H", 12);
        AreaEmpresa aeN9 = new AreaEmpresa("I", 19);
        GeneralTree<AreaEmpresa> nodo1 = new GeneralTree<>(aeN1);
        GeneralTree<AreaEmpresa> nodo2 = new GeneralTree<>(aeN2);
        GeneralTree<AreaEmpresa> nodo3 = new GeneralTree<>(aeN3);
        GeneralTree<AreaEmpresa> nodo4 = new GeneralTree<>(aeN4);
        GeneralTree<AreaEmpresa> nodo5 = new GeneralTree<>(aeN5);
        GeneralTree<AreaEmpresa> nodo6 = new GeneralTree<>(aeN6);
        GeneralTree<AreaEmpresa> nodo7 = new GeneralTree<>(aeN7);
        GeneralTree<AreaEmpresa> nodo8 = new GeneralTree<>(aeN8);
        GeneralTree<AreaEmpresa> nodo9 = new GeneralTree<>(aeN9);
        LinkedList<GeneralTree<AreaEmpresa>> hijos1 = new LinkedList<>();
        LinkedList<GeneralTree<AreaEmpresa>> hijos2 = new LinkedList<>();
        LinkedList<GeneralTree<AreaEmpresa>> hijos3 = new LinkedList<>();
        hijos1.add(nodo1);
        hijos1.add(nodo2);
        hijos1.add(nodo3);
        hijos2.add(nodo4);
        hijos2.add(nodo5);
        hijos2.add(nodo6);
        hijos3.add(nodo7);
        hijos3.add(nodo8);
        hijos3.add(nodo9);
        GeneralTree<AreaEmpresa> raiz = getAreaEmpresaGeneralTree(hijos1, hijos2, hijos3);
        AnalizadorArbol metodo = new AnalizadorArbol();
        System.out.println(metodo.devolverMaximoPromedio(raiz));
    }

    private static GeneralTree<AreaEmpresa> getAreaEmpresaGeneralTree(LinkedList<GeneralTree<AreaEmpresa>> hijos1, LinkedList<GeneralTree<AreaEmpresa>> hijos2, LinkedList<GeneralTree<AreaEmpresa>> hijos3) {
        AreaEmpresa aeN10 = new AreaEmpresa("J", 13);
        AreaEmpresa aeN11 = new AreaEmpresa("K", 25);
        AreaEmpresa aeN12 = new AreaEmpresa("L", 10);
        GeneralTree<AreaEmpresa> nodo10 = new GeneralTree<>(aeN10, hijos1);
        GeneralTree<AreaEmpresa> nodo11 = new GeneralTree<>(aeN11, hijos2);
        GeneralTree<AreaEmpresa> nodo12 = new GeneralTree<>(aeN12, hijos3);
        LinkedList<GeneralTree<AreaEmpresa>> hijos4 = new LinkedList<>();
        hijos4.add(nodo10);
        hijos4.add(nodo11);
        hijos4.add(nodo12);
        AreaEmpresa aeR = new AreaEmpresa("M", 14);
        GeneralTree<AreaEmpresa> raiz = new GeneralTree<>(aeR, hijos4);
        return raiz;
    }
}
