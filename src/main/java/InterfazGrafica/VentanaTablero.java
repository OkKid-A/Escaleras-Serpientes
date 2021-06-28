package InterfazGrafica;

import Componentes.VistaTablero;
import Tablero.Tablero;

import javax.swing.*;

public class VentanaTablero extends JFrame implements Ventana{

    public static final String TITLE = "Serpientes & Escaleras";
    private JPanel tablerolVentanaPanel;
    private JPanel tableroPanel;
    private Tablero tablero;

    public VentanaTablero(){
        tablero = new Tablero(10,10);
        fixComponents(this,tablerolVentanaPanel);
        tableroPanel = new VistaTablero("ruta",tablero);
        fixComponents(this,tableroPanel);
        tableroPanel.repaint();
    }

    @Override
    public void fixComponents(JFrame frame, JComponent component) {
        frame.setContentPane(component);
        frame.setTitle(TITLE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        tableroPanel = new VistaTablero("ruta",new Tablero(5,5));
    }
}
