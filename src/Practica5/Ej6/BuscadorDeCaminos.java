package Practica5.Ej6;

import Practica5.Ej1.Edge;
import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }

    public List<List<String>> recorridosMasSeguros(){
        if (!bosque.isEmpty()){
            List<List<String>> caminos = new ArrayList<>();
            if (bosque.search("Casa Caperucita") != null && bosque.search("Casa Abuelita") != null){
                Vertex<String> inicio = bosque.search("Casa Caperucita");
                dfs(inicio, "Casa Abuelita", new boolean[bosque.getSize()], caminos, new ArrayList<>());
                return caminos;
            }
            else {
                return null;
            }
        }
        else  {
            return null;
        }
    }

    private void dfs(Vertex<String> vertice, String destino, boolean[] marcas, List<List<String>> caminos, List<String> caminoAct){
        marcas[vertice.getPosition()] = true;
        caminoAct.add(vertice.getData());
        if (vertice.getData().equals(destino)){
            caminos.add(new ArrayList<>(caminoAct));
        }
        else {
            for (Edge<String> e: bosque.getEdges(vertice)){
                int i = e.getTarget().getPosition();
                int cantArboles = e.getWeight();
                if (cantArboles < 5){
                    if (!marcas[i]){
                        dfs(e.getTarget(), destino, marcas, caminos, caminoAct);
                    }
                }
            }
        }
        marcas[vertice.getPosition()] = false;
        caminoAct.removeLast();
    }
}
