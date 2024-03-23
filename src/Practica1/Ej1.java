package Practica1;

public class Ej1 {
    public static void imprimirNumerosA (int n1, int n2){
        for (int i = n1; i<=n2; i++) {
            System.out.println(i);
        }
    }

    public static void imprimirNumerosB (int n1, int n2){
        while (n1 <= n2){
            System.out.println(n1);
            n1++;
        }
    }

    public static void imprimirNumerosC (int n1, int n2){
        if (n1 <= n2) {
            System.out.println(n1);
            imprimirNumerosC(n1 + 1, n2);
        }
    }

    public static void main(String[] args){
        int num1 = 60;
        int num2 = 70;
        System.out.println("Metodo 1");
        imprimirNumerosA(num1, num2);
        System.out.println();
        System.out.println("Metodo 2");
        imprimirNumerosB(num1, num2);
        System.out.println();
        System.out.println("Metodo 3");
        imprimirNumerosC(num1, num2);
    }

}
