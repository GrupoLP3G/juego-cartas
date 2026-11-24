package juego.modelo.cartas;

import juego.modelo.Partida;

public class GolpeFuerte extends Carta
{
    public GolpeFuerte()
    {
        super("Golpe fuerte", TipoCarta.ATAQUE, 2, "Inflige 10 de daño", "golpe_fuerte");
    }
    @Override
    public void aplicar(Partida partida)
    {
        partida.atacarJefe(10);
    }
}