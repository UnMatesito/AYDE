package Practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjSucesion {

    public List<Integer> calcularSucesion (int n){
        List<Integer> lista = new ArrayList<>();
        if (n == 1){
            lista.add(n);
            return lista;
        }
        if (n % 2 == 0){
            lista = calcularSucesion(n/2);
        }
        else {
            lista = calcularSucesion(3*n+1);
        }
        lista.addFirst(n);
        return lista;
    }

    public static void main(String[] args) {
        System.out.println("Ingrese un numero");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        EjSucesion e = new EjSucesion();
        List<Integer> listaSucesion = e.calcularSucesion(num);
        for (int i = 0; i < listaSucesion.size(); i++) {
            System.out.println(listaSucesion.get(i));
        }
    }
}
