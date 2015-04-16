package exercise;

import java.io.*;

/**
 *
 * @author josep
 */
public class Lectura {
    private Logic log;
    
    public Lectura(){
        log = new Logic();
    }
    
    public void read(){
        String file = "";
        
        try{
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream("texto/ejemplo.txt");
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String line;
            // Leer el archivo linea por linea

            while ((line = buffer.readLine()) != null)   {
                // Imprimimos la línea por pantalla
                file += line + "\n";
                //System.out.println (strLinea);

            }
        // Cerramos el archivo
        entrada.close();
        }catch (Exception e){ //Catch de excepciones
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        
        String text = file.replaceAll(" ", "");
        log.tokens(text);

    }
    
        public static void main(String[] args) {
        Lectura lector = new Lectura();
        lector.read();
        
    }
      

    
}
