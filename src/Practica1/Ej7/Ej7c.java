package Practica1.Ej7;

import Practica1.Ej3.Estudiante;

import java.util.*;

public class Ej7c {
    public static void agregarEstudiante(ArrayList<Estudiante> lista, Estudiante e){
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudainte");
        e.setNombre(s.nextLine());
        System.out.println("Ingrese el apellido del estudainte");
        e.setApellido(s.nextLine());
        System.out.println("Ingrese la comision del estudainte");
        e.setComision(s.nextLine());
        System.out.println("Ingrese el email del estudainte");
        e.setEmail(s.nextLine());
        System.out.println("Ingrese el direccion del estudainte");
        e.setDireccion(s.nextLine());
        lista.add(e);
    }

    public static void cargarDatos(ArrayList<Estudiante> lista){
        for (int i = 0; i < 3; i++) {
            Estudiante e = new Estudiante();
            agregarEstudiante(lista, e);
        }
    }

    public static void imprimir(ArrayList<Estudiante> lista1,  ArrayList<Estudiante> lista2){
        System.out.println("Lista Original");
        for (Estudiante es: lista1) {
            System.out.println(es.tusDatos());
        }
        System.out.println("Lista Copiada");
        for (Estudiante es: lista2) {
            System.out.println(es.tusDatos());
        }
    }

    public static void agregarEstudianteNuevo(ArrayList<Estudiante> lista, Iterator<Estudiante> it){
        Estudiante e = new Estudiante();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el nombre del alumno");
        String nombre = s.nextLine();
        int i = 0;
        while (i != lista.size()){
            if (lista.get(i).getNombre().equals(nombre)){
                System.out.println("El alumno se encuentra en la lista");
                break;
            }
            else{
                i++;
            }
        }
        if (i == lista.size()) {
            e.setNombre(nombre);
            System.out.println("Ingrese el apellido del estudainte");
            e.setApellido(s.nextLine());
            System.out.println("Ingrese la comision del estudainte");
            e.setComision(s.nextLine());
            System.out.println("Ingrese el email del estudainte");
            e.setEmail(s.nextLine());
            System.out.println("Ingrese el direccion del estudainte");
            e.setDireccion(s.nextLine());
            lista.add(e);
        }

    }

    public static void main(String[] args) {
        //Punto 1
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        cargarDatos(listaEstudiantes);
        //Punto 2
        ArrayList<Estudiante> listaCopia = new ArrayList<>();
        listaCopia.addAll(listaEstudiantes);
        //Punto 3
        imprimir(listaEstudiantes, listaCopia);
        //Punto 4
        System.out.println("Ingrese el nombre de un estudiante al que quiera realizar alguna modificacion");
        String nom = s.nextLine();
        int i = 0;
        Iterator<Estudiante> it = listaCopia.iterator();
        while (it.hasNext()){
            if (listaCopia.get(i).getNombre().equals(nom)){
                System.out.println("Alumno encontrado, puede modificar su comision");
                String com = s.nextLine();
                listaCopia.get(i).setComision(com);
            }
            i++;
            it.next();
        }
        //Punto 5
        imprimir(listaEstudiantes, listaCopia);
        //Punto 7e
        agregarEstudianteNuevo(listaCopia, it);
    }
}
