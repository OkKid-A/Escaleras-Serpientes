package ManejoDeArchivos;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Lector {

    private Reader lector;
    private BufferedReader lectorBuffer;
    private String rutaDeDirectorio;

    public Lector(String ruta) {
        rutaDeDirectorio = ruta;
    }

    public ArrayList<String> leerDocumentoPorLineas(String direccionArchivo) {
        ArrayList<String> objetosLeidos = new ArrayList<>();
        try {
            objetosLeidos = (ArrayList<String>) Files.readAllLines(Paths.get(direccionArchivo), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objetosLeidos;
    }

    public File[] recopilarArchivosEnDirectorio(String rutaDeDirectorio) {
        File folder = new File(rutaDeDirectorio);
        File[] archivosEnFolder = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        });
        return archivosEnFolder;
    }
}
