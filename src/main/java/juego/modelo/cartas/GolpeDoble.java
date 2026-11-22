package juego.modelo.cartas;

import juego.modelo.Partida;

public class GolpeDoble extends Carta
{
    public GolpeDoble()
    {
        super("Golpe doble", TipoCarta.ATAQUE, 2, "Inflige 2 golpes de 4 de daño", "golpe_doble");
    }
    @Override
    public void aplicar(Partida partida)
    {
        partida.atacarJefe(4);
        partida.atacarJefe(4);
    }
}