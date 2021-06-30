package Casillas;

import Tablero.Core;
import Tablero.Ficha;

import javax.swing.*;
import java.awt.*;

public class CasillaRetrocede extends Casilla {

    private int retroceso;

    public CasillaRetrocede(Color color, int retroceso) {
        super(color);
        this.retroceso = retroceso;
        formarCasilla();
    }

    @Override
    public void formarCasilla() {
        super.removeAll();
        super.setOpaque(true);
        super.setPreferredSize(new Dimension(50, 50));
        super.setBackground(super.getColor());
        super.setBorder(null);
        super.setToolTipText("Retrocedes " + this.retroceso + " casillas");
        JLabel news = new JLabel(this.retroceso + "");
        news.setText(this.retroceso + "");
        news.setPreferredSize(new Dimension(50, 50));
        news.setBounds(25, 12, 25, 25);
        super.add(news, 1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.fillRoundRect(15, 12, 25, 25, 5, 5);
        super.dibujarFichas(g);
    }

    @Override
    public void aplicarCondiciones(Core core, Ficha ficha, JPanel panel, JFrame frame){
        super.aplicarCondiciones(core,ficha,panel, frame);
        JOptionPane.showMessageDialog(panel,"Retrocedes "+retroceso+" casillas QwQ");
        core.moverFicha(0-retroceso,ficha,frame);
    }

    public void setRetroceso(int retroceso) {
        this.retroceso = retroceso;
    }

    public int getRetroceso() {
        return retroceso;
    }
}
