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

    private int isLeftTreeHelper(BinaryTree<Integer> arbol){
        if (arbol.isLeaf()){
            return 0;
        }
        else if (arbol.hasLeftChild() && !arbol.hasRightChild()) {
            return 1 + isLeftTreeHelper(arbol.getLeftChild());
        }
        else if (arbol.hasRightChild() && !arbol.hasLeftChild()) {
            return 1 + isLeftTreeHelper(arbol.getRightChild());
        }
        return isLeftTreeHelper(arbol.getLeftChild()) + isLeftTreeHelper(arbol.getRightChild());
    }

    private BinaryTree<Integer> buscarNum(BinaryTree<Integer> arbol, int num){
        if (arbol.getData() == num){
            return arbol;
        }
        BinaryTree<Integer> ab = null;
        if (arbol.hasLeftChild()){
            ab = buscarNum(arbol.getLeftChild(), num);
        }
        if (arbol.hasRightChild() && (ab == null)){
            ab = buscarNum(arbol.getRightChild(), num);
        }
        return ab;
    }

    public boolean isLeftTree(int num){
        BinaryTree<Integer> aux = buscarNum(a, num);
        int hi;
        int hd;
        if (aux == null){
            return false;
        }
        if (aux.hasLeftChild()){
            hi = isLeftTreeHelper(aux.getLeftChild());
        }
        else {
            hi = -1;
        }
        if (aux.hasRightChild()){
            hd = isLeftTreeHelper(aux.getRightChild());
        }
        else {
            hd = -1;
        }
        return hi > hd;
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
