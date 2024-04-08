package Practica2.Ej7a9;

import Practica2.BinaryTree;

public class Ej08 {

    public static void main(String[] args) {
        BinaryTree<Integer> arbol1 = new BinaryTree<>(10);
        BinaryTree<Integer> nodoa1 = new BinaryTree<>(7);
        BinaryTree<Integer> nodoa2 = new BinaryTree<>(5);
        arbol1.addLeftChild(nodoa1);
        arbol1.addRightChild(nodoa2);
        BinaryTree<Integer> arbol2 = new BinaryTree<>(10);
        BinaryTree<Integer> nodob1 = new BinaryTree<>(7);
        BinaryTree<Integer> nodob2 = new BinaryTree<>(5);
        BinaryTree<Integer> nodob3 = new BinaryTree<>(1);
        BinaryTree<Integer> nodob4 = new BinaryTree<>(2);
        arbol2.addLeftChild(nodob1);
        arbol2.addRightChild(nodob2);
        nodob1.addLeftChild(nodob3);
        nodob4.addRightChild(nodob4);
        ParcialArboles metodo = new ParcialArboles();
        System.out.println(metodo.esPrefijo(arbol1, arbol2));
    }
}
