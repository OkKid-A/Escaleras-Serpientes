package Casillas;

import javax.swing.*;
import java.awt.*;

public class CasillaAvanza extends Casilla{

    private int avance;

    public CasillaAvanza(Color color, int avance) {
        super(color);
        this.avance = avance;
    }

    @Override
    public void formarCasilla(){
        JLabel forma = new JLabel();
        super.setForma(forma);
        super.getForma().setPreferredSize(new Dimension(5,5));
        super.getForma().setBackground(super.getColor());
        super.getForma().setBorder(null);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.fillRect(0,0,3,3);
    }
}
