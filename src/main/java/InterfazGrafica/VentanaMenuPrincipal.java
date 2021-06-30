package InterfazGrafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static InterfazGrafica.VentanaTablero.TITLE;

public class VentanaMenuPrincipal extends JFrame implements Ventana{
    private JPanel ventanaMenuPanel;
    private JButton nuevaPartidaButton;
    private JButton nuevoJugadorButton;
    private JButton reportesButton;
    private JButton salirButton;

    public VentanaMenuPrincipal() {
        fixComponents(this,ventanaMenuPanel);
        setNuevaPartidaListener();
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

    public void setNuevaPartidaListener(){
        nuevaPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showSaveDialog(null);
                try {
                    VentanaTablero tablero = new VentanaTablero(chooser.getSelectedFile().getCanonicalPath());
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                dispose();
            }
        });;
    }
}
