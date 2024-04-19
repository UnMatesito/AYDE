package Practica3;

import Practica1.Ej8.Queue;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{
	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		int alt = 0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enQueue(this);
		cola.enQueue(null);
		while (!cola.isEmpty()){
			aux = cola.deQueue();
			if (aux != null){
				List<GeneralTree<T>> children = aux.getChildren();
				for (GeneralTree<T> c: children){
					cola.enQueue(c);
				}
			}
			else {
				if (!cola.isEmpty()){
					cola.enQueue(null);
					alt++;
				}
			}
		}
		return alt;
	}
	
	public int nivel(T dato){
		int nivel = 0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enQueue(this);
		cola.enQueue(null);
		while (!cola.isEmpty()){
			aux = cola.deQueue();
			if (aux != null){
				if (aux.getData() == dato){
					return nivel;
				}
				List<GeneralTree<T>> children = aux.getChildren();
				for (GeneralTree<T> c: children){
					cola.enQueue(c);
				}
			}
			else {
				if (!cola.isEmpty()){
					cola.enQueue(null);
					nivel++;
				}
			}
		}
		return 0;
	}

	public int ancho(){
		int max = 0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enQueue(this);
		cola.enQueue(null);
		while (!cola.isEmpty()){
			int anch = 0;
			aux = cola.deQueue();
			if (aux != null){
				anch++;
				List<GeneralTree<T>> c = aux.getChildren();
				for (GeneralTree<T> ch: c){
					cola.enQueue(ch);
				}
			}
			else {
				if (!cola.isEmpty()){
					cola.enQueue(null);
				}
			}
		}
		return max;
	}
}