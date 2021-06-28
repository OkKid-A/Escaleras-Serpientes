package Casillas;

import javax.swing.*;
import java.awt.*;

public class CasillaTirar extends Casilla{

    public CasillaTirar(Color color) {
        super(color);
    }

    @Override
    public void formarCasilla(){
        super.setOpaque(true);
        super.setPreferredSize(new Dimension(50,50));
        super.setBackground(super.getColor());
        super.setBorder(null);
        super.setToolTipText("Vuelves a Tirar Los Dados");
        //super.setText("Ganas 1\nTurno");

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(12,12,30,30);
    }
}
