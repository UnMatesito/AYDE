package Practica2.Ej7a9;

import Practica2.BinaryTree;

public class Ej07 {

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(3);
        arbol.addLeftChild(nodo1);
        arbol.addRightChild(nodo2);
        nodo1.addLeftChild(nodo3);
        nodo3.addLeftChild(nodo4);
        ParcialArboles metodo = new ParcialArboles(arbol);
        System.out.println(metodo.isLeftTree(5));
    }
}
