public class List<T> {

    private Node<T> head;
    private int count;

    public List() {
        this.head = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int length() {
        return this.count;
    }

    public void insertFirst(T x) {
        this.head = new Node<T>(x, this.head);
        this.count++;
    }

    public void insertLast(T x) {
        if (isEmpty()) {
            insertFirst(x);
        } else {
            Node<T> aux = this.head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(new Node<T>(x));
            this.count++;
        }
    }

    public boolean search(T x) {
        Node<T> aux = this.head;
        for (; aux != null && !aux.getData().equals(x); aux = aux.getNext());
        return aux != null;
    }

    public Node<T> get(int p) {
        Node<T> aux = this.head;
        for (int i = 0; i < p; i++) {
            aux = aux.getNext();
        }
        return aux;
    }

    public void remove(int p) {
        if (p < count) {
            if (p == 0) {
                this.head = this.head.getNext();
            } 
            else {
                Node<T> anterior = this.get(p - 1);
                anterior.setNext(this.get(p + 1));
            }
            this.count--;
        }
    }

    public String toString() {
        String str = "";
        for (Node<T> aux = this.head; aux != null; aux = aux.getNext()) {
            str += aux + ", ";
        }
        return str;
    }
}
