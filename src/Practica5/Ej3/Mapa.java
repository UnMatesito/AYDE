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
        if (mapaciudades.search(ciudad1) != null && mapaciudades.search(ciudad2) != null){
            Vertex<String> inicio = mapaciudades.search(ciudad1);
            caminoMasCortoHelper(inicio, ciudad2, marcas, camino, new ArrayList<>(), 0, Integer.MAX_VALUE);
        }
        return camino;
    }

    private int caminoMasCortoHelper(Vertex<String> vertice, String destino, boolean[] marcas, List<String> camino, List<String> caminoAct, int pesoTotal, int pesoMin){
        marcas[vertice.getPosition()] = true;
        caminoAct.add(vertice.getData());
        if (vertice.getData().equals(destino) && pesoTotal < pesoMin){
            camino.removeAll(camino);
            camino.addAll(caminoAct);
            pesoMin = pesoTotal;
        }
        else {
            for (Edge<String> e:mapaciudades.getEdges(vertice)){
                int j = e.getTarget().getPosition();
                if (!marcas[j]){
                    int aux = pesoTotal + e.getWeight();
                    pesoMin = caminoMasCortoHelper(e.getTarget(), destino, marcas, camino, caminoAct, aux, pesoMin);
                }
            }
        }
        caminoAct.remove(caminoAct.size()-1);
        marcas[vertice.getPosition()] = false;
        return pesoMin;
    }

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new ArrayList<>();
        boolean [] marcas = new boolean[mapaciudades.getSize()];
        if (mapaciudades.search(ciudad1) != null && mapaciudades.search(ciudad2) != null){
            Vertex<String> inicio = mapaciudades.search(ciudad1);
            caminoSinCargarCombustibleHelper(inicio, ciudad2, marcas, camino, tanqueAuto);
        }
        return camino;
    }

    private List<String> caminoSinCargarCombustibleHelper(Vertex<String> vertice, String destino, boolean[] marcas, List<String> camino, int tanque){
        marcas[vertice.getPosition()] = true;
        camino.add(vertice.getData());
        if (tanque < 0 || vertice.getData().equals(destino)){
            return camino;
        }
        else{
            for (Edge<String> e: mapaciudades.getEdges(vertice)){
                int j = e.getTarget().getPosition();
                int combustible = e.getWeight();
                if (!marcas[j]){
                    if (tanque > 0) {
                        caminoSinCargarCombustibleHelper(e.getTarget(), destino, marcas, camino, tanque - combustible);
                    }
                    else {
                        marcas[vertice.getPosition()] = false;
                        camino.removeLast();
                    }
                }
            }
        }
        return camino;
    }

    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        return null;
    }
}

