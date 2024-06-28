package Parciales.Grafos;

import Practica5.Ej1.Edge;
import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parcial {

    public String resolver(Graph<Sitio> sitios, int tiempo){
        String mensaje = "No Alcanzable";
        if (!sitios.isEmpty()){
            List<String> camino = new ArrayList<>();
            Vertex<Sitio> inicio = buscarEntrada(sitios, "Entrada");
            if (inicio != null){
                dfs(sitios, inicio, tiempo-inicio.getData().getTiempo(), new boolean[sitios.getSize()], camino, new ArrayList<>());
                if (camino.size() == sitios.getSize()){
                    mensaje = "Alcanzable";
                }
            }
        }
        return mensaje;
    }

    private void dfs(Graph<Sitio> grafo, Vertex<Sitio> vertice, int tiempo, boolean[] marcas, List<String> camino, List<String> caminoAct){
        marcas[vertice.getPosition()] = true;
        caminoAct.add(vertice.getData().getNombre());
        for (Edge<Sitio> e: grafo.getEdges(vertice)){
            int j = e.getTarget().getPosition();
            if (!marcas[j]){
                tiempo -= e.getWeight();
                if (tiempo > 0 && camino.size() != grafo.getSize()){
                    dfs(grafo, e.getTarget(), tiempo-e.getTarget().getData().getTiempo(), marcas, camino, caminoAct);
                }
            }
        }
        if (caminoAct.size() == grafo.getSize()){
            camino.removeAll(camino);
            camino.addAll(caminoAct);
        }
        marcas[vertice.getPosition()] = false;
        caminoAct.remove(caminoAct.size()-1);
    }

    private Vertex<Sitio> buscarEntrada(Graph<Sitio> grafo, String destino){
        Iterator<Vertex<Sitio>> it = grafo.getVertices().iterator();
        boolean encontre = false;
        Vertex<Sitio> vertice = null;
        while(!encontre && it.hasNext()){
            Vertex<Sitio> aux = it.next();
            if (aux.getData().getNombre().equals(destino)){
                encontre = true;
                vertice = aux;
            }
        }
        return vertice;
    }

    public int resolver2(Graph<Sitio> sitios, int tiempo){
        List<String> camino = new ArrayList<>();
        if (!sitios.isEmpty()){
            Vertex<Sitio> inicio = buscarEntrada(sitios, "Entrada");
            if (inicio != null){
                dfs2(sitios, inicio, tiempo-inicio.getData().getTiempo(), new boolean[sitios.getSize()], camino, new ArrayList<>());
                System.out.println(camino);
            }
        }
        return camino.size();
    }

    private void dfs2(Graph<Sitio> grafo, Vertex<Sitio> vertice, int tiempo, boolean[] marcas, List<String> camino, List<String> caminoAct){
        marcas[vertice.getPosition()] = true;
        caminoAct.add(vertice.getData().getNombre());
        for (Edge<Sitio> e: grafo.getEdges(vertice)){
            int j = e.getTarget().getPosition();
            if (!marcas[j]){
                int tiempoAct = tiempo - e.getWeight();
                if (tiempoAct - e.getTarget().getData().getTiempo() > 0){
                    dfs2(grafo, e.getTarget(), tiempoAct-e.getTarget().getData().getTiempo(), marcas, camino, caminoAct);
                }
            }
        }
        if (caminoAct.size() > camino.size()){
            camino.clear();
            camino.addAll(caminoAct);
        }
        marcas[vertice.getPosition()] = false;
        caminoAct.removeLast();

    }
}
