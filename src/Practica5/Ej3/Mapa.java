package Practica5.Ej3;

import Practica1.Ej8.Queue;
import Practica5.Ej1.Edge;
import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private Graph<String> mapaciudades;

    public Mapa(Graph<String> mapaciudades) {
        this.mapaciudades = mapaciudades;
    }

    public List<String> devolverCamino(String ciudad1, String ciudad2){
        boolean[] marcas = new boolean[mapaciudades.getSize()];
        List<String> camino = new ArrayList<>();
        if (mapaciudades.search(ciudad1) != null){
            Vertex<String> inicio = mapaciudades.search(ciudad1);
            devolerCaminoHelper(inicio, ciudad2, marcas, camino);
        }
        else {
            camino = null;
        }
        return camino;
    }

    private boolean devolerCaminoHelper(Vertex<String> vertice, String destino, boolean[] marcas, List<String> camino){
        int pos = vertice.getPosition();
        if (marcas[pos]){
            return false;
        }
        else
            marcas[pos] = true;
        camino.add(vertice.getData());
        if (vertice.getData().equals(destino)){
            return true;
        }
        for (Edge<String> e: mapaciudades.getEdges(vertice)){
            if (devolerCaminoHelper(e.getTarget(), destino, marcas, camino)){
                return true;
            }
        }
        camino.remove(camino.size()-1);
        return false;
    }

    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String>ciudades){
        boolean[] marcas = new boolean[mapaciudades.getSize()];
        List<String> camino = new ArrayList<>();
        if (mapaciudades.search(ciudad1) != null){
            Vertex<String> inicio = mapaciudades.search(ciudad1);
            devolverCaminoExceptuandoHelper(inicio, ciudad2, marcas, camino, ciudades);
        }
        else {
            camino = null;
        }
        return camino;
    }

    private boolean devolverCaminoExceptuandoHelper(Vertex<String> vertice, String destino, boolean[] marcas, List<String> camino, List<String> excepto){
        int pos = vertice.getPosition();
        if (marcas[pos]){
            return false;
        }
        else {
            marcas[pos] = true;
        }
        camino.add(vertice.getData());
        if (vertice.getData().equals(destino)){
            return true;
        }
        for (Edge<String> e: mapaciudades.getEdges(vertice)){
            if (!excepto.contains(e.getTarget().getData())) {
                if (devolverCaminoExceptuandoHelper(e.getTarget(), destino, marcas, camino, excepto)) {
                    return true;
                }
            }
        }
        camino.remove(camino.size()-1);
        return false;
    }

    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        boolean[] marcas = new boolean[mapaciudades.getSize()];
        List<String> camino = new ArrayList<>();
        List<String> caminoMin = new ArrayList<>();
        if (mapaciudades.search(ciudad1) != null){
            Vertex<String> inicio = mapaciudades.search(ciudad1);
            caminoMasCortoHelper(inicio, ciudad2, marcas, camino);
        }
        return caminoMin;
    }

    private boolean caminoMasCortoHelper(Vertex<String> vertice, String destino, boolean[] marcas, List<String> camino){
        Queue<Vertex<String>> cola = new Queue<>();
        marcas[vertice.getPosition()] = true;
        cola.enQueue(vertice);
        while (!cola.isEmpty()) {
            vertice = cola.deQueue();
            camino.add(vertice.getData());
            if (vertice.getData().equals(destino)){
                return true;
            }
            for (Edge<String> e: mapaciudades.getEdges(vertice)){
                int i = e.getTarget().getPosition();
                if (!marcas[i]){
                    marcas[i] = true;
                    cola.enQueue(e.getTarget());
                }
            }
        }
        return false;
    }

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        return null;
    }

    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        return null;
    }
}
