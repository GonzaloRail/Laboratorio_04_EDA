import java.util.Scanner;

public class Ejercicio02 {
    
    // Método para generar el peor caso de un arreglo
    public static int[] generarPeorCaso(int t) {
        int[] lista = new int[t];
        for (int i = 0; i < t; i++) {
            lista[i] = t - i;
        }
        return lista;
    }
    
    // Método de ordenamiento insertion sort
    public static long insertionSort(int[] A) {
        int key;
        int i;
        long nano_startTime = System.nanoTime();
        for (int j = 1; j < A.length; j = j + 1) {
            key = A[j];
            // Insertar A[j] en la secuencia ordenada A[1..j-1]
            i = j - 1;
            while (i > -1 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
            // imprimirArreglo(A);
        }
        long nano_endTime = System.nanoTime();
        return nano_endTime - nano_startTime;
    }
    
    // Método para imprimir un arreglo
    public static void imprimirArreglo(int[] lista) {
        System.out.println();
        for (int x = 0; x < lista.length; x++) {
            System.out.print(lista[x] + " ");
        }
    }
    
    // Método principal
    public static void main(String[] args) {
        int tamano;
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el tamaño máximo del arreglo: ");
        tamano = teclado.nextInt();
        
        DoubleLindkedList<int[]> prueba = new DoubleLindkedList<>();
        
        for (int n = 1; n <= tamano; n++) {
            prueba.addLast(generarPeorCaso(n));
        }
        
        for (int n = 0; n < prueba.length(); n++) {
            System.out.println(insertionSort(prueba.get(n)));
        }
    }
}
