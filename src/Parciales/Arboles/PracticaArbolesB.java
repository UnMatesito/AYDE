package Parciales.Arboles;

import Practica1.Ej8.Queue;
import Practica2.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PracticaArbolesB {
    public static int contarNodos(BinaryTree<Integer> arbol){
        if (!arbol.isEmpty()){
            int contador = 0;
            Queue<BinaryTree<Integer>> cola = new Queue<>();
            BinaryTree<Integer> aux;
            cola.enQueue(arbol);
            while (!cola.isEmpty()) {
                aux = cola.deQueue();
                contador++;
                if (aux.hasLeftChild()){
                    cola.enQueue(aux.getLeftChild());
                }
                if (aux.hasRightChild()){
                    cola.enQueue(aux.getRightChild());
                }
            }
            return contador;
        }
        else {
            return 0;
        }
    }

    public static int sumaNodos(BinaryTree<Integer> arbol){
        if (!arbol.isEmpty()){
            int suma = 0;
            Queue<BinaryTree<Integer>> cola = new Queue<>();
            BinaryTree<Integer> aux;
            cola.enQueue(arbol);
            while (!cola.isEmpty()){
                aux = cola.deQueue();
                suma += aux.getData();
                if (aux.hasLeftChild()){
                    cola.enQueue(aux.getLeftChild());
                }
                if (aux.hasRightChild()){
                    cola.enQueue(aux.getRightChild());
                }
            }
            return suma;
        }
        else {
            return 0;
        }
    }

    public static int buscarMaximo(BinaryTree<Integer> arbol){
        if (!arbol.isEmpty()){
            int max = Integer.MIN_VALUE;
            return buscarMaximoHelper(arbol, max);
        }
        else {
            return -1;
        }
    }

    private static int buscarMaximoHelper(BinaryTree<Integer> arbol, int max){
        if (arbol.hasLeftChild()){
            max = buscarMaximoHelper(arbol.getLeftChild(), max);
        }
        if (arbol.getData() > max){
            max = arbol.getData();
        }
        if (arbol.hasRightChild()){
            max = buscarMaximoHelper(arbol.getRightChild(), max);
        }
        return max;
    }

    public static boolean estaBalanceado(BinaryTree<Integer> arbol){
        int altLeft = determinarAltura(arbol.getLeftChild());
        int altRight = determinarAltura(arbol.getRightChild());
        return (altRight - altLeft == 1) || (altLeft - altRight == 1) || (altLeft - altRight == 0);
    }

    private static int determinarAltura(BinaryTree<Integer> arbol){
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        BinaryTree<Integer> aux;
        int altura = 0;
        cola.enQueue(arbol);
        cola.enQueue(null);
        while (!cola.isEmpty()){
            aux = cola.deQueue();
            if (aux != null){
                if (aux.hasLeftChild()){
                    cola.enQueue(aux.getLeftChild());
                }
                if (aux.hasRightChild()){
                    cola.enQueue(aux.getRightChild());
                }
            }
            else {
                if (!cola.isEmpty()){
                    altura++;
                    cola.enQueue(null);
                }
            }
        }
        return altura;
    }

    public static List<Integer> caminoAnodo(BinaryTree<Integer> arbol, int num1, int num2){
        if (!arbol.isEmpty()){
            BinaryTree<Integer> nodo1 = buscarNodo1(arbol, num1);
            if (nodo1 != null) {
                List<Integer> camino = new ArrayList<>();
                construirCamino(nodo1, num2, camino, new ArrayList<>());
                return camino;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    private static BinaryTree<Integer> buscarNodo1(BinaryTree<Integer> arbol, int destino){
        if (arbol == null || arbol.getData().equals(destino)){
            return arbol;
        }
        BinaryTree<Integer> nodo = null;
        if (arbol.hasLeftChild()){
            nodo = buscarNodo1(arbol.getLeftChild(), destino);
        }
        if (nodo == null && arbol.hasRightChild()){
            nodo = buscarNodo1(arbol.getRightChild(), destino);
        }
        return nodo;
    }

    private static List<Integer> construirCamino(BinaryTree<Integer> arbol, int destino, List<Integer> camino, List<Integer> caminoAct){
        caminoAct.add(arbol.getData());
        if (arbol.getData().equals(destino)){
            camino.addAll(caminoAct);
            return caminoAct;
        }
        else {
            if (arbol.hasLeftChild()){
                caminoAct = construirCamino(arbol.getLeftChild(), destino, camino, caminoAct);
            }
            if (arbol.hasRightChild()){
                caminoAct = construirCamino(arbol.getRightChild(), destino, camino, caminoAct);
            }
            caminoAct.remove(caminoAct.size() -1);
        }
        return caminoAct;
    }

    public static List<Integer> resolver(BinaryTree<Integer> arbol, int min){
        List<Integer> camino = new ArrayList<>();
        resolverHelper(arbol, min, camino, new ArrayList<>());
        return camino;
    }

    private static List<Integer> resolverHelper(BinaryTree<Integer> arbol, int min, List<Integer> camino, List<Integer> caminoAct) {
        caminoAct.add(arbol.getData());
        if (arbol.isLeaf()) {
            if (min <= 0) {
                camino.removeAll(camino);
                camino.addAll(caminoAct);
                return camino;
            }
        } else {
            if (arbol.getData() % 2 == 0) {
                min--;
            }
            if (arbol.hasLeftChild() && camino.isEmpty()) {
                resolverHelper(arbol.getLeftChild(), min, camino, caminoAct);
            }
            if (arbol.hasRightChild() && camino.isEmpty()) {
                resolverHelper(arbol.getRightChild(), min, camino, caminoAct);
            }
            caminoAct.remove(caminoAct.size() - 1);
        }
        return camino;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(7);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(8);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(10);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(34);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(67);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(44);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(11);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(73);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(23);
        BinaryTree<Integer> nodo11 = new BinaryTree<>(16);

        nodo9.addLeftChild(nodo10);
        nodo9.addRightChild(nodo11);
        nodo6.addLeftChild(nodo7);
        nodo6.addRightChild(nodo8);
        nodo5.addLeftChild(nodo6);
        nodo5.addRightChild(nodo4);
        nodo3.addLeftChild(nodo9);
        nodo2.addLeftChild(nodo5);
        nodo1.addRightChild(nodo3);
        arbol.addLeftChild(nodo1);
        arbol.addRightChild(nodo2);

        System.out.println("Numero de nodos en el arbol: " + contarNodos(arbol));
        System.out.println("Suma de todos los nodos: " + sumaNodos(arbol));
        System.out.println("Numero mas grande del arbol: " + buscarMaximo(arbol));
        System.out.println(estaBalanceado(arbol));
        System.out.println(caminoAnodo(arbol, 10, 7));
        System.out.println(resolver(arbol, 2));
    }
}
