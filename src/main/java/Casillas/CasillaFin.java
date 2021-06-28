package Casillas;

import javax.swing.*;
import java.awt.*;

public class CasillaFin extends Casilla{

    public CasillaFin(Color color) {
        super(color);
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
    }
}
