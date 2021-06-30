package InterfazGrafica;

import ManejoDeArchivos.Lector;

import javax.swing.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;

import static InterfazGrafica.VentanaTablero.TITLE;
import static ManejoDeArchivos.Escritor.PATH;

public class VentanaEligirJugadores extends JFrame implements Ventana {

    private JPanel ventanaElegirPanel;
    private JPanel escogerPanel;
    private JButton continuarButton;

    public VentanaEligirJugadores(){
        escogerPanel.setLayout(new GridLayout());
        revisarJugadores();
        fixComponents(this,ventanaElegirPanel);
    }

    public void revisarJugadores(){
        File[] jugadores = new Lector(PATH).recopilarArchivosEnDirectorio(PATH);
        ButtonGroup jug = new ButtonGroup();
        for (int k = 0;k < jugadores.length;k++){
            JCheckBox jugador = new JCheckBox(jugadores[k].getName());
            escogerPanel.add(jugador);
            jug.add(jugador);
        }
    }

    @Override
    public void fixComponents(JFrame frame, JPanel panel) {
        frame.add(panel);
        frame.setTitle(TITLE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
