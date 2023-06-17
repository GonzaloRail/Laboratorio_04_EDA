import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import com.panayotis.gnuplot.JavaPlot;

public class peorcasoGrafico {

    public static void main(String[] args) throws IOException {
        int tamano;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el tamaño máximo del último arreglo: ");
        tamano = teclado.nextInt();

        List<int[]> lista = new List<int[]>();
        String archivoInsercion = "insercion.txt";
        PrintWriter oS = new PrintWriter(archivoInsercion);

        for (int n = 1; n <= tamano; n++) {
            lista.insert(generarPeorCaso(n));
        }
        for (int i = 0; i < lista.length(); i++) {
            oS.println(String.valueOf(insertionSort(lista.get(i).getData())));
        }
        oS.close();

        //ES MUY IMPORTANTE aclarar que la direccion del archivo cambiará según el equipo en que se trabaje

        JavaPlot p = new JavaPlot();
        p.addPlot("\"C:/Users/MAURICIO/Documents/NetBeansProjects/Eda_D_Lab04/insercion.txt\" with lines");
        p.plot();
    }

    public static int[] generarPeorCaso(int t) {

        int[] lista = new int[t];
        for (int i = 0; i < t; i++) {
            lista[i] = t - i;
        }
        return lista;

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
