package Parciales.Grafos;

import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;
import Practica5.Ej1.adjList.AdjListGraph;

public class GrafoPruba {
    public static void main(String[] args) {
        Graph<Sitio> sitios = new AdjListGraph<>();

        Vertex<Sitio> entrada = sitios.createVertex(new Sitio("Entrada", 15));
        Vertex<Sitio> cebras = sitios.createVertex(new Sitio("Cebras", 10));
        Vertex<Sitio> tigres = sitios.createVertex(new Sitio("Tigres", 10));
        Vertex<Sitio> tortugas = sitios.createVertex(new Sitio("Tortugas", 10));
        Vertex<Sitio> pumas = sitios.createVertex(new Sitio("Pumas", 10));
        Vertex<Sitio> wallabies = sitios.createVertex(new Sitio("Wallabies", 30));
        Vertex<Sitio> murcielagos = sitios.createVertex(new Sitio("Murciélagos", 20));
        Vertex<Sitio> flamencos = sitios.createVertex(new Sitio("Flamencos", 10));

        sitios.connect(entrada, cebras, 10);
        sitios.connect(cebras, entrada, 10);
        sitios.connect(entrada, tigres, 15);
        sitios.connect(tigres, entrada, 15);
        sitios.connect(entrada, murcielagos, 20);
        sitios.connect(murcielagos, entrada, 20);
        sitios.connect(entrada, flamencos, 25);
        sitios.connect(flamencos, entrada, 25);
        sitios.connect(cebras, tortugas, 5);
        sitios.connect(tortugas, cebras, 5);
        sitios.connect(tigres, cebras, 8);
        sitios.connect(cebras, tigres, 8);
        sitios.connect(tortugas, pumas, 15);
        sitios.connect(pumas, tortugas, 15);
        sitios.connect(tortugas, wallabies, 10);
        sitios.connect(wallabies, tortugas, 10);
        sitios.connect(wallabies, murcielagos, 10);
        sitios.connect(murcielagos, wallabies, 10);
        sitios.connect(wallabies, pumas, 2);
        sitios.connect(pumas, wallabies, 2);
        sitios.connect(murcielagos, flamencos, 25);
        sitios.connect(flamencos, murcielagos, 25);

        Parcial metodo = new Parcial();
        System.out.println(metodo.resolver(sitios, 220));
        System.out.println(metodo.resolver2(sitios, 100));
    }
}
