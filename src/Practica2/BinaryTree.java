package Practica2;



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
		return leftChild;
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

	public  int contarHojas() {
		int hojas = 0;
		if (isEmpty()){
			return 0;
		}
		if (hasRightChild()){
			hojas += this.getRightChild().contarHojas();
		}
		if (hasLeftChild()){
			hojas += this.getLeftChild().contarHojas();
        }
		return hojas;
	}

    public BinaryTree<T> espejo(){
		BinaryTree<T> abEspejo = new BinaryTree<>(this.data);
		if (isEmpty()){
			return null;
		}
		if (this.hasLeftChild()){
			abEspejo.addRightChild(this.getLeftChild());
			return abEspejo.getRightChild();
		}
		if (this.hasRightChild()){
			abEspejo.addLeftChild(this.getRightChild());
			return abEspejo.getLeftChild();
		}
		return abEspejo;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		int i = 0;
   	}
		
}

