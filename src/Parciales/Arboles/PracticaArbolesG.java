package Parciales.Arboles;

import Practica1.Ej8.Queue;
import Practica3.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class PracticaArbolesG {

    //Sumar los nodos de un arbol General
    public static int sumarNodos(GeneralTree<Integer> arbol){
        if (!arbol.isEmpty()){
            Queue<GeneralTree<Integer>> cola = new Queue<>();
            GeneralTree<Integer> aux;
            int suma = 0;
            cola.enQueue(arbol);
            while (!cola.isEmpty()){
                aux = cola.deQueue();
                suma += aux.getData();
                for (GeneralTree<Integer> c: aux.getChildren()){
                    cola.enQueue(c);
                }
            }
            return suma;
        }
        else {
            return 0;
        }
    }

    //Encontrar el camino donde la suma de sus nodos sea lo mas pequeño posible
    public static List<Integer> caminoSumMin(GeneralTree<Integer> arbol){
        if (!arbol.isEmpty()){
            dsf sumaYCamino = new dsf();
            sumaYCamino.setSuma(Integer.MAX_VALUE);
            int sumaAct = 0;
            caminoSumMinHelper(arbol, sumaYCamino, new ArrayList<>(), sumaAct);
            return sumaYCamino.getCamino();
        }
        else {
            return null;
        }
    }

    private static List<Integer> caminoSumMinHelper(GeneralTree<Integer> arbol, dsf sumaYCamino, List<Integer> caminoAct, int sumaAct){
        caminoAct.add(arbol.getData());
        sumaAct += arbol.getData();
        if (arbol.isLeaf()){
            if (sumaAct < sumaYCamino.getSuma()){
                sumaYCamino.setSuma(sumaAct);
                sumaYCamino.setCamino(new ArrayList<>(caminoAct));
            }
        }
        else {
            for (GeneralTree<Integer> c: arbol.getChildren()){
                caminoAct = caminoSumMinHelper(c, sumaYCamino, caminoAct, sumaAct);
                caminoAct.remove(caminoAct.size()-1);
            }
        }
        return caminoAct;
    }

    public static List<Integer> resolver(GeneralTree<Integer> arbol){
        List<Integer> sumaHijos = new ArrayList<>();
        recorrerArbol(arbol, sumaHijos);
        return sumaHijos;
    }

    private static int recorrerArbol(GeneralTree<Integer> arbol, List<Integer> lista){
        if (!arbol.isLeaf()) {
            int suma = 0;
            for (GeneralTree<Integer> c: arbol.getChildren()){
                boolean esImpar = (arbol.getChildren().size() % 2 != 0);
                if (esImpar){
                    suma += recorrerArbol(c, lista);
                }
                else {
                    recorrerArbol(c, lista);
                }
            }
            if (suma != 0) {
                lista.add(suma);
            }
        }
        return arbol.getData();
    }

    public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(45);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        List<GeneralTree<Integer>> hijos1 = new ArrayList<>();
        hijos1.add(nodo1); hijos1.add(nodo2); hijos1.add(nodo3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(64, hijos1);
        List<GeneralTree<Integer>> hijos4 = new ArrayList<>();
        hijos4.add(nodo4);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(22);
        List<GeneralTree<Integer>> hijos2 = new ArrayList<>();
        hijos2.add(nodo5); hijos2.add(nodo6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(11, hijos2);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(23);
        GeneralTree<Integer> nodo9 = new GeneralTree<>(1);
        List<GeneralTree<Integer>> hijos3 = new ArrayList<>();
        hijos3.add(nodo8); hijos3.add(nodo7); hijos3.add(nodo9);
        GeneralTree<Integer> nodo10 = new GeneralTree<>(57, hijos4);
        GeneralTree<Integer> nodo11 = new GeneralTree<>(44, hijos3);
        GeneralTree<Integer> nodo12 = new GeneralTree<>(33);
        GeneralTree<Integer> nodo13 = new GeneralTree<>(87);
        List<GeneralTree<Integer>> hijos5 = new ArrayList<>();
        hijos5.add(nodo12); hijos5.add(nodo13);
        GeneralTree<Integer> nodo14 = new GeneralTree<>(13, hijos5);
        GeneralTree<Integer> nodo15 = new GeneralTree<>(8);
        List<GeneralTree<Integer>> hijos6 = new ArrayList<>();
        hijos6.add(nodo14); hijos6.add(nodo15);
        GeneralTree<Integer> nodo16 = new GeneralTree<>(4, hijos6);
        List<GeneralTree<Integer>> hijosArbol = new ArrayList<>();
        hijosArbol.add(nodo10); hijosArbol.add(nodo11); hijosArbol.add(nodo16);
        GeneralTree<Integer> arbol = new GeneralTree<>(54, hijosArbol);

        System.out.println("Suma de Nodos: " + sumarNodos(arbol));
        System.out.println("Camino con la suma mas pequeña: " + caminoSumMin(arbol));
        System.out.println(resolver(arbol));
    }
}
