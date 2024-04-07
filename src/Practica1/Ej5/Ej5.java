package Practica1.Ej5;

public class Ej5 {
    private int min = 9999;
    private int max = -1;
    private double prom = 0;

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setProm(double prom) {
        this.prom = prom;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public double getProm() {
        return prom;
    }

    public static float[] metodo1(int[] vector){
        float[] vres;
        int max = -1;
        int min = 9999;
        float prom = 0; int suma = 0;
        for (int elto: vector) {
            if (elto > max){
                max = elto;
            }
            if (elto < min){
                min = elto;
            }
            suma = suma + elto;
        }
        prom = (float) suma/ vector.length;
        vres = new float[] {min, max, prom};
        return vres;
    }

    public static void metodo2(Ej5 e, int n){
        if (n > e.getMax()){
            e.setMax(n);
        }
        if (n < e.getMin()){
            e.setMin(n);
        }

    }

    public static void metodo3(){

    }

    public static void main(String[] args) {
        int[] v = {5, 60, 20, 13};
        System.out.println("Metodo 1: Return");
        System.out.println();
        System.out.print("Minimo: ");
        System.out.println(metodo1(v)[0]);
        System.out.print("Maximo: ");
        System.out.println(metodo1(v)[1]);
        System.out.print("Promedio: ");
        System.out.println(metodo1(v)[2]);
        System.out.println();
        System.out.println("Metodo 2: Parametros");
        Ej5 e = new Ej5();
        int suma = 0;
        for (int i = 0; i < v.length; i++) {
            int n = v[i];
            metodo2(e, n);
        }

    }
}
