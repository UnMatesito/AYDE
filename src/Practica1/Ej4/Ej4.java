package Practica1.Ej4;

public class Ej4 {
    public static void swap1 (int x, int y) { //Pasaje de parametros por valor
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }

    public static void swap2 (Integer x, Integer y) { //Pasaje de wrappers, se entan modificando las referencias no los valores
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        Integer c = 3, d = 4;
        swap1(a,b);
        swap2(c,d);
        System.out.println("a=" + a + " b=" + b) ;
        System.out.println("c=" + c + " d=" + d) ;
    }
}
