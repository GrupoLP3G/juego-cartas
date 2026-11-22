package juego.modelo.cartas;

import juego.modelo.Partida;

public class Antidoto extends Carta
{
    public Antidoto()
    {
        super("Antídoto", TipoCarta.APOYO, 1, "Quita todo el veneno", "antidoto");
    }
    @Override
    public void aplicar(Partida partida)
    {
        partida.quitarVeneno();
    }
}