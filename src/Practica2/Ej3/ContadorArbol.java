package Practica2.Ej3;

import Practica1.Queue;
import Practica2.BinaryTree;

public class ContadorArbol {
    private BinaryTree<Integer> a;

    public ContadorArbol(BinaryTree<Integer> arbol){
        this.a = arbol;
    }

    public String numerosParesInOrden(){
        Queue<Integer> cola = new Queue<>();
        inOrden(a, cola);
        return cola.toString();
    }

    private void inOrden(BinaryTree<Integer> arbol, Queue<Integer> cola){
        if (arbol.hasLeftChild()){
            inOrden(arbol.getLeftChild(), cola);
        }
        if (arbol.getData() % 2 == 0) {
            cola.enQueue(arbol.getData());
        }
        if (arbol.hasRightChild()){
            inOrden(arbol.getRightChild() ,cola);
        }
    }

    public String numerosParesPostOrder(){
        Queue<Integer> cola = new Queue<>();
        postOrder(a, cola);
        return cola.toString();
    }

    private void postOrder(BinaryTree<Integer> arbol, Queue<Integer> cola){
        if (arbol.hasLeftChild()){
            postOrder(arbol.getLeftChild(), cola);
        }
        if (arbol.hasRightChild()){
            postOrder(arbol.getRightChild(), cola);
        }
        if (arbol.getData() % 2 == 0) {
            cola.enQueue(arbol.getData());
        }
    }
}
