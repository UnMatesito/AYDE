package Practica3.Ej4;

import Practica1.Ej8.Queue;
import Practica3.GeneralTree;

import java.util.List;

public class AnalizadorArbol {
    private double max;

    /* En este caso utilizamos
        recorrido por niveles porque necesitamos saber todos los hijos de los
        nodos de la raiz/subarboles para hacer la suma total de nodos y
        determinar el promedio maximo
     */
    private double buscarMaximo(double prom, double max){
        if (prom > max){
            this.max = prom;
        }
        return this.max;
    }

    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol){
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
        GeneralTree<AreaEmpresa> aux;
        cola.enQueue(arbol);
        cola.enQueue(null);
        int suma = 0;
        int cantElementosNivel = 0;
        while (!cola.isEmpty()){
            aux = cola.deQueue();
            if (aux != null){
                suma += aux.getData().getTrans();
                cantElementosNivel++;
                List<GeneralTree<AreaEmpresa>> children = aux.getChildren();
                for (GeneralTree<AreaEmpresa> c: children){
                    cola.enQueue(c);
                }
            }
            else {
                int prom = suma /cantElementosNivel;
                if (!cola.isEmpty()){
                    cola.enQueue(null);
                    buscarMaximo(prom, max);
                    suma = 0;
                    cantElementosNivel = 0;
                }
            }
        }
        return max;
    }
}
