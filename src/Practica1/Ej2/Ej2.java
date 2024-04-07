package Practica1.Ej2;

import java.util.Scanner;

public class Ej2 {
    public static void devolverVector(int n){
        int vec[] = new int[n];
        int multiplo = 1;
        for (int i = 0; i<n; i++){
            vec[i] = n*multiplo;
            multiplo++;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("|" + vec[i]);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        devolverVector(s.nextInt());
    }
}
