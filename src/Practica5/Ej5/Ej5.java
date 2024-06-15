package Practica5.Ej5;

import Practica5.Ej1.Graph;
import Practica5.Ej1.Vertex;
import Practica5.Ej1.adjList.AdjListGraph;

public class Ej5 {
    public static void main(String[] args) {
        Graph<Persona> mapa = new AdjListGraph<>();

        Vertex<Persona> p1 = mapa.createVertex(new Persona("Juan", "Empleado", "Calle A 123"));
        Vertex<Persona> p2 = mapa.createVertex(new Persona("Maria", "Jubilado", "Calle B 456"));
        Vertex<Persona> p3 = mapa.createVertex(new Persona("Carlos", "Empleado", "Calle C 789"));
        Vertex<Persona> p4 = mapa.createVertex(new Persona("Ana", "Jubilado", "Calle D 101"));
        Vertex<Persona> p5 = mapa.createVertex(new Persona("Luis", "Jubilado", "Calle E 202"));
        Vertex<Persona> p6 = mapa.createVertex(new Persona("Elena", "Jubilado", "Calle F 303"));
        Vertex<Persona> p7 = mapa.createVertex(new Persona("Marta", "Empleado", "Calle G 404"));
        Vertex<Persona> p8 = mapa.createVertex(new Persona("Diego", "Jubilado", "Calle H 505"));
        Vertex<Persona> p9 = mapa.createVertex(new Persona("Laura", "Jubilado", "Calle I 606"));
        Vertex<Persona> p10 = mapa.createVertex(new Persona("Pedro", "Jubilado", "Calle J 707"));
        Vertex<Persona> p11 = mapa.createVertex(new Persona("Sofia", "Jubilado", "Calle K 808"));
        Vertex<Persona> p12 = mapa.createVertex(new Persona("Fernando", "Jubilado", "Calle L 909"));

        mapa.connect(p1, p2);
        mapa.connect(p1, p3);
        mapa.connect(p2, p4);
        mapa.connect(p4, p5);
        mapa.connect(p5, p6);
        mapa.connect(p5, p2);
        mapa.connect(p3, p5);
        mapa.connect(p4, p3);
        mapa.connect(p6, p7);
        mapa.connect(p7, p8);
        mapa.connect(p8, p9);
        mapa.connect(p9, p10);
        mapa.connect(p10, p11);
        mapa.connect(p11, p12);
        mapa.connect(p12, p1);
        mapa.connect(p3, p10);
        mapa.connect(p6, p11);
        mapa.connect(p7, p9);

        Programa metodo = new Programa();

        System.out.println(metodo.quedateEnCasa(mapa, p1.getData(), 5));
    }
}
