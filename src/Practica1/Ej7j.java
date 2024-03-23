package Practica1;

import java.util.ArrayList;

public class Ej7j {

    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        int j=0;
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < lista1.size(); i++) {
            while ((j != lista2.size()) && (lista1.get(i) > lista2.get(j))){
                lista.add(lista2.get(j));
                j++;
            }
            lista.add(lista1.get(i));
        }
        return lista;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(5);
        lista1.add(10);
        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(3);
        lista2.add(4);
        lista2.add(7);
        ArrayList<Integer> listaCombinada = new ArrayList<>();
        Ej7j l = new Ej7j();
        listaCombinada = l.combinarOrdenado(lista1, lista2);
        for (Integer i: listaCombinada){
            System.out.println(i);
        }
    }
}
