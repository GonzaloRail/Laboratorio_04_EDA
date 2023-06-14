import java.util.*;

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
        Node<E> aux = new Node<>(data, this.head, null);

        if (this.isEmpty()) {
            this.tail = aux;
        } else {
            this.head.setPreviousNode(aux);
        }
        
        this.head = aux;
        this.len++;
    }

    // Agregar al final de la lista
    public void addLast(E data) {
        Node<E> aux = new Node<>(data);

        if (this.isEmpty()) {
            this.head = aux;
        } else {
            aux.setPreviousNode(this.tail);
            this.tail.setNextNode(aux);
        }

        this.tail = aux;
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

    //Tamaño
    public int length(){
        return this.len;
    }

    // Verificar si la lista está vacía
    public boolean isEmpty() {
        return this.head == null;
    }

    public String toString(){
        String str = "";
        for(Node<E> aux = this.head; aux != null; aux = aux.getNextNode()){
            str += aux.toString() + " ";
        }
        return str;
    }

    public E get(int i) {
        Node<E> currentNode = this.head;
        int currentIndex = 0;
        while (currentNode != null && currentIndex < i) {
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        if (currentNode != null) {
            return currentNode.getData();
        }
        return null;
    }
}



    

