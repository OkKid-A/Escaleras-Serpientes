package ManejoDeArchivos;

import Casillas.*;
import Tablero.Tablero;
import java.util.ArrayList;
import static ManejoDeArchivos.TiposCasillasTablero.*;

public class CargadorTablero {

    private Tablero tablero;
    private String rutaDirectorio;
    private Lector lector;
    private ArrayList<String> lineasArchivo;

    public CargadorTablero(String rutaDirectorio){
        this.rutaDirectorio = rutaDirectorio;
        lector = new Lector(rutaDirectorio);
        lineasArchivo = leerArchivoDeTablero();
        formarTablero();
    }

    public ArrayList leerArchivoDeTablero(){
        ArrayList<String> lineasTablero = lector.leerDocumentoPorLineas(rutaDirectorio);
        return lineasTablero;
    }

    public void formarTablero(){
        for (int k = 0;k < lineasArchivo.size();k++){
            generarEspacioTablero(lineasArchivo.get(k));
        }
    }

    public void generarEspacioTablero(String condicion){
        String[] primeraDivision = condicion.split("\\(");
        String[] limpiar = primeraDivision[1].split("\\)");
        String[] segundaDivision = limpiar[0].split(",");
        switch (primeraDivision[0]){
            case TAMANO:
                this.tablero = new Tablero(Integer.valueOf(segundaDivision[0]),Integer.valueOf(segundaDivision[1]));
                break;
            case AVANZAR:
                this.tablero.setCasilla(Integer.valueOf(segundaDivision[0]),Integer.valueOf(segundaDivision[1]),new CasillaAvanza(tablero.getCasilla(Integer.valueOf(segundaDivision[0]),Integer.valueOf(segundaDivision[1])).getColor(),Integer.valueOf(segundaDivision[2])));
                break;
            case RETROCEDE:
                this.tablero.setCasilla(Integer.valueOf(segundaDivision[0]),Integer.valueOf(segundaDivision[1]),new CasillaRetrocede(tablero.getCasilla(Integer.valueOf(segundaDivision[0]),Integer.valueOf(segundaDivision[1])).getColor(),Integer.valueOf(segundaDivision[2])));
                break;
            case PIERDE:
                this.tablero.setCasilla(Integer.valueOf(segundaDivision[0]),Integer.valueOf(segundaDivision[1]),new CasillaPierde(tablero.getCasilla(Integer.valueOf(segundaDivision[0]),Integer.valueOf(segundaDivision[1])).getColor()));
                break;
            case TIRA:
                this.tablero.setCasilla(Integer.valueOf(segundaDivision[0]),Integer.valueOf(segundaDivision[1]),new CasillaTirar(tablero.getCasilla(Integer.valueOf(segundaDivision[0]),Integer.valueOf(segundaDivision[1])).getColor()));
                break;
            default:
                break;
        }
    }

}