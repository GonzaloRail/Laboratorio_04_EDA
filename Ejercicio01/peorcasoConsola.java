import java.util.Scanner;
import java.text.DecimalFormat;

public class peorcasoConsola {
    public static void main(String[] args) {
        
        DecimalFormat df = new DecimalFormat("0.000000");

        int tamano;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el tamaño máximo del último arreglo: ");
        tamano = teclado.nextInt();

        List<int[]> lista = new List<int[]>();

        for (int n = 1; n <= tamano; n++) {
            lista.insert(generarPeorCaso(n));
        }
        
        long nano_startTime = System.nanoTime();
        
        for (int i = 0; i < lista.length(); i++) {
            insertionSort(lista.get(i).getData());
            imprimirArreglo(lista.get(i).getData());
        }
        
        long nano_endTime = System.nanoTime();
        System.out.println("\n\nTiempo de ejecucion: " + (df.format((double)(nano_endTime - nano_startTime)/60000000000.0)) + " minutos.");
    }

    public static int[] generarPeorCaso(int t) {

        int[] lista = new int[t];
        for (int i = 0; i < t; i++) {
            lista[i] = t - i;
        }
        return lista;

    }

    public static void imprimirArreglo(int[] lista) {
        System.out.println("");
        for (int x = 0; x < lista.length; x++) {
            System.out.print(lista[x] + " ");
        }
    }

    public static long insertionSort(int[] A) {
        int key;
        int i;
        long nano_startTime = System.nanoTime();
        for (int j = 1; j < A.length; j = j + 1) {
            key = A[j];
            i = j - 1;
            while (i > -1 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
        long nano_endTime = System.nanoTime();
        return nano_endTime - nano_startTime;
    }
}
