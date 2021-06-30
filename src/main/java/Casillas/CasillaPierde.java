package Casillas;

import Tablero.Core;
import Tablero.Ficha;

import javax.swing.*;
import java.awt.*;

public class CasillaPierde extends Casilla{

    public CasillaPierde(Color color) {
        super(color);
    }

    @Override
    public void formarCasilla(){
        super.setOpaque(true);
        super.setPreferredSize(new Dimension(50,50));
        super.setBackground(super.getColor());
        super.setBorder(null);
        super.setToolTipText("Pierdes 1\nTurno");
        /*JLabel news = new JLabel();
        news.setText("Pierdes");
        news.setPreferredSize(new Dimension(50,50));
        news.setBounds(0,0,50,50);
        super.add(news,1);*/
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(12,12,25,25);
        super.dibujarFichas(g);
    }

    @Override
    public void aplicarCondiciones(Core core, Ficha ficha, JPanel panel, JFrame frame) {
        super.aplicarCondiciones(core, ficha, panel, frame);
        JOptionPane.showMessageDialog(panel,"Pierdes el Siguiente Turno TwT.");
        ficha.setPierdeTurno(true);
    }
}
