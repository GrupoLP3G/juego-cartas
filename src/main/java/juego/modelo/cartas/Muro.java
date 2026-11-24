package juego.modelo.cartas;

import juego.modelo.Partida;

public class Muro extends Carta
{
    public Muro()
    {
        super("Muro", TipoCarta.DEFENSA, 2, "Gana 10 de escudo", "muro");
    }
    @Override
    public void aplicar(Partida partida)
    {
        partida.agregarEscudo(10);
    }
}