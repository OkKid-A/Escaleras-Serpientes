package InterfazGrafica;

import Componentes.VistaTablero;
import Tablero.*;

import javax.swing.*;
import java.awt.*;

public class VentanaTablero extends JFrame implements Ventana {

    public static final String TITLE = "Serpientes & Escaleras";
    private JPanel tablerolVentanaPanel;
    private JPanel tableroPanel;
    private JButton dadoButton;
    private JPanel dadoPanel;
    private JLabel mm;
    private Tablero tablero= new Tablero(10,10);

    public VentanaTablero() {

        this.add(tableroPanel);
        this.pack();
        tableroPanel.repaint();
        dadoPanel.setLayout(new GridLayout());
        dadoPanel.add(new Dado());
        fixComponents(this,tablerolVentanaPanel);
        tableroPanel.setBounds(50,52,50,50);
        tablerolVentanaPanel.repaint();
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
        tablero = new Tablero(10,10);
        tableroPanel = new VistaTablero("ruta", tablero);
    }
}
