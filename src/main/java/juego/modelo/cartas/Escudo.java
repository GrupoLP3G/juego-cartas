package juego.modelo.cartas;

import juego.modelo.Partida;

public class Escudo extends Carta 
{
    public Escudo()
    {
        super("Escudo", TipoCarta.DEFENSA, 1
        , "Gana 5 de escudo", "escudo");
    }
    @Override 
    public void aplicar(Partida partida)
    {
        partida.agregarEscudo(5);
    }    
}
