package Practica3.Ej9a11;

import java.util.ArrayList;
import java.util.List;

public class valorYLista {
    private int valor;
    private List<Integer> lista;

    public valorYLista(){
        this.valor = 0;
        this.lista = new ArrayList<>();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<Integer> getLista() {
        return lista;
    }

    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }
}
