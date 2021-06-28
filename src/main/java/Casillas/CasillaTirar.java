package Casillas;

import javax.swing.*;
import java.awt.*;

public class CasillaTirar extends Casilla{

    public CasillaTirar(Color color) {
        super(color);
    }

    @Override
    public void formarCasilla(){
        JLabel forma = new JLabel();
        super.setForma(forma);
        super.getForma().setPreferredSize(new Dimension(5,5));
        super.getForma().setBackground(super.getColor());
        super.getForma().setBorder(null);
        //super.setText("Ganas 1\nTurno");

    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.fillOval(0,0,3,3);
        g.setColor(Color.BLUE);
    }
}
