
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DistanciaCadenas{

    public static int calcDistancia(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= n; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insertar = dp[i][j - 1] + 1;    //costo de insertar es 1
                    int eliminar = dp[i - 1][j] + 1;
                    int reemplazar = dp[i - 1][j - 1] + 2;  //costo de reemplazo es 2

                    dp[i][j] = Math.min(insertar, Math.min(eliminar, reemplazar));
                }
            }
        }
        return dp[m][n];
    }

    public static int getNumCaracteres(String s){
        return s.length();
    }

    public static String leerArchivo(String rutaArchivo) throws IOException {
        return new String(Files.readAllBytes(Paths.get(rutaArchivo))).trim();
    }

    public static void main(String[] args) {
        try {
            // longitud 5
            String s1 = leerArchivo("cadena1-5.txt");
            String s2 = leerArchivo("cadena2-5.txt");

            System.out.println("Cadena 1 - 5: " + s1);
            System.out.println("Cadena 2 - 5: " + s2);

            System.out.println("Numero de caracteres cadena 1 - longitud 5:" + getNumCaracteres(s1));
            System.out.println("Numero de caracteres cadena 2 - longitud 5:" + getNumCaracteres(s2));

            //medimos tiempo de ejecucion
            long inicio = System.nanoTime();

            int distancia = calcDistancia(s1, s2);

            long fin = System.nanoTime();

            long duracion = fin - inicio; // en nanosegundos

            System.out.println("\nLa distancia entre las cadenas es: " + distancia);
            System.out.println("\nTiempo de ejecucion (nanosegundos): " + duracion);

            //longitud 50
            String s3 = leerArchivo("cadena1-50.txt");
            String s4 = leerArchivo("cadena2-50.txt");

            System.out.println("Cadena 1 - 50: " + s3);
            System.out.println("Cadena 2 - 50: " + s4);

            System.out.println("Numero de caracteres cadena 1 - longitud 50:" + getNumCaracteres(s3));
            System.out.println("Numero de caracteres cadena 2 - longitud 50:" + getNumCaracteres(s4));

            //medimos tiempo de ejecucion
            long inicio2 = System.nanoTime();

            int distancia2 = calcDistancia(s3, s4);

            long fin2 = System.nanoTime();

            long duracion2 = fin2 - inicio2; // en nanosegundos

            System.out.println("\nLa distancia entre las cadenas es: " + distancia2);
            System.out.println("\nTiempo de ejecucion (nanosegundos): " + duracion2);

            //longitud 500

            String s5 = leerArchivo("cadena1-500.txt");
            String s6 = leerArchivo("cadena2-500.txt");

            System.out.println("Cadena 1 - 500: " + s5);
            System.out.println("Cadena 2 - 500: " + s6);

            System.out.println("Numero de caracteres cadena 1 - longitud 500:" + getNumCaracteres(s5));
            System.out.println("Numero de caracteres cadena 2 - longitud 500:" + getNumCaracteres(s6));

            //medimos tiempo de ejecucion
            long inicio3 = System.nanoTime();

            int distancia3 = calcDistancia(s5, s6);

            long fin3 = System.nanoTime();

            long duracion3 = fin3 - inicio3; // en nanosegundos

            System.out.println("\nLa distancia entre las cadenas es: " + distancia3);
            System.out.println("\nTiempo de ejecucion (nanosegundos): " + duracion3);

            //longitud 5000
            String s7 = leerArchivo("cadena1-5000.txt");
            String s8 = leerArchivo("cadena2-5000.txt");

            System.out.println("Cadena 1 - 5000: " + s7);
            System.out.println("Cadena 2 - 5000: " + s8);

            System.out.println("Numero de caracteres cadena 1 - longitud 5000:" + getNumCaracteres(s7));
            System.out.println("Numero de caracteres cadena 2 - longitud 5000:" + getNumCaracteres(s8));

            //medimos tiempo de ejecucion
            long inicio4 = System.nanoTime();

            int distancia4 = calcDistancia(s7, s8);

            long fin4 = System.nanoTime();

            long duracion4 = fin4 - inicio4; // en nanosegundos

            System.out.println("\nLa distancia entre las cadenas es: " + distancia4);
            System.out.println("\nTiempo de ejecucion (nanosegundos): " + duracion4);


        } catch (IOException e) {
            System.err.println("Error al leer los archivos: " + e.getMessage());
        }
    }
}