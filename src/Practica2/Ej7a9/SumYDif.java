package Practica2.Ej7a9;

public class SumYDif {
    private int sum;
    private int dif;

    public SumYDif(int sum, int dif) {
        this.sum = sum;
        this.dif = dif;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }

    @Override
    public String toString(){
        String aux;
        aux = "Suma: "+ getSum() + " Dif: " + getDif();
        return aux;
    }
}
