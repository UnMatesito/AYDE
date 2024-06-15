package Practica5.Ej5;

import Practica1.Ej8.Queue;
import Practica5.Ej1.Edge;
import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;

import java.util.*;

public class Programa {

    public List<String> quedateEnCasa(Graph<Persona> mapa, Persona empleado, int separacion){
        List<String> listaJubilados = new ArrayList<>();
        if (!mapa.isEmpty()){
            Vertex<Persona> inicio = buscarPersona(mapa, empleado);
            if (inicio != null){
                bfs(mapa, inicio, separacion, new boolean[mapa.getSize()], listaJubilados);
            }
            else {
                return null;
            }
        }
        return listaJubilados;
    }

    private Vertex<Persona> buscarPersona(Graph<Persona> mapa, Persona empleado){
        Iterator<Vertex<Persona>> it = mapa.getVertices().iterator();
        boolean encontre = false;
        Vertex<Persona> vertice = null;
        while (it.hasNext() && !encontre){
            Vertex<Persona> aux = it.next();
            if (aux.getData().getTipo().equals(empleado.getTipo())){
                vertice = aux;
                encontre = true;
            }
        }
        return vertice;
    }

    private void bfs(Graph<Persona> mapa, Vertex<Persona> vertice, int separacion, boolean[] marcas, List<String> lista){
        Queue<Vertex<Persona>> cola = new Queue<>();
        cola.enQueue(vertice);
        cola.enQueue(null);
        marcas[vertice.getPosition()] = true;
        while (!cola.isEmpty()){
            Vertex<Persona> aux = cola.deQueue();
            if (aux != null){
                Iterator<Edge<Persona>> it = mapa.getEdges(aux).iterator();
                while (it.hasNext() && lista.size() <= 40){
                    Vertex<Persona> destino = it.next().getTarget();
                    int i = destino.getPosition();
                    if (!marcas[i]) {
                        marcas[i] = true;
                        cola.enQueue(destino);
                        if (aux.getData().getTipo().equals("Jubilado")){
                            lista.add(aux.getData().getNombre());
                        }
                    }
                }
            }
            else {
                if (!cola.isEmpty()){
                    cola.enQueue(null);
                    separacion--;
                }
            }
        }
    }
}
