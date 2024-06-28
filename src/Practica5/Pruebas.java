package Practica5;

import Practica5.Ej1.Edge;
import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;
import Practica5.Ej1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;


public class Pruebas {
    public static List<List<Integer>> mostarCaminos(Graph<Integer> grafo, int num1, int num2){
        List<List<Integer>> listaCaminos = new ArrayList<>();
        boolean [] marcas = new boolean[grafo.getSize()];
        Vertex<Integer> inicio = grafo.search(num1);
        List<Integer> path = new ArrayList<>();
        crearCamino(grafo, inicio, num2, marcas, path, listaCaminos);
        return listaCaminos;
    }

    private static void crearCamino(Graph<Integer> grafo, Vertex<Integer> inicio, int destino, boolean[] marcas, List<Integer> path, List<List<Integer>> listaCaminos){
        marcas[inicio.getPosition()] = true;
        path.add(inicio.getData());
        if (inicio.getData().equals(destino)){
            listaCaminos.add(new ArrayList<>(path));
        }
        else  {
            for (Edge<Integer> e: grafo.getEdges(inicio)){
                int j = e.getTarget().getPosition();
                if (!marcas[j]){
                    crearCamino(grafo, e.getTarget(), destino, marcas, path, listaCaminos);
                }
            }
        }
        path.removeLast();
        marcas[inicio.getPosition()] = false;
    }

    public static void main(String[] args) {
        Graph<Integer> grafo = new AdjListGraph<>();

        Vertex<Integer> v1 = grafo.createVertex(2);
        Vertex<Integer> v2 = grafo.createVertex(5);
        Vertex<Integer> v3 = grafo.createVertex(3);
        Vertex<Integer> v4 = grafo.createVertex(7);
        Vertex<Integer> v5 = grafo.createVertex(1);
        Vertex<Integer> v6 = grafo.createVertex(4);

        grafo.connect(v1, v2, 45);
        grafo.connect(v1, v3, 15);
        grafo.connect(v2, v4, 20);
        grafo.connect(v4, v5, 3);
        grafo.connect(v5, v6, 24);
        grafo.connect(v5, v2, 14);
        grafo.connect(v3, v5, 9);
        grafo.connect(v4, v3, 33);


        System.out.println(mostarCaminos(grafo, 2, 4));
    }
}
