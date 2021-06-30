package InterfazGrafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenuPrincipal implements Ventana{
    private JPanel ventanaMenuPanel;
    private JButton nuevaPartidaButton;
    private JButton nuevoJugadorButton;
    private JButton reportesButton;
    private JButton salirButton;

    public VentanaMenuPrincipal() {

    }

    @Override
    public void fixComponents(JFrame frame, JPanel panel) {

    }

    public void setNuevaPartidaListener(){
        nuevaPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();

            }
        });;
    }
}
