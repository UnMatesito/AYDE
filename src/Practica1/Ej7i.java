package Practica1;

import java.util.LinkedList;

public class Ej7i {
    public int sumarLinkedList(LinkedList<Integer> lista, int i){
        int suma = 0;
        if (i == lista.size()-1){
            return suma + lista.get(i);
        }
        else {
            suma = lista.get(i) + sumarLinkedList(lista, i+1);
        }
        return suma;
    }


    public static void main(String[] args) {
        LinkedList<Integer> listaNumeros = new LinkedList<>();
        listaNumeros.add(10);
        listaNumeros.add(20);
        listaNumeros.add(70);
        Ej7i e = new Ej7i();
        int i = 0;
        int res = e.sumarLinkedList(listaNumeros, i);
        System.out.println("Suma de los elementos del la lista: " + res);
    }
}
