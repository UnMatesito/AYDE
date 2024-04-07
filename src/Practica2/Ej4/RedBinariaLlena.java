package Practica2.Ej4;

import Practica2.BinaryTree;

public class RedBinariaLlena {

    public int retardoEnvio(BinaryTree<Integer> arbol){
        if (arbol.isLeaf()){
            return arbol.getData();
        }
        int l = 0;
        int r = 0;
        if (arbol.hasLeftChild()){
            l = retardoEnvio(arbol.getLeftChild());
        }
        if (arbol.hasRightChild()){
            r = retardoEnvio(arbol.getRightChild());
        }
        if (l > r){
            return arbol.getData()+l;
        }
        else {
            return arbol.getData()+r;
        }
    }
}
