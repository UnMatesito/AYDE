package Practica5.Ej2;

import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;
import Practica5.Ej1.adjList.AdjListGraph;

public class Ej2 {
    public static void main(String[] args) {
        Graph<Integer> grafo = new AdjListGraph<>();
        Vertex<Integer> v1 = grafo.createVertex(4);
        Vertex<Integer> v2 = grafo.createVertex(10);
        Vertex<Integer> v3 = grafo.createVertex(5);
        Vertex<Integer> v4 = grafo.createVertex(23);
        Vertex<Integer> v5 = grafo.createVertex(15);
        Vertex<Integer> v6 = grafo.createVertex(2);

        grafo.connect(v1, v2);
        grafo.connect(v1, v3);
        grafo.connect(v2, v3);
        grafo.connect(v2,v4);
        grafo.connect(v3,v5);
        grafo.connect(v4,v6);
        grafo.connect(v5,v6);

        Recorridos<Integer> metodo = new Recorridos<>();

        System.out.println(metodo.dfs(grafo));
        System.out.println(metodo.bfs(grafo));
    }
}
