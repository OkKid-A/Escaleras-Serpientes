package Casillas;

import Tablero.Core;
import Tablero.Ficha;

import javax.swing.*;
import java.awt.*;

public class CasillaAvanza extends Casilla{

    private int avance;

    public CasillaAvanza(Color color, int avance) {
        super(color);
        this.avance = avance;
        formarCasilla();
    }

    @Override
    public void formarCasilla(){
        super.removeAll();
        super.setOpaque(true);
        super.setPreferredSize(new Dimension(50, 50));
        super.setBackground(super.getColor());
        super.setBorder(null);
        super.setToolTipText("Retrocedes " + this.avance + " casillas");
        JLabel news = new JLabel(this.avance + "");
        news.setText(this.avance + "");
        news.setPreferredSize(new Dimension(50, 50));
        news.setBounds(25, 12, 25, 25);
        super.add(news, 1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillRoundRect(15, 12, 25, 25, 5, 5);
        super.dibujarFichas(g);
    }

    @Override
    public void aplicarCondiciones(Core core, Ficha ficha) {
        super.aplicarCondiciones(core, ficha);
        core.moverFicha(avance,ficha);
    }
}
