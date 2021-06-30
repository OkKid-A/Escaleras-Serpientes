package InterfazGrafica;

import Jugadores.Jugador;
import ManejoDeArchivos.Escritor;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static InterfazGrafica.VentanaTablero.TITLE;

public class VentanaNuevoJugador extends JFrame implements Ventana{
    private JPanel ventanaJugadorPanel;
    private JTextField nombreField;
    private JButton confirmarButton;
    
    public VentanaNuevoJugador(){
        fixComponents(this,ventanaJugadorPanel);
        setConfirmarListener();
    }
    
    public void setConfirmarListener(){
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Escritor escritor = new Escritor("");
                escritor.redactarArchivo(new Jugador(nombreField.getText()),"","jug",nombreField.getText());
                dispose();
            }
        });
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
