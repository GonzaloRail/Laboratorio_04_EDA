public class Node<T> {
	private T datos;
	private Node<T> nextNode;
	
	public Node(T datos, Node<T> nextNode) {
		this.datos = datos;
		this.nextNode = nextNode;
	}
	public Node(T datos) {
		this(datos, null);
	}
	public T getData() {
		return this.datos;
	}
	public void setData(T datos) {
		this.datos = datos;
	}
	public Node<T> getNext() {
		return this.nextNode;
	}
	public void setNext(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	public String toString() {
		return this.datos.toString();
	}
}
