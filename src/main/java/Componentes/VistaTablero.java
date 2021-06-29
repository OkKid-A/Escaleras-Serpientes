package Componentes;

import Casillas.Casilla;
import ManejoDeArchivos.CargadorTablero;
import Tablero.*;

import javax.swing.*;
import java.awt.*;

public class VistaTablero extends JPanel {

    private Tablero tablero;
    private String ruta;
    private CargadorTablero loader;
    private GridBagConstraints limites;

    public VistaTablero(String ruta, Tablero tablero){
        super();
        this.ruta = ruta;
        this.tablero = tablero;
        initVista();
    }

    public void initVista(){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        limites = new GridBagConstraints();
        dibujarTablero();
    }

    public void dibujarTablero(){
        for (int i = 0; i < 6;i++){
            Ficha anadir = tablero.getFicha(i);
            Casilla resp = (tablero.getCasilla(anadir.getFilas(),anadir.getColumna()));
            resp.agregarFicha(anadir);
        }
        for (int k = 0; k < tablero.getCasillas().length;k++){
            for (int i = 0; i < tablero.getCasillas()[k].length;i++){
                limites.fill = GridBagConstraints.BELOW_BASELINE_TRAILING;
                limites.gridx = i + 5;
                limites.gridy = k;
                limites.ipadx = 5;
                limites.weightx = 100;
                this.add(tablero.getCasillas()[k][i],limites);
            }
        }
    }
}
