public class List<E>{
	private Node<E> head;
	private int count;
	
	public List() {
		this.head = null;
		this.count = 0;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int lenght() {
		return this.count;
	}
	
	public void insertFirst(E x) {
		this.head = new Node<E>(x, this.head);
		this.count ++;
	}
	
	public void insertLast(E x) {
		if (isEmpty())
			insertFirst(x);
		else {
			Node<E> aux = this.head;
			while ( aux.getNext() != null)
				aux = aux.getNext();
			aux.setNext(new Node<E>(x));
			this.count ++;
		}
	}
	
	public boolean search(E x) { 
		Node<E> aux = this.head;
		for(; aux != null && !aux.getData().equals(x); aux = aux.getNext());
		return aux != null;
	}
	
	public void remove(E x) {
		if (!isEmpty()) {
			if (this.head.getData().equals(x)) {
				this.head = this.head.getNext();
				this.count --;
			}
			else {
				Node<E> aux = this.head;
				while(aux.getNext() !=  null && !aux.getNext().getData().equals(x))
					aux = aux.getNext();
				if (aux.getNext() != null) {
					aux.setNext(aux.getNext().getNext());
					this.count --;
				}
			}
		}
	}
	
	public String toString() {
		  String str = "";
  		for(Node<E> aux = this.head; aux != null; aux = aux.getNext())
		  	str += aux.toString() + ", ";
  		return str;
	}

	public void peoresCasos(int n){
	    for(int i = n; i>= n; i - -) {
	        this.add((T) Integer.valueOf(i));  
	    }
	}
	
	public long insertionSort(){
	     Node <T> aux = raiz;
	     Node <T> aux2 = raiz.getNextNode();
	     long nano_startTime = System.nanoTime();
	     
	     while(aux2 != null ){
	         if(aux.getData().toString().compareTo(aux2.getData().toString())> 0) {
	             T temp = aux.getData();
	             aux.setData(aux2.getData());
	             aux2.setData(temp );
	             aux = raiz;
	             aux2 = raiz.getNextNode();
	        } 
	         else {
	             aux = aux.getNextNode();
	             aux2 = aux2.getNextNode();
	         }
	     }
	
	     long nano_endTime = System.nanoTime();
	     return nano_endTime - nano_startTime;
	}
	
	
}
