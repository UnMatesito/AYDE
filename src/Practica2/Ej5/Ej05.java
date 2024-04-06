package Practica2.Ej5;

import Practica2.BinaryTree;

public class Ej05 {

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(10);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(5);
        arbol.addLeftChild(nodo1);
        arbol.addRightChild(nodo2);
        nodo2.addLeftChild(nodo3);
        nodo3.addRightChild(nodo4);
        ProfundidadDeArbolBinario metodo = new ProfundidadDeArbolBinario(arbol);
        System.out.println(metodo.sumaElementosProfundidad(3));
    }
}
