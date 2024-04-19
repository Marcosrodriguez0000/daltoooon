
import java.util.Scanner;
import java.util.Arrays;



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Número de personas en la vineta
        int[] alturas = new int[n];

        // Leer las alturas de cada persona en la vineta
        for (int i = 0; i < n; i++) {
            alturas[i] = scanner.nextInt();
        }

        // Verificar si las alturas están relacionadas
        String resultado = sonDalton(alturas) ? "DALTON" : "DESCONOCIDOS";
        System.out.println(resultado);

        scanner.close();
    }

    // Método para verificar si las alturas están relacionadas
    private static boolean sonDalton(int[] alturas) {
        Arrays.sort(alturas); // Ordenar las alturas

        // Verificar si las alturas son consecutivas
        boolean consecutivas = true;
        for (int i = 1; i < alturas.length; i++) {
            if (alturas[i] != alturas[i - 1] + 1) {
                consecutivas = false;
                break;
            }
        }

        // Verificar si las alturas están en orden ascendente
        boolean ascendente = true;
        for (int i = 1; i < alturas.length; i++) {
            if (alturas[i] <= alturas[i - 1]) {
                ascendente = false;
                break;
            }
        }

        // Verificar si las alturas están en orden descendente
        boolean descendente = true;
        for (int i = 1; i < alturas.length; i++) {
            if (alturas[i] >= alturas[i - 1]) {
                descendente = false;
                break;
            }
        }

        // Si las alturas están relacionadas de alguna manera, retornar true
        return consecutivas || ascendente || descendente;
    }
}
