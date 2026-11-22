package juego.modelo.cartas;

import juego.modelo.Partida;

public class Contraataque extends Carta
{
    public Contraataque()
    {
        super("Contraataque", TipoCarta.ATAQUE, 1, "Inflige 3 de daño y gana 3 de escudo", "contraataque");
    }
    @Override
    public void aplicar(Partida partida)
    {
        partida.atacarJefe(3);
        partida.agregarEscudo(3);
    }
}