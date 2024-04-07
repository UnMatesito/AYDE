package Practica2.Ej4;

import Practica2.BinaryTree;

public class Ej04 {

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(17);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(9);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(25);
        arbol.addLeftChild(nodo1);
        arbol.addRightChild(nodo2);
        nodo1.addLeftChild(nodo3);
        nodo1.addRightChild(nodo4);
        nodo2.addLeftChild(nodo5);
        nodo2.addRightChild(nodo6);
        RedBinariaLlena metodo = new RedBinariaLlena();
        System.out.println(metodo.retardoEnvio(arbol));
    }
}
