package Tablero;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Dado extends JButton {

    private Random random;
    private Dimension punto = new Dimension(25,25);
    private int tiro = 5;

    public Dado() {
        super();
        random = new Random();
        this.setMinimumSize(new Dimension(75,75));
        this.setPreferredSize(new Dimension(75,75));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D antiAlias = (Graphics2D) g;
        antiAlias.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillRoundRect(0, 0, 75, 75, 8, 8);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 8, 8);
        int anchoSobrante = punto.height * 2/3;
        int izquierda = getWidth() * 1/3 - punto.width/2 - anchoSobrante * 1/4;
        int centro = getWidth() * 2/3 - punto.width/2 - anchoSobrante * 1/2;
        int derecha = getWidth() * 3/3 - punto.width/2 - anchoSobrante * 3/4;
        int arriba = getHeight() * 1/3 - punto.height/2 - anchoSobrante * 1/4;
        int medio = getHeight() * 2/3 - punto.height/2 - anchoSobrante * 1/2;
        int abajo = getHeight() * 3/3 - punto.height/2 - anchoSobrante * 3/4;
        g.setColor(Color.BLACK);
        switch (tiro){
            case 0:
                break;
            case 1:
                g.fillOval(centro, medio, anchoSobrante, anchoSobrante);
                break;
            case 2:
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                break;
            case 3:
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.fillOval(centro, medio, anchoSobrante, anchoSobrante);
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                break;
            case 4:
                g.fillOval(izquierda, arriba, anchoSobrante, anchoSobrante);
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.fillOval(derecha, abajo, anchoSobrante, anchoSobrante);
                break;
            case 5:
                g.fillOval(izquierda, arriba, anchoSobrante, anchoSobrante);
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.fillOval(derecha, abajo, anchoSobrante, anchoSobrante);
                g.fillOval(centro, medio, anchoSobrante, anchoSobrante);
                break;
            case 6:
                g.fillOval(izquierda, arriba, anchoSobrante, anchoSobrante);
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.fillOval(derecha, abajo, anchoSobrante, anchoSobrante);
                g.fillOval(izquierda, medio, anchoSobrante, anchoSobrante);
                g.fillOval(derecha, medio, anchoSobrante, anchoSobrante);
                break;
        }
    }

    public int tirar(){
        tiro = random.nextInt(6)+1;
        repaint();
        return tiro;
    }
}
