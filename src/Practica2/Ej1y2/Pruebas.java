package Practica2.Ej1y2;

import Practica2.BinaryTree;

public class Pruebas {

    public static int sumar(BinaryTree<Integer> a){
        if (a.isLeaf()){
            return a.getData();
        }
        else {
            int suma = a.getData();
            if (a.hasLeftChild()){
                suma += sumar(a.getLeftChild());
            }
            if (a.hasRightChild()){
                suma += sumar(a.getRightChild());
            }
            return suma;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> a = new BinaryTree<>(10);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(8);
        a.addLeftChild(nodo1);
        a.addRightChild(nodo2);
        nodo2.addLeftChild(nodo3);
        System.out.println(sumar(a));
        System.out.println(a.contarHojas());
        BinaryTree<Integer> na;
        na = a.espejo();
        na.entreNiveles(0,2);
    }
}
