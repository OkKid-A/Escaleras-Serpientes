package Tablero;

public class Core {

    private Tablero tablero;
    private Dado dado;
    private int numTurno;

    public Core(Tablero tablero, Dado dado){
        this.tablero = tablero;
        this.dado = dado;
        numTurno = 0;
    }

    public void correrJuego(){
        while (5==5){
            for (int k = 0;k < tablero.getFichas().size();k++){
                tablero.pasarTurno(tablero.getFichas().get(k));
            }
        }
    }

    public void ejecutarTurno(int tiroDado){

    }
}
