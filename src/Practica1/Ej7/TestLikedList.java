package Practica1.Ej7;

import java.util.*;

public class TestLikedList {
    public static void main(String[] args) {
        LinkedList<Integer> listaLinked = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        int num;

        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese un numero");
            num = s.nextInt();
            listaLinked.add(num);
        }

        System.out.println("Lista");
        for (int i = 0; i < 3; i++) {
            System.out.print(listaLinked.get(i) + " | ");
        }
    }
}
