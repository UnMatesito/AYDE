package Parciales.Grafos;

import Practica5.Ej1.Edge;
import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;
import Practica5.Ej1.adjList.AdjListGraph;

import java.util.Iterator;

public class dddd {

    public static boolean esArbol(Graph<Integer> grafo){
        if (!grafo.isEmpty()){
            Vertex<Integer> inicio = grafo.search(1);
            if (inicio != null){
                return dfs(grafo, inicio, null, new boolean[grafo.getSize()]);
            }
        }
        return false;
    }

    private static boolean dfs(Graph<Integer> grafo, Vertex<Integer> vertice, Vertex<Integer> padre, boolean[] marcas){
        boolean esArbol = true;
        marcas[vertice.getPosition()] = true;
        Iterator<Edge<Integer>> it = grafo.getEdges(vertice).iterator();
        while (esArbol && it.hasNext()){
            Vertex<Integer> vecino = it.next().getTarget();
            int j = vecino.getPosition();
            if (!marcas[j]){
                esArbol = dfs(grafo, vecino, vertice, marcas);
            }
            else if (padre != vecino){
                return false;
            }
        }
        return esArbol;
    }

    public static void main(String[] args) {
        Graph<Integer> grafo = new AdjListGraph<>();

        Vertex<Integer> v1 = grafo.createVertex(1);
        Vertex<Integer> v2 = grafo.createVertex(2);
        Vertex<Integer> v3 = grafo.createVertex(3);
        Vertex<Integer> v4 = grafo.createVertex(4);

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v1, v3);
        grafo.connect(v3, v1);
        grafo.connect(v2, v4);
        grafo.connect(v4, v2);
        grafo.connect(v3, v4);
        grafo.connect(v4, v3);

        System.out.println(esArbol(grafo));
    }
}
