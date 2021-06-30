package Start;

import InterfazGrafica.VentanaMenuPrincipal;
import InterfazGrafica.VentanaTablero;

import javax.swing.*;

public class Start {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaMenuPrincipal menu = new VentanaMenuPrincipal();
            }
        });
    }
}
