package Practica5.Ej2;

import Practica1.Ej8.Queue;
import Practica5.Ej1.Edge;
import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Recorridos<T> {
    public List<T> dfs(Graph<T> grafo){
        List<T> elementos = new ArrayList<>();
        boolean [] marcas = new boolean[grafo.getSize()];
        for (int i= 0; i < grafo.getSize(); i++){
            if (!marcas[i]){
                dfsHelper(i, grafo, marcas, elementos);
            }
        }
        return elementos;
    }

    private void dfsHelper(int i, Graph<T> grafo, boolean[] marcas, List<T> elementos){
        marcas[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        elementos.add(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v);
        for (Edge<T> e: adyacentes){
            int j = e.getTarget().getPosition();
            if (!marcas[j]){
                dfsHelper(j, grafo, marcas, elementos);
            }
        }
    }

    public List<T> bfs(Graph<T> grafo){
        boolean[] marcas = new boolean[grafo.getSize()];
        List<T> elementos = new ArrayList<>();
        bfsHelper(0, grafo, marcas, elementos);
        return elementos;
    }

    private void bfsHelper(int i, Graph<T> grafo , boolean[] marcas, List<T> elementos){
        Queue<Vertex<T>> cola = new Queue<>();
        cola.enQueue(grafo.getVertex(i));
        marcas[i] = true;
        while(!cola.isEmpty()){
            Vertex<T> vertice = cola.deQueue();
            elementos.add(vertice.getData());
            List<Edge<T>> adyacentes = grafo.getEdges(vertice);
            for (Edge<T> e:adyacentes){
                int j = e.getTarget().getPosition();
                if (!marcas[j]){
                    marcas[j] = true;
                    cola.enQueue(e.getTarget());
                }
            }
        }
    }

}
