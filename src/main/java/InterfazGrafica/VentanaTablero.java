package InterfazGrafica;

import Componentes.VistaTablero;
import Jugadores.Jugador;
import Tablero.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTablero extends JFrame implements Ventana {

    public static final String TITLE = "Serpientes & Escaleras";
    private JPanel tablerolVentanaPanel;
    private JPanel tableroPanel;
    private JButton dadoButton;
    private JPanel dadoPanel;
    private JLabel mm;
    private JButton button1;
    private Tablero tablero;
    private Core core;
    private String ruta;

    public VentanaTablero(String ruta) {
        this.ruta = ruta;
        tableroPanel = new VistaTablero(ruta);
        core = new Core(((VistaTablero)tableroPanel).getTablero(),(Dado) dadoButton);
        this.add(tableroPanel);
        this.pack();
        tableroPanel.repaint();
        dadoButton = new Dado();
        dadoPanel.setLayout(new GridLayout());
        dadoPanel.add(dadoButton);
        fixComponents(this,tablerolVentanaPanel);
        tablerolVentanaPanel.repaint();
        setDadoListener();
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

    public void setDadoListener(){
        dadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                core.ejecutarTurno(((Dado)dadoButton).tirar(),tableroPanel);
                tableroPanel.repaint();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
