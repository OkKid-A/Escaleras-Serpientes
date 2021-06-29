package Casillas;

import Tablero.Ficha;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Casilla extends JLayeredPane {

    private Color color;
    private ArrayList<Ficha> fichas;
    private JLabel forma;
    private final Dimension punto = new Dimension(15, 15);


    public Casilla(Color color) {
        super();
        this.color = color;
        formarCasilla();
        fichas = new ArrayList<>();
    }

    public void formarCasilla() {
        removeAll();
        this.setOpaque(true);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(50, 50));
        this.setPreferredSize(new Dimension(50, 50));
        this.setBackground(color);
        this.setBorder(null);
        dibujarFichas();
        /*JLabel f = new JLabel();
        f.setText("MMM");
        f.setBackground(Color.blue);
        f.setOpaque(true);
        f.setBounds(0,0,50,50);
        this.add(f,0);*/
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D antiAlias = (Graphics2D) g;
        antiAlias.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int anchoSobrante = punto.height * 2/3;
        int izquierda = getWidth() * 1/3 - punto.width/2 - anchoSobrante * 1/4;
        int centro = getWidth() * 2/3 - punto.width/2 - anchoSobrante * 1/2;
        int derecha = getWidth() * 3/3 - punto.width/2 - anchoSobrante * 3/4;
        int arriba = getHeight() * 1/3 - punto.height/2 - anchoSobrante * 1/4;
        int medio = getHeight() * 2/3 - punto.height/2 - anchoSobrante * 1/2;
        int abajo = getHeight() * 3/3 - punto.height/2 - anchoSobrante * 3/4;
        switch (fichas.size()) {
            case 0:
                break;
            case 1:
                g.setColor(fichas.get(0).getColor());
                g.fillOval(centro, medio, anchoSobrante, anchoSobrante);
                break;
            case 2:
                g.setColor(fichas.get(0).getColor());
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(1).getColor());
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                break;
            case 3:
                g.setColor(fichas.get(0).getColor());
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(1).getColor());
                g.fillOval(centro, medio, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(2).getColor());
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                break;
            case 4:
                g.setColor(fichas.get(0).getColor());
                g.fillOval(izquierda, arriba, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(1).getColor());
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(2).getColor());
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(3).getColor());
                g.fillOval(derecha, abajo, anchoSobrante, anchoSobrante);
                break;
            case 5:
                g.setColor(fichas.get(0).getColor());
                g.fillOval(izquierda, arriba, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(1).getColor());
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(2).getColor());
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(3).getColor());
                g.fillOval(derecha, abajo, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(4).getColor());
                g.fillOval(centro, medio, anchoSobrante, anchoSobrante);
                break;
            case 6:
                g.setColor(fichas.get(0).getColor());
                g.fillOval(izquierda, arriba, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(1).getColor());
                g.fillOval(izquierda, abajo, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(2).getColor());
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(3).getColor());
                g.fillOval(derecha, abajo, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(4).getColor());
                g.fillOval(izquierda, medio, anchoSobrante, anchoSobrante);
                g.setColor(fichas.get(5).getColor());
                g.fillOval(derecha, medio, anchoSobrante, anchoSobrante);
                break;
        }
    }

    public void dibujarFichas() {


    }

    public void aplicarCondiciones(Ficha ficha) {
        agregarFicha(ficha);
    }

    public void agregarFicha(Ficha ficha) {
        fichas.add(ficha);
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    public void eliminarFicha(Ficha ficha) {
        fichas.remove(ficha);
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public JLabel getForma() {
        return forma;
    }

    public void setForma(JLabel forma) {
        this.forma = forma;
    }

    public Color getColor() {
        return color;
    }
}
