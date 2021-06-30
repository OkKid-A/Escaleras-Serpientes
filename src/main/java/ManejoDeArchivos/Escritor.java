package ManejoDeArchivos;

import Tablero.Ficha;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Escritor {

    public static final String SEPARADOR = System.getProperty("file.separator");
    public static final String PATH = Escritor.class.getProtectionDomain().getCodeSource().getLocation().getPath() + SEPARADOR+"New";
    private String rutaDeDirectorio;

    public Escritor(String rutaDeDirectorio) {
        this.rutaDeDirectorio = rutaDeDirectorio;
    }

    public <T> void redactarArchivo(T t, String directorio, String tipoArchivo, String nombreArchivo) {
        try {
            File archivo = new File(PATH + System.getProperty("file.separator") + directorio + System.getProperty("file.separator") + nombreArchivo + "." + tipoArchivo + System.getProperty("file.separator"));
            FileOutputStream escritor = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(escritor);
            oos.writeObject(t);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarRecords(ArrayList<Ficha> fichas){
        for (int k = 0;k < fichas.size();k++){
            redactarArchivo(fichas.get(k),"","jug",fichas.get(k).getJugador().getNombre());
        }
    }

}
