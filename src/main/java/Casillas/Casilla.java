package Casillas;

import Tablero.Ficha;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Casilla extends JLayeredPane{

    private Color color;
    private ArrayList<Ficha> fichas;
    private JLabel forma;

    public Casilla(Color color){
        super();
        this.color = color;
        formarCasilla();
        fichas = new ArrayList<>();
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void aplicarCondiciones(Ficha ficha){
        agregarFicha(ficha);
    }

    public void agregarFicha(Ficha ficha){
        fichas.add(ficha);
    }
    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    public void eliminarFicha(Ficha ficha){
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
