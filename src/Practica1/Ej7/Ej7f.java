package Practica1.Ej7;

import java.util.ArrayList;

public class Ej7f {

    public boolean esCapicua(ArrayList<Integer> list){
        ArrayList<Integer> list2 = new ArrayList<>(list);
        invertirLista(list2);
        int contador = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(list2.get(i))){
                contador++;
            }
        }
        return contador == list.size();
    }

    public void invertirLista(ArrayList<Integer> list){
        if (list.isEmpty()){
            return;
        }

        int num = list.getFirst();
        list.removeFirst();
        invertirLista(list);
        list.add(num);
    }



    public static void main(String[] args) {
        ArrayList<Integer> listNumeros = new ArrayList<>();
        listNumeros.add(10);
        listNumeros.add(5);
        listNumeros.add(10);
        Ej7f e = new Ej7f();
        System.out.println(e.esCapicua(listNumeros));
    };
}
