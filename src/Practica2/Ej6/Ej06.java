package Practica2.Ej6;

import Practica2.BinaryTree;

public class Ej06 {
    public static void imprimirArbol(BinaryTree<Integer> arbol){
        System.out.println(arbol.getData());
        if (arbol.hasLeftChild()){
            imprimirArbol(arbol.getLeftChild());
        }
        if (arbol.hasRightChild()){
            imprimirArbol(arbol.getRightChild());
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(1);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(8);
        arbol.addLeftChild(nodo1);
        arbol.addRightChild(nodo2);
        nodo1.addRightChild(nodo3);
        nodo2.addLeftChild(nodo4);
        nodo2.addRightChild(nodo5);
        nodo4.addLeftChild(nodo6);
        nodo4.addRightChild(nodo7);
        System.out.println("Viejo Arbol");
        imprimirArbol(arbol);
        Transformacion metodo = new Transformacion(arbol);
        System.out.println("Nuevo Arbol");
        imprimirArbol(metodo.suma());
    }
}
