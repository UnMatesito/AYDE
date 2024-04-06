package Practica2.Ej3;

import Practica2.BinaryTree;

public class Ej03 {

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(4);
        arbol.addLeftChild(nodo1);
        arbol.addRightChild(nodo2);
        ContadorArbol metodoIO = new ContadorArbol(arbol);
        System.out.println(metodoIO.numerosParesInOrden());
        ContadorArbol metodoPO = new ContadorArbol(arbol);
        System.out.println(metodoPO.numerosParesPostOrder());
    }
}
