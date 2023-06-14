import java.util.Arrays;

public class DoubleLindkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int len;

    public DoubleLindkedList() {
        this.head = null;
        this.tail = null;
        this.len = 0;
    }

    // Agregar al principio de la lista
    public void addFirst(E data) {
        Node<E> new = new Node<>(data, this.head, null);

        if (this.isEmpty()) {
            this.tail = new;
        } else {
            this.head.setPreviousNode(new);
        }
        
        this.head = new;
        this.len++;
    }

    // Agregar al final de la lista
    public void addLast(E data) {
        Node<E> new = new Node<>(data);

        if (this.isEmpty()) {
            this.head = new;
        } else {
            new.setPreviousNode(this.tail);
            this.tail.setNextNode(new);
        }

        this.tail = new;
        this.len++;
    }

    // Eliminar el primer elemento de la lista
    public void delFirst() {
        if (this.isEmpty()) {
            return;
        }
        //Si sólo hay un Nodo
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head.getNextNode().setPreviousNode(null);
        }

        this.len--;
    }

    // Eliminar el último elemento de la lista
    public void delLast() {
        if (this.isEmpty()) {
            return;
        }

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            tail.getPreviousNode().setNextNode(null);
        }

        this.len--;
    }

    // Verificar si la lista está vacía
    public boolean isEmpty() {
        return this.head == null;
    }



    

