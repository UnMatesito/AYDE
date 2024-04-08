package Practica2.Ej7a9;

import Practica1.Ej8.Queue;
import Practica2.BinaryTree;

import java.util.ArrayList;

public class ParcialArboles {
    private BinaryTree<Integer> a;

    public ParcialArboles(){

    }

    public ParcialArboles(BinaryTree<Integer> a) {
        this.a = a;
    }

    public boolean isLeftTree(int num){
        BinaryTree<Integer> aux;
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enQueue(a);
        cola.enQueue(null);
        while (!cola.isEmpty()){
            aux = cola.deQueue();
            if (aux != null) {
                if (num == aux.getData()){
                    return aux.hasLeftChild() && !aux.hasRightChild();
                }
                if (a.hasLeftChild()) {
                    cola.enQueue(aux.getLeftChild());
                }
                if (a.hasRightChild()) {
                    cola.enQueue(aux.getRightChild());
                }
            }
            else {
                cola.enQueue(null);
            }
        }
        return false;
    }

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if (!arbol1.getData().equals(arbol2.getData())){
            return false;
        }
        else {
            boolean res = true;
            if (arbol1.hasLeftChild()) {
                if (arbol2.hasLeftChild()) {
                    res = esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
                }
            }
            if (arbol1.hasRightChild()) {
                if (arbol2.hasRightChild()) {
                    res = esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
                }
            }
            return res;
        }
    }


}
