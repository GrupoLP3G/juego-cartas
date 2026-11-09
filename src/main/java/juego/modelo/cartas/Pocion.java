package juego.modelo.cartas;

import juego.modelo.Partida;

public class Pocion extends Carta
{
    public Pocion()
    {
        super("Pocion", TipoCarta.APOYO, 2, "Recupera 5 de vida", "posion");
    }
    @Override 
    public void aplicar(Partida p)
    {
        p.curarJugador(5);
    }    
}
