package Practica5.Ej4;

import Practica5.Ej1.Edge;
import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
        if (!lugares.isEmpty()){
            List<String> camino = new ArrayList<>();
            if (lugares.search(destino) != null){
                Vertex<String> inicio = lugares.search("Ayuntamiento");
                dfs(lugares, inicio, destino, maxTiempo, new boolean[lugares.getSize()], lugaresRestringidos, camino, new ArrayList<String>());
            }
            return camino;
        }
        else {
            return null;
        }
    }

    private void dfs(Graph<String> lugares, Vertex<String> vertice, String destino, int tiempo, boolean[] marcas, List<String> lugaresRestringidos, List<String> camino, List<String> caminoAct){
        if (camino != null){
            marcas[vertice.getPosition()] = true;
            caminoAct.add(vertice.getData());
            if (vertice.getData().equals(destino)){
                camino.removeAll(camino);
                camino.addAll(caminoAct);
            }
            else {
                for (Edge<String> e: lugares.getEdges(vertice)){
                    int i = e.getTarget().getPosition();
                    int costo = e.getWeight();
                    if (!marcas[i] && !lugaresRestringidos.contains(vertice.getData())){
                        if (tiempo-costo != 0){
                            dfs(lugares, vertice, destino, tiempo-costo, marcas, lugaresRestringidos, camino, caminoAct);
                        }
                    }
                }
            }
            marcas[vertice.getPosition()] = false;
            caminoAct.removeLast();
        }
    }
}
