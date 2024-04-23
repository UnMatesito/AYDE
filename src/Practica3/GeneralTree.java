package Practica3;

import Practica1.Ej8.Queue;

import java.util.ArrayList;
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

	private int actMaximo(int ancho, Integer max){
		if (ancho > max){
			max = ancho;
		}
		return max;
	}

	public int ancho(){
		int max = 0;
		Queue<GeneralTree<T>> cola = new Queue<>();
		GeneralTree<T> aux;
		cola.enQueue(this);
		cola.enQueue(null);
		int anch = 0;
		while (!cola.isEmpty()){
			aux = cola.deQueue();
			if (aux != null) {
				anch++;
				List<GeneralTree<T>> children = aux.getChildren();
				for (GeneralTree<T> c: children){
					cola.enQueue(c);
				}
			}
			else {
				if (!cola.isEmpty()){
					cola.enQueue(null);
					max = actMaximo(anch, max);
					anch = 0;
				}
			}
		}
		return max;
	}

	private boolean buscarB(GeneralTree<T> arbol, T b){
		boolean encontrado = false;
		if (arbol.getData() == b){
			return true;
		}
		else {
			List<GeneralTree<T>> children = arbol.getChildren();
			for (GeneralTree<T> c: children){
				encontrado = buscarB(c, b);
			}
		}
		return encontrado;
	}

	private boolean esAncestroHelper(GeneralTree<T> arbol, T a ,T b){
		boolean ancestro = false;
		if (arbol.getData() == a){
			List<GeneralTree<T>> children = arbol.getChildren();
			for (GeneralTree<T> c: children){
				ancestro = buscarB(c, b);
			}
		}
		else {
			List<GeneralTree<T>> children = arbol.getChildren();
			for (GeneralTree<T> c: children){
				esAncestroHelper(c, a, b);
			}
		}
		return ancestro;
	}

	public boolean esAncestro(T a, T b){
		if (a == b){
			return true;
		}
		else {
			return esAncestroHelper(this, a , b);
		}
	}

}