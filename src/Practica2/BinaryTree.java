package Practica2;


import Practica1.Ej8.Queue;

public class BinaryTree <T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return this.leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() {
		if (isEmpty()){
			return 0;
		}
		else if (isLeaf()){
			return 1;
		}
		else {
			int hojas = 0;
			if (hasLeftChild()){
                hojas += this.getLeftChild().contarHojas();
            }
			if (hasRightChild()){
				hojas += this.getRightChild().contarHojas();
			}
			return hojas;
		}
	}

    public BinaryTree<T> espejo(){
		if (this.isEmpty()){
			return null;
		}
		else {
			BinaryTree<T> abEspejo = new BinaryTree<>(this.getData());
			if (hasLeftChild()){
				abEspejo.addRightChild(this.getLeftChild().espejo());
			}
			if (hasRightChild()){
				abEspejo.addLeftChild(this.getRightChild().espejo());
			}
			return abEspejo;
		}
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		BinaryTree<T> aux;
		Queue<BinaryTree<T>> cola = new Queue<>();
		cola.enQueue(this);
		cola.enQueue(null);
		int nivel = 0;
		while (!cola.isEmpty() && nivel <= m){
			aux = cola.deQueue();
			if (aux != null){
				if (nivel >= n && nivel <= m){
					System.out.println(aux.getData());
				}
				if (hasLeftChild()){
					cola.enQueue(aux.getLeftChild());
				}
				if (hasRightChild()) {
					cola.enQueue(aux.getRightChild());
				}
			}
			else {
				if (!cola.isEmpty()) {
					cola.enQueue(null);
					nivel++;
				}
			}
		}

   	}
		
}

