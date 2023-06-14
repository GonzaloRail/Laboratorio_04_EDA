public class Ejercicio02 {
    public static void main(String[] args) {
        int[] peorCaso = generarPeorCaso(5);

        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();

        //Agregamos los peores casos
        for (int num : peorCaso) {
            lista.add(num);
        }

        System.out.println("Lista antes de ordenar:");
        imprimir(lista);

        insertionSort(lista);

        System.out.println("Lista después de ordenar:");
        imprimir(lista);
    }

    public static void insertionSort(DoubleLinkedList<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("El arreglo está vacío");
            return;
        }

        DoubleLinkedList<Integer> current = lista.head.getNextNode();

        while (current != null) {
            int key = current.getData();
            DoubleLinkedList<Integer> previous = current.getPreviousNode();

            while (previous != null && previous.getData() > key) {
                previous.getNextNode().setData(previous.getData());
                previous = previous.getPreviousNode();
            }

            if (previous == null) {
                lista.head.setData(key);
            } else {
                previous.getNextNode().setData(key);
            }

            current = current.getNextNode();
        }
    }

    public static int[] generarPeorCaso(int t) {
        int[] lista = new int[t];
        for (int i = 0; i < t; i++) {
            lista[i] = t - i;
        }
        return lista;
    }

    public static void imprimir(DoubleLinkedList<Integer> lista) {
        DoubleLinkedList<Integer> current = lista.head;

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNextNode();
        }

        System.out.println();
    }
}