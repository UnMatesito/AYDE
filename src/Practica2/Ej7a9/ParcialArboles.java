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

    private void creacionArbol(BinaryTree<SumYDif> a2, BinaryTree<Integer> a1, int suma, int aux){
        a2.setData(new SumYDif(suma, a1.getData()-aux));
        if (a1.hasLeftChild()){
            a2.addLeftChild(new BinaryTree<SumYDif>());
            creacionArbol(a2.getLeftChild(), a1.getLeftChild(), suma+a1.getLeftChild().getData(), a1.getData());
        }
        if (a1.hasRightChild()){
            a2.addRightChild(new BinaryTree<SumYDif>());
            creacionArbol(a2.getRightChild(), a1.getRightChild(), suma + a1.getRightChild().getData(), a1.getData());
        }
    }

    public BinaryTree<SumYDif> SumAndDif(BinaryTree<Integer> arbol){
        BinaryTree<SumYDif> newArbol = new BinaryTree<>();
        if (!arbol.isEmpty()){
            creacionArbol(newArbol, arbol, 0, 0);
        }
        return newArbol;
    }

}
