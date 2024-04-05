package Practica1;

import javax.sound.midi.Sequence;
import java.util.*;

public class Queue<T> {
    protected List<T> data;

    public Queue(){
        this.data = new ArrayList<T>();
    }

    public void enQueue(T dato){
        data.add(dato);
    }

    public T deQueue(){
        return data.remove(0);
    }

    public T head(){
        return data.getFirst();
    }

    public boolean isEmpty(){
        return data.size() == 0;
    }

    public int size(){
        return data.size();
    }

    @Override
    public String toString(){
        String aux = "[ ";
        for (T d: data){
            aux = aux + d + " , ";
        }
        aux += " ]";
        return aux;
    }

}
