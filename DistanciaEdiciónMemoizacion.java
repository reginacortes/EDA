
/**
 * Calcula la distancia de edición entre dos cadenas de texto. 
 * En esta clase tenemos los métodos de programación dinámica y recursión con memoización.
 * @author melydelgado
 */
public class DistanciaEdiciónMemoizacion {
    static final int delta=1; //Costo de insertar
    static final int alfa=2; //Costo de reemplazar
    /**
     * Calcula la distancia de edición entre A y B usando una tablaa de programación dinámica.
     * @param A
     * @param B
     * @return 
     */
    public static int ProgDin(String A, String B) {
        int m= A.length();
        int n= B.length();
        
        int [][] dp= new int[m+1][n+1];
        
        //Inicializamos las primeras filas y columnas
        for(int i=0; i<=m; i++)
            dp[i][0]= i*delta;
        for(int j=1; j<=n; j++)
            dp[0][j]= j*delta;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++) {
                if(A.charAt(i-1)==B.charAt(j-1)) {
                    dp[i][j]= dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + alfa, Math.min(dp[i - 1][j], dp[i][j - 1]) + delta);
                }
            }
        }
        
        return dp[m][n];
        
    }
    
    /**
     * 
     * @param A
     * @param B
     * @return 
     */
    public static int memoizacion(String A, String B) {
        int m= A.length();
        int n= B.length();
        
        int [][] memo= new int[m+1][n+1];
        
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++)
                memo[i][j]=-1;
        }
        
        return memoRec(A, B, m, n, memo);
    }
    
    private static int memoRec(String A, String B,int i,int j, int[][] memo){
        if(i==0)
            return j*delta;
        if(j==0)
            return i*delta;
        
        if(memo[i][j] != -1)
            return memo[i][j];
        
        if(A.charAt(i-1)==B.charAt(j-1)) {
            memo[i][j]= memoRec(A, B, i-1, j-1, memo);
        }else {
            int insercion, eliminacion, reemplazo;
            
            insercion= memoRec(A, B, i, j-1, memo)+delta;
            eliminacion= memoRec(A,B, i-1, j, memo) + delta;
            reemplazo= memoRec(A, B, i-1, j-1, memo)+alfa;

            memo[i][j] = Math.min(insercion, Math.min(eliminacion, reemplazo));

        }
        return memo[i][j];
    }

    public static int getNumCaracteres(String s){
        return s.length();
    }

    public static String leerArchivo(String rutaArchivo) throws IOException {
        return new String(Files.readAllBytes(Paths.get(rutaArchivo))).trim();
    }
    
    public static void main(String[] args){
        try{
            // longitud 5
            String s1 = leerArchivo("/Users/reginacortes/NetBeansProjects/EDA/cadena1-5.txt");
            String s2 = leerArchivo("/Users/reginacortes/NetBeansProjects/EDA/cadena2-5.txt");

            //System.out.println("Cadena 1 - 5: " + s1);
            //System.out.println("Cadena 2 - 5: " + s2);

            System.out.println("Numero de caracteres cadena 1 - longitud 5:" + getNumCaracteres(s1));
            System.out.println("Numero de caracteres cadena 2 - longitud 5:" + getNumCaracteres(s2));

            //medimos tiempo de ejecucion
            long inicio = System.nanoTime();

            int distancia = memoizacion(s1, s2);

            long fin = System.nanoTime();

            long duracion = fin - inicio; // en nanosegundos

            System.out.println("\nLa distancia entre las cadenas es: " + distancia);
            System.out.println("\nTiempo de ejecucion (nanosegundos): " + duracion);

            //longitud 50
            String s3 = leerArchivo("/Users/reginacortes/NetBeansProjects/EDA/cadena1-50.txt");
            String s4 = leerArchivo("/Users/reginacortes/NetBeansProjects/EDA/cadena2-50.txt");

            //System.out.println("Cadena 1 - 50: " + s3);
            //System.out.println("Cadena 2 - 50: " + s4);

            System.out.println("Numero de caracteres cadena 1 - longitud 50:" + getNumCaracteres(s3));
            System.out.println("Numero de caracteres cadena 2 - longitud 50:" + getNumCaracteres(s4));

            //medimos tiempo de ejecucion
            long inicio2 = System.nanoTime();

            int distancia2 = memoizacion(s3, s4);

            long fin2 = System.nanoTime();

            long duracion2 = fin2 - inicio2; // en nanosegundos

            System.out.println("\nLa distancia entre las cadenas es: " + distancia2);
            System.out.println("\nTiempo de ejecucion (nanosegundos): " + duracion2);

            //longitud 500

            String s5 = leerArchivo("/Users/reginacortes/NetBeansProjects/EDA/cadena1-500.txt");
            String s6 = leerArchivo("/Users/reginacortes/NetBeansProjects/EDA/cadena2-500.txt");

            //System.out.println("Cadena 1 - 500: " + s5);
            //System.out.println("Cadena 2 - 500: " + s6);

            System.out.println("Numero de caracteres cadena 1 - longitud 500:" + getNumCaracteres(s5));
            System.out.println("Numero de caracteres cadena 2 - longitud 500:" + getNumCaracteres(s6));

            //medimos tiempo de ejecucion
            long inicio3 = System.nanoTime();

            int distancia3 = memoizacion(s5, s6);

            long fin3 = System.nanoTime();

            long duracion3 = fin3 - inicio3; // en nanosegundos

            System.out.println("\nLa distancia entre las cadenas es: " + distancia3);
            System.out.println("\nTiempo de ejecucion (nanosegundos): " + duracion3);

            //longitud 5000
            String s7 = leerArchivo("/Users/reginacortes/NetBeansProjects/EDA/cadena1-5000.txt");
            String s8 = leerArchivo("/Users/reginacortes/NetBeansProjects/EDA/cadena2-5000.txt");

            //System.out.println("Cadena 1 - 5000: " + s7);
            //System.out.println("Cadena 2 - 5000: " + s8);

            System.out.println("Numero de caracteres cadena 1 - longitud 5000:" + getNumCaracteres(s7));
            System.out.println("Numero de caracteres cadena 2 - longitud 5000:" + getNumCaracteres(s8));

            //medimos tiempo de ejecucion
            long inicio4 = System.nanoTime();

            int distancia4 = memoizacion(s7, s8);   

            long fin4 = System.nanoTime();

            long duracion4 = fin4 - inicio4; // en nanosegundos

            System.out.println("\nLa distancia entre las cadenas es: " + distancia4);
            System.out.println("\nTiempo de ejecucion (nanosegundos): " + duracion4);


        } catch (IOException e) {
            System.err.println("Error al leer los archivos: " + e.getMessage());

        }
    }
    
    
}
