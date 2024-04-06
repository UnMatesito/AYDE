package Practica2.Ej5;

import Practica1.Queue;
import Practica2.BinaryTree;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> a;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
        this.a = a;
    }

    public int sumaElementosProfundidad(int p){
        if (a.isEmpty()) {
            return 0;
        }
        BinaryTree<Integer> aux;
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enQueue(a);
        cola.enQueue(null);
        int profundidad = 0;
        int suma = 0;
        while (!cola.isEmpty() && profundidad <= p){
            aux = cola.deQueue();
            if (aux != null) {
                suma += aux.getData();
                if (aux.hasLeftChild()) {
                    cola.enQueue(aux.getLeftChild());
                }
                if (aux.hasRightChild()) {
                    cola.enQueue(aux.getRightChild());
                }
            }
            else {
                profundidad++;
                if (!cola.isEmpty()){
                    cola.enQueue(null);
                }
            }
        }
        return suma;
    }
}
