package juego.modelo.cartas;

import juego.modelo.Partida;

public class Robo extends Carta
{
    public Robo()
    {
        super("Robo", TipoCarta.APOYO, 1, "Roba 2 cartas", "robo");
    }
    @Override
    public void aplicar(Partida partida)
    {
        partida.robarCartas(2);
    }
}