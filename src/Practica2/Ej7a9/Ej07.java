package Practica2.Ej7a9;

import Practica2.BinaryTree;

public class Ej07 {

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(2);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(-5);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(23);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(19);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(-3);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(55);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(11);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(18);
        BinaryTree<Integer> nodo11 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo12 = new BinaryTree<>(23);
        BinaryTree<Integer> nodo13 = new BinaryTree<>(8);
        BinaryTree<Integer> nodo14 = new BinaryTree<>(19);
        arbol.addLeftChild(nodo1);
        arbol.addRightChild(nodo2);
        nodo1.addLeftChild(nodo3);
        nodo1.addRightChild(nodo4);
        nodo2.addLeftChild(nodo5);
        nodo3.addLeftChild(nodo6);
        nodo4.addLeftChild(nodo7);
        nodo4.addRightChild(nodo8);
        nodo5.addRightChild(nodo9);
        nodo9.addLeftChild(nodo10);
        nodo6.addLeftChild(nodo11);
        nodo6.addRightChild(nodo12);
        nodo7.addLeftChild(nodo13);
        nodo8.addLeftChild(nodo14);
        ParcialArboles metodo = new ParcialArboles(arbol);
        System.out.println(metodo.isLeftTree(6));
    }
}
