import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class GeneradorArchivosTexto {

    // Método que genera un archivo de texto plano UTF-8 del tamaño especificado
    public static void generarArchivo(String nombreArchivo, int tamanioCaracteres) {
        Random random = new Random();
        String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(nombreArchivo, StandardCharsets.UTF_8))) {

            for (int i = 0; i < tamanioCaracteres; i++) {
                char c = letras.charAt(random.nextInt(letras.length()));
                writer.write(c);

                // Agrega saltos de línea de vez en cuando para que parezca texto
                if (i % 80 == 0 && i != 0) {
                    writer.newLine();
                }
            }

            System.out.println("✅ Archivo generado: " + nombreArchivo + " (" + tamanioCaracteres + " caracteres)");

        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    // Genera dos archivos de prueba
    public static void main(String[] args) {
        // Puedes modificar los tamaños aquí (por ejemplo, 5000 caracteres ≈ 5 KB)
        generarArchivo("cadena1-5.txt", 5);
        generarArchivo("cadena2-5.txt", 5);

        generarArchivo("cadena1-50.txt", 50);
        generarArchivo("cadena2-50.txt", 50);


        generarArchivo("cadena1-500.txt", 500);
        generarArchivo("cadena2-500.txt", 500);

        generarArchivo("cadena1-5000.txt", 5000);
        generarArchivo("cadena2-5000.txt", 5000);
    }
}
