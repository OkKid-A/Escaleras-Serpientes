package Casillas;

import Tablero.Ficha;

import javax.swing.*;
import java.awt.*;

public class Casilla extends JLayeredPane{

    private Color color;
    private Ficha[] fichas;
    private JLabel forma;

    public Casilla(Color color){
        super();
        this.color = color;
        formarCasilla();
    }

    public void formarCasilla(){
        this.setOpaque(true);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(50,50));
        this.setPreferredSize(new Dimension(50,50));
        this.setBackground(color);
        this.setBorder(null);
        /*JLabel f = new JLabel();
        f.setText("MMM");
        f.setBackground(Color.blue);
        f.setOpaque(true);
        f.setBounds(0,0,50,50);
        this.add(f,0);*/
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    public void procesarPaso(){

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
