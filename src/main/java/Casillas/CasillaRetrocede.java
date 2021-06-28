package Casillas;

import javax.swing.*;
import java.awt.*;

public class CasillaRetrocede extends Casilla{

    private int retroceso;

    public CasillaRetrocede(Color color, int retroceso) {
        super(color);
        this.retroceso = retroceso;
    }

    @Override
    public void formarCasilla(){
        JLabel forma = new JLabel();
        super.setForma(forma);
        super.getForma().setPreferredSize(new Dimension(5,5));
        super.getForma().setBackground(super.getColor());
        super.getForma().setBorder(null);
        //super.setText("Retrocedes\n"+retroceso+ "casillas");
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.fillRoundRect(0,0,3,3,1,1);
    }


}
