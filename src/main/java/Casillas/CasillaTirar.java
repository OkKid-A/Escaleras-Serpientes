package Casillas;

import javax.swing.*;
import java.awt.*;

public class CasillaTirar extends Casilla{

    public static final Color PURPLE = new Color(191,64,191);
    public CasillaTirar(Color color) {
        super(color);
    }

    @Override
    public void formarCasilla(){
        super.setOpaque(true);
        super.setMinimumSize(new Dimension(50,50));
        super.setPreferredSize(new Dimension(50,50));
        super.setBackground(super.getColor());
        super.setBorder(null);
        super.setToolTipText("Vuelves a Tirar Los Dados");
        //super.setText("Ganas 1\nTurno");

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D antiAlias = (Graphics2D)g;
        antiAlias.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.BLUE);
        g.fillOval(12,12,30,30);
    }
}
