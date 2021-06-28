package ManejoDeArchivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escritor {

    public static final String SEPARADOR = System.getProperty("file.separator");
    private String rutaDeDirectorio;

    public Escritor(String rutaDeDirectorio) {
        this.rutaDeDirectorio = rutaDeDirectorio;
    }

    public <T> void redactarArchivo(T t, String directorio, String tipoArchivo, String nombreArchivo) {
        try {
            File archivo = new File(rutaDeDirectorio + System.getProperty("file.separator") + directorio + System.getProperty("file.separator") + nombreArchivo + "." + tipoArchivo + System.getProperty("file.separator"));
            FileOutputStream escritor = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(escritor);
            oos.writeObject(t);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
