package Practica1.Ej8;

public class CircularQueue<T> extends Queue<T> {

    public T shift(){
        T aux = null;
        if (!super.isEmpty()){
            aux = super.deQueue();
            enQueue(aux);
        }
        return aux;
    }
}
