package Practica5.Ej4;

import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;
import Practica5.Ej1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class Ej4 {

    public static void main(String[] args) {
        Graph<String> oslo = new AdjListGraph<>();

        Vertex<String> v1 = oslo.createVertex("Holmenkollen");
        Vertex<String> v2 = oslo.createVertex("Vigeland Park");
        Vertex<String> v3 = oslo.createVertex("Folk Museum");
        Vertex<String> v4 = oslo.createVertex("Fram Museum");
        Vertex<String> v5 = oslo.createVertex("Polar Boat Museum");
        Vertex<String> v6 = oslo.createVertex("Viking Museum");
        Vertex<String> v7 = oslo.createVertex("National Gallery");
        Vertex<String> v8 = oslo.createVertex("Real Palace");
        Vertex<String> v9 = oslo.createVertex("Akker Bridge");
        Vertex<String> v10 = oslo.createVertex("Botanic Park");
        Vertex<String> v11 = oslo.createVertex("Ayuntamiento");
        Vertex<String> v12 = oslo.createVertex("Munch Museum");
        Vertex<String> v13 = oslo.createVertex("The Tiger");
        Vertex<String> v14 = oslo.createVertex("The Opera");
        Vertex<String> v15 = oslo.createVertex("Akerhaus Fortress");

        oslo.connect(v1, v2, 30);
        oslo.connect(v2, v1, 30);

        oslo.connect(v2, v3, 20);
        oslo.connect(v3, v2, 20);
        oslo.connect(v2, v7, 10);
        oslo.connect(v7, v2, 10);

        oslo.connect(v3, v4, 5);
        oslo.connect(v4, v3, 5);
        oslo.connect(v3, v8, 5);
        oslo.connect(v8, v3, 5);
        oslo.connect(v3, v9, 30);
        oslo.connect(v9, v3, 30);

        oslo.connect(v4, v5, 5);
        oslo.connect(v5, v4, 5);

        oslo.connect(v5, v6, 5);
        oslo.connect(v6, v5, 5);

        oslo.connect(v6, v9, 30);
        oslo.connect(v9, v6, 30);

        oslo.connect(v7, v10, 15);
        oslo.connect(v10, v7, 15);

        oslo.connect(v8, v11, 5);
        oslo.connect(v11, v8, 5);

        oslo.connect(v9, v11, 20);
        oslo.connect(v11, v9, 20);

        oslo.connect(v10, v12, 1);
        oslo.connect(v12, v10, 1);
        oslo.connect(v10, v11, 10);
        oslo.connect(v11, v10, 10);

        oslo.connect(v11, v13, 15);
        oslo.connect(v13, v11, 15);

        oslo.connect(v12, v13, 15);
        oslo.connect(v13, v12, 15);

        oslo.connect(v13, v14, 5);
        oslo.connect(v14, v13, 5);

        oslo.connect(v14, v15, 10);
        oslo.connect(v15, v14, 10);

        List<String> excluidos = new ArrayList<>();

        excluidos.add(v8.getData());
        excluidos.add(v9.getData());

        VisitaOslo metodo = new VisitaOslo();

        metodo.paseoEnBici(oslo, v6.getData(), 120, excluidos);
    }
}
