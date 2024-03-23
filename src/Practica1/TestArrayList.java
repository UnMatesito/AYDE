package Practica1;

import java.util.*;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> ListaArray = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int num;
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese un numero");
            num = s.nextInt();
            ListaArray.add(i, num);
        }

        //Bucle Clasico
        System.out.println("Array");
        for (int i = 0; i < 3; i++) {
            System.out.print(ListaArray.get(i) + " | ");
        }
        System.out.println();

        //Bucle For-Each
        for (Integer i:ListaArray){
            System.out.print(i + " | ");
        }
        System.out.println();

        //Bucle con iterador
        Iterator<Integer> it = ListaArray.iterator();
        while (it.hasNext()){
            System.out.print(it.next().intValue() + " | ");
        }
    }
}
