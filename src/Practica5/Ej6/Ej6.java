package Practica5.Ej6;

import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;
import Practica5.Ej1.adjList.AdjListGraph;

public class Ej6 {

    public static void main(String[] args) {
        Graph<String> bosque = new AdjListGraph<>();

        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 1");
        Vertex<String> v3 = bosque.createVertex("Claro 2");
        Vertex<String> v4 = bosque.createVertex("Claro 3");
        Vertex<String> v5 = bosque.createVertex("Claro 4");
        Vertex<String> v6 = bosque.createVertex("Claro 5");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");

        bosque.connect(v1, v4, 4);
        bosque.connect(v1, v2, 3);
        bosque.connect(v1, v3, 4);

        bosque.connect(v4, v6, 15);

        bosque.connect(v2, v6, 3);

        bosque.connect(v3, v2, 4);
        bosque.connect(v3, v6, 11);
        bosque.connect(v3, v5, 10);

        bosque.connect(v6, v7, 4);

        bosque.connect(v5, v7, 9);

        BuscadorDeCaminos metodo = new BuscadorDeCaminos(bosque);

        System.out.println(metodo.recorridosMasSeguros());
    }
}
