package Practica2.Ej6;

import Practica2.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> a;

    public Transformacion(BinaryTree<Integer> a) {
        this.a = a;
    }

    private int sumar(BinaryTree<Integer> ab){
        int suma = 0;
        if (ab.isLeaf()){
            suma = ab.getData();
            ab.setData(0);
            return suma;
        }
        if (ab.hasLeftChild()){
            suma += sumar(ab.getLeftChild());
        }
        if (ab.hasRightChild()){
            suma += sumar(ab.getRightChild());
        }
        int aux = ab.getData();
        ab.setData(suma);
        return suma + aux;
    }

    public BinaryTree<Integer> suma(){
        if (!a.isEmpty()){
            sumar(a);
        }
        return this.a;
    }
}
