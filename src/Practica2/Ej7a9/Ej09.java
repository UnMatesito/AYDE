package Practica2.Ej7a9;

import Practica2.BinaryTree;

public class Ej09 {

    public static void imprimirArbol(BinaryTree<Integer> arbol){
        System.out.println(arbol.getData());
        if (arbol.hasLeftChild()){
            imprimirArbol(arbol.getLeftChild());
        }
        if (arbol.hasRightChild()){
            imprimirArbol(arbol.getRightChild());
        }
    }

    public static void imprimirArbol2(BinaryTree<SumYDif> arbol){
        System.out.println(arbol.getData().toString());
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(20);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(30);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(-5);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(10);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(50);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(-9);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(1);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(6);
        arbol.addLeftChild(nodo1);
        arbol.addRightChild(nodo2);
        nodo1.addLeftChild(nodo3);
        nodo1.addRightChild(nodo4);
        nodo4.addLeftChild(nodo7);
        nodo2.addLeftChild(nodo5);
        nodo2.addRightChild(nodo6);
        nodo5.addRightChild(nodo8);
        nodo8.addRightChild(nodo9);
        imprimirArbol(arbol);
        System.out.println();
        ParcialArboles metodo = new ParcialArboles();
        imprimirArbol2(metodo.SumAndDif(arbol));
    }
}
