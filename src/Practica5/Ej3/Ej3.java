package Practica5.Ej3;

import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;
import Practica5.Ej1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class Ej3 {
    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<>();

        Vertex<String> v1 = ciudades.createVertex("New York");
        Vertex<String> v2 = ciudades.createVertex("Berlin");
        Vertex<String> v3 = ciudades.createVertex("Oslo");
        Vertex<String> v4 = ciudades.createVertex("Bucarest");
        Vertex<String> v5 = ciudades.createVertex("Riga");
        Vertex<String> v6 = ciudades.createVertex("Madrid");

        ciudades.connect(v1, v2, 45);
        ciudades.connect(v1, v3, 15);
        ciudades.connect(v2, v4, 20);
        ciudades.connect(v4, v5, 3);
        ciudades.connect(v5, v6, 24);
        ciudades.connect(v5, v2, 14);
        ciudades.connect(v3, v5, 9);
        ciudades.connect(v4, v3, 33);

        Mapa metodo = new Mapa(ciudades);
        System.out.println("Camino");
        System.out.println(metodo.devolverCamino("New York", "Oslo") + "\n");

        System.out.println("Camino Exceptuando");
        List<String> excepto = new ArrayList<>();
        excepto.add(v2.getData());
        excepto.add(v4.getData());
        System.out.println(metodo.devolverCaminoExceptuando("New York", "Madrid", excepto)+ "\n");

        System.out.println("Camino mas corto");
        System.out.println(metodo.caminoMasCorto("New York", "Madrid")+ "\n");

        System.out.println("Camino sin cargar combustible");
        System.out.println(metodo.caminoSinCargarCombustible("New York", "Madrid", 50) + "\n");
    }
}
